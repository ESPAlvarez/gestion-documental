package com.proyecto.fami.gestion_documental.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "asistencia")
public class Asistencia {

    @Id
    @Field("id_asistencia")
    private String id;
    @Field("id_usuario_fami")
    private String idUsuarioFami;
    @Field("id_hogar_fami")
    private String idHogarFami;
    @Field("año")
    private Integer anio;
    @Field("mes")
    private String mes;
    @Field("semana")
    private String semana;
    @Field("dia_semana")
    private String diaSemana;
    @Field("asistio")
    private Boolean asistio;
}