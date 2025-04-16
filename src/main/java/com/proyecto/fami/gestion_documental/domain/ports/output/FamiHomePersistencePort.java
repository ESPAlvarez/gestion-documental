package com.proyecto.fami.gestion_documental.domain.ports.output;

import com.proyecto.fami.gestion_documental.domain.model.FamiHome;
import java.util.List;
import java.util.Optional;

public interface FamiHomePersistencePort {
    FamiHome save(FamiHome home);
    Optional<FamiHome> findById(String id);
    Optional<FamiHome> findByNombreUsuario(String username); // para login
    List<FamiHome> findAll();
    void updatePassword(String id, String hashedPassword); // soporte RNF seguridad
    boolean existsByCedula(String cedula); // evitar duplicados
}