package com.proyecto.fami.gestion_documental.application.dto.famihome;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para visualizar y editar el perfil de una madre comunitaria (RF-5).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MadreComunitariaProfileDto {

    @NotBlank(message = "El nombre de usuario es obligatorio")
    private String nombreUsuario;
    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico debe tener un formato válido")
    private String correoElectronico;
    @NotBlank(message = "El número de teléfono es obligatorio")
    @Pattern(regexp = "^[0-9]{7,10}$", message = "Número telefónico inválido")
    private String telefonoUds;
    @NotBlank(message = "El primer nombre es obligatorio")
    private String primerNombre;
    private String segundoNombre;
    @NotBlank(message = "El primer apellido es obligatorio")
    private String primerApellido;
    private String segundoApellido;
    @NotBlank(message = "La cédula es obligatoria")
    @Pattern(regexp = "^[0-9]{6,12}$", message = "Cédula inválida")
    private String cedula;

    private String entidadAdminServicio;
    private String codigoCuentameUds;
    private String numeroContrato;

    private Boolean activo;
}