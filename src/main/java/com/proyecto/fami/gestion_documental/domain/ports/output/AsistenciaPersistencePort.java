package com.proyecto.fami.gestion_documental.domain.ports.output;

import com.proyecto.fami.gestion_documental.domain.model.Asistencia;
import java.util.List;
import java.util.Optional;

public interface AsistenciaPersistencePort {
    Asistencia save(Asistencia asistencia);
    Optional<Asistencia> findById(String id);
    List<Asistencia> findByUsuarioFamiId(String userFamiId);
    List<Asistencia> findByHogarIdAndMes(String hogarId, String mes);
    void marcarInactivo(String id); // soft delete si aplica
}