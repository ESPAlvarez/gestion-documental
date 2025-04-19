package com.proyecto.fami.gestion_documental.application.dto.famihome;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para la actualización segura de contraseña
 * Aplicable tanto para madre comunitaria como para administradores (RF-12).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PasswordUpdateRequest {

    @NotBlank(message = "El nombre de usuario es obligatorio")
    private String nombreUsuario;

    @NotBlank(message = "La nueva contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
        message = "La contraseña debe incluir al menos una mayúscula, una minúscula, un número y un carácter especial"
    )
    private String nuevaContraseña;

    /**
     * Campo opcional en caso de que la madre quiera confirmar su contraseña anterior antes del cambio.
     */
    private String contraseñaActual;
}
