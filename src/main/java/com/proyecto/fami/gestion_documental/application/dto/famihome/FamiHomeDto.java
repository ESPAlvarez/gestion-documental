package com.proyecto.fami.gestion_documental.application.dto.famihome;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FamiHomeDto {

    @NotBlank(message = "El nombre del hogar es obligatorio")
    private String nombreHogar;
    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;
    @NotBlank(message = "La modalidad es obligatoria")
    private String modalidad;
    @NotBlank(message = "El tipo de servicio es obligatorio")
    private String servicio;
    @NotBlank(message = "El NIT es obligatorio")
    @Pattern(regexp = "^[0-9A-Za-z\\-]{5,20}$", message = "El NIT debe tener un formato válido")
    private String nit;
    @NotBlank(message = "El barrio es obligatorio")
    private String barrio;
    @NotBlank(message = "La regional es obligatoria")
    private String regional;
    @NotBlank(message = "El centro zonal es obligatorio")
    private String centroZonal;
    @NotBlank(message = "El municipio es obligatorio")
    private String municipio;

    @Builder.Default
    private Boolean activo = true; // Por defecto, el hogar está activo
    @Valid
    @NotNull(message = "Los datos de la madre comunitaria son obligatorios")
    private MadreComunitariaDto madreComunitaria;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MadreComunitariaDto {

        @NotBlank(message = "El nombre de usuario es obligatorio")
        @Size(min = 5, max = 20, message = "El nombre de usuario debe tener entre 5 y 20 caracteres")
        private String nombreUsuario;
        @NotBlank(message = "El correo electrónico es obligatorio")
        @Email(message = "El correo electrónico debe tener un formato válido")
        private String correoElectronico;
        @NotBlank(message = "El número de teléfono es obligatorio")
        @Pattern(regexp = "^[0-9]{7,10}$", message = "Número telefónico inválido")
        private String telefonoUds;
        @NotBlank(message = "La contraseña es obligatoria")
        @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
        @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Debe contener al menos una mayúscula, una minúscula, un número y un carácter especial"
        )
        private String contraseña;
        @NotBlank(message = "El primer nombre es obligatorio")
        private String primerNombre;
        private String segundoNombre;
        @NotBlank(message = "El primer apellido es obligatorio")
        private String primerApellido;
        private String segundoApellido;
        @NotBlank(message = "La cédula es obligatoria")
        @Pattern(regexp = "^[0-9]{6,10}$", message = "Cédula inválida")
        private String cedula;
        private String entidadAdminServicio;
        private String codigoCuentameUds;
        private String numeroContrato;

        @Builder.Default
        private Boolean activo = true; // Por defecto, la madre está activa
    }
}