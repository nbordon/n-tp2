package com.neoris.tp2.entities.tiposJornadasEntities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tipo_jornada")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_jornada_obj",discriminatorType = DiscriminatorType.INTEGER, columnDefinition = "TINYINT")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({
        @Type(value = TurnoNormalEntity.class, name = "1"),
        @Type(value = TurnoExtraEntity.class, name = "2"),
        @Type(value = DiaLibreEntity.class, name = "3"),
        @Type(value = VacacionesEntity.class, name = "4")
})
public abstract class TipoJornadaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Setter protected String descripcion;
}
