package com.proyecto.fami.gestion_documental.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "fami_home")
public class FamiHome {
    @Id
    @Field("id_fami_home")
    private String id;
    @Field("nombre_hogar")
    private String nombreHogar;
    @Field("direccion")
    private String direccion;
    @Field("modalidad")
    private String modalidad;
    @Field("servicio")
    private String servicio;
    @Field("nit")
    private String nit;
    @Field("barrio")
    private String barrio;
    @Field("regional")
    private String regional;
    @Field("centro_zonal")
    private String centroZonal;
    @Field("municipio")
    private String municipio;

    @Field("madre_comunitaria")
    private MadreComunitaria madreComunitaria;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MadreComunitaria {
        @Field("nombre_usuario")
        private String nombreUsuario;
        @Field("correo_electronico")
        private String correoElectronico;
        @Field("telefono_uds")
        private String telefonoUds;
        @Field("contraseña")
        private String contraseña;
        @Field("primer_nombre")
        private String primerNombre;
        @Field("segundo_nombre")
        private String segundoNombre;
        @Field("primer_apellido")
        private String primerApellido;
        @Field("segundo_apellido")
        private String segundoApellido;
        @Field("cedula")
        private String cedula;
        @Field("entidad_admin_servicio")
        private String entidadAdminServicio;
        @Field("codigo_cuentame_uds")
        private String codigoCuentameUds;
        @Field("numero_contrato")
        private String numeroContrato;
    }
}