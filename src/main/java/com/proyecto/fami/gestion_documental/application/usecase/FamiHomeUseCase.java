package com.proyecto.fami.gestion_documental.application.usecase;

import com.proyecto.fami.gestion_documental.domain.model.FamiHome;
import com.proyecto.fami.gestion_documental.domain.ports.input.FamiHomeServicePort;
import com.proyecto.fami.gestion_documental.domain.ports.output.FamiHomePersistencePort;

import java.util.Optional;
import java.util.List;

public class FamiHomeUseCase implements FamiHomeServicePort {

    private final FamiHomePersistencePort persistencePort;

    public FamiHomeUseCase(FamiHomePersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public FamiHome registrar(FamiHome famiHome) {
        return persistencePort.save(famiHome);
    }

    @Override
    public Optional<FamiHome> login(String nombreUsuario, String contraseña) {
        Optional<FamiHome> hogar = persistencePort.findByNombreUsuarioAndActivoTrue(nombreUsuario);
        return hogar.filter(h -> h.getMadreComunitaria().getContraseña().equals(contraseña)); // ⚠️ aquí va hashing real
    }

    @Override
    public Optional<FamiHome> obtenerPorId(String id) {
        return persistencePort.findById(id);
    }

    @Override
    public List<FamiHome> obtenerTodos() {
        return persistencePort.findAllByActivoTrue();
    }

    @Override
    public void actualizarPerfil(String id, FamiHome.MadreComunitaria datosActualizados) {
        persistencePort.updateMadreComunitariaDatos(id, datosActualizados);
    }

    @Override
    public void eliminarLogicamente(String id) {
        persistencePort.disableFamiHome(id);
    }

    @Override
    public void actualizarContraseña(String id, String nuevaContraseña) {
        persistencePort.updatePassword(id, nuevaContraseña);
    }
}
