package com.proyecto.fami.gestion_documental.domain.ports.output;

import com.proyecto.fami.gestion_documental.domain.model.EntregaRpp;
import java.util.List;
import java.util.Optional;

public interface EntregaRppPersistencePort {
    EntregaRpp save(EntregaRpp entrega);
    Optional<EntregaRpp> findById(String id);
    List<EntregaRpp> findByUsuarioFamiId(String userFamiId);
    List<EntregaRpp> findByMesAndGrupo(String mes, String grupo);
    void marcarInactivo(String id);
}