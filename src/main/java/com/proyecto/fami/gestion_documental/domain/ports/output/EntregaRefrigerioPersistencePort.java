package com.proyecto.fami.gestion_documental.domain.ports.output;

import com.proyecto.fami.gestion_documental.domain.model.EntregaRefrigerio;
import java.util.List;
import java.util.Optional;

public interface EntregaRefrigerioPersistencePort {
    EntregaRefrigerio save(EntregaRefrigerio entrega);
    Optional<EntregaRefrigerio> findById(String id);
    List<EntregaRefrigerio> findByUsuarioFamiId(String userFamiId);
    List<EntregaRefrigerio> findByEncuentroAndGrupo(int numero, String grupoPoblacional);
    void marcarInactivo(String id);
}