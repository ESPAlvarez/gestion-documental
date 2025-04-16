package com.proyecto.fami.gestion_documental.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "entrega_refrigerio")
public class EntregaRefrigerio {

    @Id
    @Field("id_entrega_refrigerio")
    private String id;
    @Field("id_usuario_fami")
    private String idUsuarioFami;
    @Field("id_hogar_fami")
    private String idHogarFami;

    @Field("encuentro_numero")
    private Integer encuentroNumero;
    @Field("fecha_entrega")
    private Date fechaEntrega;
    @Field("grupo_poblacional")
    private String grupoPoblacional;
    @Field("asiste_con_acompanante")
    private String asisteConAcompanante;

    @Field("fruta")
    private Double fruta;
    @Field("papilla_cereal")
    private Double papillaCereal;
    @Field("alimento_lacteo")
    private Double alimentoLacteo;
    @Field("jugo_fruta")
    private Double jugoFruta;
    @Field("panaderia")
    private Double panaderia;
    @Field("otro_concertado")
    private Double otroConcertado;
    
    @Field("observaciones")
    private String observaciones;
}