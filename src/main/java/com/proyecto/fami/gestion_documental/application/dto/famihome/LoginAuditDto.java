package com.proyecto.fami.gestion_documental.application.dto.famihome;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO para auditoría de intentos de inicio de sesión.
 * Registra quién intentó iniciar sesión, cuándo, desde qué IP y si fue exitoso.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginAuditDto {

    /**
     * Nombre de usuario o identificador que se utilizó para el intento.
     */
    private String username;

    /**
     * Fecha y hora del intento de inicio de sesión.
     */
    private LocalDateTime timestamp;

    /**
     * Dirección IP desde donde se realizó el intento.
     */
    private String ipAddress;

    /**
     * Indica si el inicio de sesión fue exitoso.
     */
    private boolean success;

    /**
     * (Opcional) Mensaje adicional o razón de fallo en caso de error.
     */
    private String message;
}
