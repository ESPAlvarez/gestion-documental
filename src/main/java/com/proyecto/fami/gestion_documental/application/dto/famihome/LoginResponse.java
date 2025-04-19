package com.proyecto.fami.gestion_documental.application.dto.famihome;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse {

    /**
     * Token de autenticación (JWT).
     */
    private String token;

    /**
     * Nombre completo de la madre comunitaria (útil para mostrar en el dashboard).
     */
    private String nombreCompleto;

    /**
     * ID del hogar FAMI asociado (clave para cargar usuarios, entregas, etc.).
     */
    private String idHogarFami;

    /**
     * Nombre del hogar FAMI (para mostrar en la interfaz).
     */
    private String nombreHogar;

    /**
     * Rol del usuario autenticado (por ahora solo "madre_comunitaria", en el futuro "admin").
     */
    private String rol;

    /**
     * Estado del usuario (activo o inactivo).
     */
    private boolean activo;
}
