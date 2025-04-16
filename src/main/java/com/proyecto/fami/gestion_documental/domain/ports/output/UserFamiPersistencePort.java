package com.proyecto.fami.gestion_documental.domain.ports.output;

import com.proyecto.fami.gestion_documental.domain.model.UserFami;
import java.util.List;
import java.util.Optional;

public interface UserFamiPersistencePort {
    UserFami save(UserFami user);
    Optional<UserFami> findById(String id);
    List<UserFami> findAllActivos(); // para evitar mostrar eliminados
    List<UserFami> findByTipoUsuario(String tipoUsuario); // lactante, gestante…
    void marcarInactivo(String id); // soft delete
    boolean existsByNuip(Integer nuip); // validación duplicados
}
