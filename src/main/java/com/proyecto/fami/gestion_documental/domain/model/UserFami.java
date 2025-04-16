package com.proyecto.fami.gestion_documental.domain.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "user_fami")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFami {
    @Id
    /** The unique identifier for the user. */
    private String id;
    @Field("tipo_usuario")
    /** The type of user (e.g., administrator, beneficiary). */
    private String tipoUsuario;
    @Field("nombre")
    /** The first name of the user. */
    private String nombre;
    @Field("segundo_nombre")
    @Nullable
    /** The user's second name, if any. */
    private String segundoNombre;
    @Field("apellido")
    /** The user's last name. */
    private String apellido;
    @Field("segundo_apellido")
    @Nullable
    /** The user's second last name, if any. */
    private String segundoApellido;
    @Field("tipo_documento")
    /** The type of identification document (e.g., CC, TI). */
    private String tipoDocumento;
    @Field("nuip")
    /** The user's unique national identification number. */
    private Integer nuip;
    @Field("fecha_nacimiento")
    /** The user's date of birth. */
    private Date fechaNacimiento;
    @Field("pais_nacimiento")
    private String paisNacimiento;
    @Field("departamento_nacimiento")
    private String departamentoNacimiento;
    @Field("ciudad_nacimiento")
    private String ciudadNacimiento;
    @Field("sexo")
    private String sexo;

    @Field("fecha_expedicion")
    private Date fechaExpedicion;
    @Field("pais_expedicion")
    private String paisExpedicion;
    @Field("departamento_expedicion")
    private String departamentoExpedicion;
    @Field("ciudad_expedicion")
    private String ciudadExpedicion;
    @Field("fecha_documento_recibido")
    private Byte[] fechaDocumentoRecibido;

    @Field("discapacidad")
    private Boolean discapacidad;
    @Field("tipo_discapacidad")
    private String tipoDiscapacidad;

    @Field("direccion")
    private String direccion;
    @Field("comuna")
    private String comuna;
    @Field("puntaje_SISBEN")
    @Nullable
    private String puntajeSISBEN;
    @Field("grupo_etnico")
    private String grupoEtnico;

    @Field("familia_desplazada")
    private Boolean familiaDesplazada;
    @Field("pertenece_red_unidos")
    private Boolean perteneceRedUnidos;
    @Field("folio_red_unidos")
    @Nullable
    private String folioRedUnidos;
    
    @Field("entidad_salud")
    private String entidadSalud;
    @Field("ars")
    private Boolean ars;
    @Field("eps")
    private Boolean eps;
    @Field("regimen_especial")
    private Boolean regimenEspecial;

    @Field("peso_nacer")
    @Nullable
    private Double pesoNacer;
    @Field("talla_nacer")
    @Nullable
    private Double tallaNacer;
    @Field("peso_actual")
    @Nullable
    private Double pesoActual;
    @Field("talla_actual")
    @Nullable
    private Double tallaActual;
    @Field("semanas_gestacion")
    @Nullable
    private Integer semanasGestacion;
    @Field("perimetro_branquial")
    @Nullable
    private Double perimetroBranquial;
    @Field("total_controles_ultimos_meses")
    @Nullable
    private Integer totalControlesUltimosMeses;
    @Field("vacunas_al_dia")
    @Nullable    
    private Boolean vacunasAlDia;

    @Field("coordenadas_gps")
    private CoordenadasGPS coordenadasGps;
    @Field("acudiente")
    private Acudiente acudiente;
    @Field("madre")
    private Familiar madre;
    @Field("padre")
    private Familiar padre;
    @Field("jefe_hogar")
    private JefeHogar jefeHogar;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CoordenadasGPS {
        @Field("latitud")
        private Double latitud;
        @Field("longitud")
        private Double longitud;
        @Field("hora_captura")
        private String horaCaptura;
        @Field("fecha_captura")
        private Date fechaCaptura;
        @Field("foto_coordenadas")
        private Byte[] fotoCoordenadas;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Acudiente {
        @Field("parentesco")
        private String parentesco;
        @Field("nombre")
        private String nombre;
        @Field("fecha_nacimiento")
        private Date fechaNacimiento;
        @Field("lugar_nacimiento")
        private String lugarNacimiento;
        @Field("tipo_documento")
        private String tipoDocumento;
        @Field("nuip")
        private Integer nuip;
        @Field("fecha_expedicion")
        private Date fechaExpedicion;
        @Field("lugar_expedicion")
        private String lugarExpedicion;
        @Field("celular")
        private String celular;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Familiar {
        @Field("nombre")
        private String nombre;
        @Field("fecha_nacimiento")
        private Date fechaNacimiento;
        @Field("lugar_nacimiento")
        private String lugarNacimiento;
        @Field("tipo_documento")
        private String tipoDocumento;
        @Field("nuip")
        private Integer nuip;
        @Field("fecha_expedicion")
        private Date fechaExpedicion;
        @Field("lugar_expedicion")
        private String lugarExpedicion;
        @Field("celular")
        private String celular;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JefeHogar {
        @Field("parentesco")
        private String parentesco;
        @Field("nombre")
        private String nombre;
        @Field("nuip")
        private Integer nuip;
        @Field("ubicacion")
        private String ubicacion;
        @Field("tipo_vinculacion")
        @Nullable
        private String tipoVinculacion;
        @Nullable
        @Field("trabaja_actualmente")
        private Boolean trabajaActualmente;
    }

    @Field("fecha_ingreso_usuario")
    private Date fechaIngresoUsuario;
    @Field("fecha_registro_sistema")
    private Date fechaRegistroSistema;
    @Field("causa_retiro")
    @Nullable
    private String causaRetiro;
}