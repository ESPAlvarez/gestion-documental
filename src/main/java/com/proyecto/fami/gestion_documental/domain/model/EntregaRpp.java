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
@Document(collection = "entrega_rpp")
public class EntregaRpp {

    @Id
    @Field("id_entrega_rpp")
    private String id;
    @Field("id_usuario_fami")
    private String idUsuarioFami;
    @Field("id_hogar_fami")
    private String idHogarFami;
    @Field("fecha_entrega_rpp")
    private String fechaEntregaRpp;
    @Field("grupo_poblacional")
    private String grupoPoblacional;

    @Field("arroz_blanco_500g")
    private Double arrozBlanco;
    @Field("pastas_enriquecidas_500g_750g")
    private Double pastasEnriquecidas;
    @Field("avena_hojuelas_250g_1000g")
    private Double avenaHojuelas;
    @Field("harina_trigo_1000g")
    private Double harinaTrigo;
    @Field("harina_maiz_500g")
    private Double harinaMaiz;
    @Field("leche_polvo_900g_800g")
    private Double lechePolvo;
    @Field("atun_1050g")
    private Double atun;
    @Field("huevos_1650g_30uni")
    private Double huevos;
    @Field("frijol_500g")
    private Double frijol;
    @Field("lenteja_500g")
    private Double lenteja;
    @Field("aceite_500ml")
    private Double aceite;
    @Field("panela_500g")
    private Double panela;

    @Field("aavn_1")
    private String aavn1;
    @Field("aavn_1_lote")
    private String aavn1Lote;
    @Field("aavn_2")
    private String aavn2;
    @Field("aavn_2_lote")
    private String aavn2Lote;
}
