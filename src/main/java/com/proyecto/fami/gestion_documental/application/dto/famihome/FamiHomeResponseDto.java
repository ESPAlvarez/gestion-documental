package com.proyecto.fami.gestion_documental.application.dto.famihome;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de respuesta ligera para Hogar Comunitario FAMI.
 * Se usa tanto para listados de hogares (admin) como para mostrar el perfil
 * de la madre comunitaria con los datos de su hogar.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FamiHomeResponseDto {

    /**
     * Identificador único del hogar FAMI.
     */
    private String id;

    /**
     * Nombre oficial del hogar comunitario.
     */
    private String nombreHogar;

    /**
     * Dirección física del hogar.
     */
    private String direccion;

    /**
     * Modalidad de atención del hogar.
     */
    private String modalidad;

    /**
     * Tipo de servicio o tiempo de atención.
     */
    private String servicio;

    /**
     * NIT del ICBF asociado al hogar.
     */
    private String nit;

    /**
     * Barrio donde se ubica el hogar.
     */
    private String barrio;

    /**
     * Regional o zona territorial asignada.
     */
    private String regional;

    /**
     * Centro zonal (urbano, rural, veredal).
     */
    private String centroZonal;

    /**
     * Municipio donde opera el hogar.
     */
    private String municipio;

    /**
     * Indica si el hogar está activo o ha sido deshabilitado (soft delete).
     */
    private Boolean activo;

    /**
     * Datos de la madre comunitaria administradora de este hogar.
     */
    private MadreComunitariaResponseDto madreComunitaria;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MadreComunitariaResponseDto {

        /**
         * Nombre de usuario para login.
         */
        private String nombreUsuario;

        /**
         * Correo electrónico de contacto.
         */
        private String correoElectronico;

        /**
         * Teléfono de la UDS.
         */
        private String telefonoUds;

        /**
         * Primer nombre de la madre comunitaria.
         */
        private String primerNombre;

        /**
         * Segundo nombre (opcional).
         */
        private String segundoNombre;

        /**
         * Primer apellido.
         */
        private String primerApellido;

        /**
         * Segundo apellido (opcional).
         */
        private String segundoApellido;

        /**
         * Número de cédula.
         */
        private String cedula;

        /**
         * Entidad administradora del servicio (opcional).
         */
        private String entidadAdminServicio;

        /**
         * Código "Cuéntame UDS" (opcional).
         */
        private String codigoCuentameUds;

        /**
         * Número de contrato de la madre comunitaria (opcional).
         */
        private String numeroContrato;

        /**
         * Indica si la madre comunitaria está activa o ha sido deshabilitada.
         */
        private Boolean activo;
    }
}
