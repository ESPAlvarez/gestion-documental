package com.proyecto.fami.gestion_documental.domain.ports.input;

import com.proyecto.fami.gestion_documental.domain.model.FamiHome;

import java.util.Optional;
import java.util.List;

public interface FamiHomeServicePort {
    FamiHome registrar(FamiHome famiHome); // RF-1
    Optional<FamiHome> login(String nombreUsuario, String contraseña); // RF-2
    Optional<FamiHome> obtenerPorId(String id);
    List<FamiHome> obtenerTodos(); // Para admin
    void actualizarPerfil(String id, FamiHome.MadreComunitaria datosActualizados); // RF-5
    void eliminarLogicamente(String id); // RF-10
    void actualizarContraseña(String id, String nuevaContraseña); // RF-12
}
