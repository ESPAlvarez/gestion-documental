package com.proyecto.fami.gestion_documental.domain.ports.input;

import com.proyecto.fami.gestion_documental.application.dto.famihome.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FamiHomeServicePort {

    /**
     * RF-1: Registro completo del hogar FAMI con madre comunitaria.
     */
    FamiHomeResponseDto registrarHogar(FamiHomeDto hogarDto);

    /**
     * RF-2: Inicio de sesión.
     */
    LoginResponse login(LoginRequest request);

    /**
     * RF-5: Obtener perfil de madre comunitaria (por ID hogar).
     */
    MadreComunitariaProfileDto obtenerPerfil(String idFamiHome);

    /**
     * RF-5: Actualizar parcialmente datos del perfil de la madre.
     */
    MadreComunitariaProfileDto actualizarDatosMadre(String idFamiHome, MadreComunitariaUpdateDto updateDto);

    /**
     * RF-12: Cambiar la contraseña de la madre comunitaria.
     */
    void actualizarContraseña(PasswordUpdateRequest request);

    /**
     * RF-7/RF-9: Obtener hogares FAMI activos con paginación.
     */
    Page<FamiHomeResponseDto> obtenerTodosActivos(Pageable pageable);

    /**
     * RF-7: Filtrar por municipio o regional.
     */
    List<FamiHomeResponseDto> obtenerPorMunicipio(String municipio);
    List<FamiHomeResponseDto> obtenerPorRegional(String regional);

    /**
     * RF-10: Soft delete del hogar o de la madre comunitaria.
     */
    void desactivarHogar(String idFamiHome);
    void desactivarMadreComunitaria(String idFamiHome);

    /**
     * Validación para evitar registros duplicados.
     */
    boolean cedulaYaRegistrada(String cedula);
}
