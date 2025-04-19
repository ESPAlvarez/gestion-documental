package com.proyecto.fami.gestion_documental.application.usecase;

import com.proyecto.fami.gestion_documental.application.dto.famihome.*;
import com.proyecto.fami.gestion_documental.application.security.JwtService;
import com.proyecto.fami.gestion_documental.domain.model.FamiHome;
import com.proyecto.fami.gestion_documental.domain.ports.input.FamiHomeServicePort;
import com.proyecto.fami.gestion_documental.domain.ports.output.FamiHomePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FamiHomeUseCase implements FamiHomeServicePort {

    private final FamiHomePersistencePort persistence;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService; // tu servicio para generar JWT

    @Override
    public FamiHomeResponseDto registrarHogar(FamiHomeDto dto) {
        // Evitar cédulas duplicadas
        String cedula = dto.getMadreComunitaria().getCedula();
        if (cedulaYaRegistrada(cedula)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La cédula ya está registrada");
        }

        // Hashear contraseña
        dto.getMadreComunitaria()
           .setContraseña(passwordEncoder.encode(dto.getMadreComunitaria().getContraseña()));

        // Mapear a entidad de dominio
        FamiHome entity = mapToEntity(dto);

        // Guardar
        FamiHome saved = persistence.save(entity);

        // Devolver DTO de respuesta
        return mapToResponseDto(saved);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        final FamiHome home = persistence
            .findByNombreUsuarioAndActivoTrue(request.getNombreUsuario())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario o contraseña inválidos"));

        if (!passwordEncoder.matches(request.getContraseña(), home.getMadreComunitaria().getContraseña())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario o contraseña inválidos");
        }

        // Generar token
        String token = jwtService.generateToken(home.getMadreComunitaria().getNombreUsuario());

        return LoginResponse.builder()
                .token(token)
                .nombreCompleto(home.getMadreComunitaria().getPrimerNombre() + " " +
                                home.getMadreComunitaria().getPrimerApellido())
                .idHogarFami(home.getId())
                .nombreHogar(home.getNombreHogar())
                .rol("madre_comunitaria")
                .activo(home.getMadreComunitaria().getActivo())
                .build();
    }

    @Override
    public MadreComunitariaProfileDto obtenerPerfil(String idFamiHome) {
        FamiHome home = persistence.findById(idFamiHome)
                .orElseThrow(() -> new RuntimeException("Hogar no encontrado"));
        return mapToProfileDto(home);
    }

    @Override
    public MadreComunitariaProfileDto actualizarDatosMadre(String idFamiHome, MadreComunitariaUpdateDto upd) {
        // Mapear a dominio parcial
        FamiHome.MadreComunitaria datos = FamiHome.MadreComunitaria.builder()
                .correoElectronico(upd.getCorreoElectronico())
                .telefonoUds(upd.getTelefonoUds())
                .primerNombre(upd.getPrimerNombre())
                .segundoNombre(upd.getSegundoNombre())
                .primerApellido(upd.getPrimerApellido())
                .segundoApellido(upd.getSegundoApellido())
                .entidadAdminServicio(upd.getEntidadAdminServicio())
                .codigoCuentameUds(upd.getCodigoCuentameUds())
                .numeroContrato(upd.getNumeroContrato())
                .activo(upd.getActivo())
                .build();

        persistence.updateMadreComunitariaDatos(idFamiHome, datos);

        // Devolver perfil actualizado
        return obtenerPerfil(idFamiHome);
    }

    @Override
    public void actualizarContraseña(PasswordUpdateRequest req) {
        FamiHome home = persistence
            .findByNombreUsuarioAndActivoTrue(req.getNombreUsuario())
            .orElseThrow(() -> new RuntimeException("Madre comunitaria no encontrada"));

        String newHashed = passwordEncoder.encode(req.getNuevaContraseña());
        persistence.updatePassword(home.getId(), newHashed);
    }

    @Override
    public Page<FamiHomeResponseDto> obtenerTodosActivos(Pageable pageable) {
        return persistence.findAllByActivoTrue(pageable)
                          .map(this::mapToResponseDto);
    }

    @Override
    public List<FamiHomeResponseDto> obtenerPorMunicipio(String municipio) {
        return persistence.findByMunicipioAndActivoTrue(municipio)
                          .stream()
                          .map(home -> mapToResponseDto(home))
                          .collect(Collectors.toList());
    }

    @Override
    public List<FamiHomeResponseDto> obtenerPorRegional(String regional) {
        return persistence.findByRegionalAndActivoTrue(regional)
                          .stream()
                          .map(home -> (FamiHomeResponseDto) this.mapToResponseDto(home))
                          .collect(Collectors.toList());
    }

    @Override
    public void desactivarHogar(String idFamiHome) {
        persistence.disableFamiHome(idFamiHome);
    }

    @Override
    public void desactivarMadreComunitaria(String idFamiHome) {
        persistence.disableMadreComunitaria(idFamiHome);
    }

    @Override
    public boolean cedulaYaRegistrada(String cedula) {
        return persistence.existsByMadreComunitariaCedula(cedula);
    }

    // ------------------------------
    // Métodos auxiliares de mapeo
    // ------------------------------

    private FamiHome mapToEntity(FamiHomeDto dto) {
        return FamiHome.builder()
                .nombreHogar(dto.getNombreHogar())
                .direccion(dto.getDireccion())
                .modalidad(dto.getModalidad())
                .servicio(dto.getServicio())
                .nit(dto.getNit())
                .barrio(dto.getBarrio())
                .regional(dto.getRegional())
                .centroZonal(dto.getCentroZonal())
                .municipio(dto.getMunicipio())
                .activo(dto.getActivo())
                .madreComunitaria(
                    FamiHome.MadreComunitaria.builder()
                        .nombreUsuario(dto.getMadreComunitaria().getNombreUsuario())
                        .correoElectronico(dto.getMadreComunitaria().getCorreoElectronico())
                        .telefonoUds(dto.getMadreComunitaria().getTelefonoUds())
                        .contraseña(dto.getMadreComunitaria().getContraseña())
                        .primerNombre(dto.getMadreComunitaria().getPrimerNombre())
                        .segundoNombre(dto.getMadreComunitaria().getSegundoNombre())
                        .primerApellido(dto.getMadreComunitaria().getPrimerApellido())
                        .segundoApellido(dto.getMadreComunitaria().getSegundoApellido())
                        .cedula(dto.getMadreComunitaria().getCedula())
                        .entidadAdminServicio(dto.getMadreComunitaria().getEntidadAdminServicio())
                        .codigoCuentameUds(dto.getMadreComunitaria().getCodigoCuentameUds())
                        .numeroContrato(dto.getMadreComunitaria().getNumeroContrato())
                        .activo(dto.getMadreComunitaria().getActivo())
                        .build()
                )
                .build();
    }

    private FamiHomeResponseDto mapToResponseDto(FamiHome home) {
        return FamiHomeResponseDto.builder()
                .id(home.getId())
                .nombreHogar(home.getNombreHogar())
                .direccion(home.getDireccion())
                .modalidad(home.getModalidad())
                .servicio(home.getServicio())
                .nit(home.getNit())
                .barrio(home.getBarrio())
                .regional(home.getRegional())
                .centroZonal(home.getCentroZonal())
                .municipio(home.getMunicipio())
                .activo(home.getActivo())
                .madreComunitaria(
                    FamiHomeResponseDto.MadreComunitariaResponseDto.builder()
                        .nombreUsuario(home.getMadreComunitaria().getNombreUsuario())
                        .correoElectronico(home.getMadreComunitaria().getCorreoElectronico())
                        .telefonoUds(home.getMadreComunitaria().getTelefonoUds())
                        .primerNombre(home.getMadreComunitaria().getPrimerNombre())
                        .segundoNombre(home.getMadreComunitaria().getSegundoNombre())
                        .primerApellido(home.getMadreComunitaria().getPrimerApellido())
                        .segundoApellido(home.getMadreComunitaria().getSegundoApellido())
                        .cedula(home.getMadreComunitaria().getCedula())
                        .entidadAdminServicio(home.getMadreComunitaria().getEntidadAdminServicio())
                        .codigoCuentameUds(home.getMadreComunitaria().getCodigoCuentameUds())
                        .numeroContrato(home.getMadreComunitaria().getNumeroContrato())
                        .activo(home.getMadreComunitaria().getActivo())
                        .build()
                )
                .build();
    }

    private MadreComunitariaProfileDto mapToProfileDto(FamiHome home) {
        var m = home.getMadreComunitaria();
        return MadreComunitariaProfileDto.builder()
                .nombreUsuario(m.getNombreUsuario())
                .correoElectronico(m.getCorreoElectronico())
                .telefonoUds(m.getTelefonoUds())
                .primerNombre(m.getPrimerNombre())
                .segundoNombre(m.getSegundoNombre())
                .primerApellido(m.getPrimerApellido())
                .segundoApellido(m.getSegundoApellido())
                .cedula(m.getCedula())
                .entidadAdminServicio(m.getEntidadAdminServicio())
                .codigoCuentameUds(m.getCodigoCuentameUds())
                .numeroContrato(m.getNumeroContrato())
                .activo(m.getActivo())
                .build();
    }
}