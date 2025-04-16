package com.proyecto.fami.gestion_documental.domain.ports.output;

import java.io.ByteArrayOutputStream;

public interface ExportacionPort {
    ByteArrayOutputStream exportarUserFami(); // otros métodos: asistencia, rpp, etc.
    void registrarLogExportacion(String usuarioId, String tipoExportacion, String fecha);
}