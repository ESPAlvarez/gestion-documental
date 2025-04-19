package com.proyecto.fami.gestion_documental.application.dto.famihome;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para actualización parcial de los datos de la madre comunitaria.
 * Sólo los campos incluidos aquí podrán modificarse.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MadreComunitariaUpdateDto {

    /**
     * Correo electrónico (se puede cambiar).
     */
    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico debe ser válido")
    private String correoElectronico;

    /**
     * Teléfono de la UDS.
     */
    @NotBlank(message = "El número de teléfono es obligatorio")
    @Pattern(
        regexp = "^[0-9]{7,10}$",
        message = "El teléfono debe contener sólo dígitos (7-10 caracteres)"
    )
    private String telefonoUds;

    /**
     * Primer nombre.
     */
    @NotBlank(message = "El primer nombre es obligatorio")
    private String primerNombre;

    /**
     * Segundo nombre (opcional).
     */
    private String segundoNombre;

    /**
     * Primer apellido.
     */
    @NotBlank(message = "El primer apellido es obligatorio")
    private String primerApellido;

    /**
     * Segundo apellido (opcional).
     */
    private String segundoApellido;

    /**
     * Entidad administradora del servicio (opcional).
     */
    private String entidadAdminServicio;

    /**
     * Código "cuéntame UDS" (opcional).
     */
    private String codigoCuentameUds;

    /**
     * Número de contrato (opcional).
     */
    private String numeroContrato;

    /**
     * Marca de actividad (puede usarla el admin para desactivar la madre).
     */
    private Boolean activo;
}