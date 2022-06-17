package com.neoris.tp2.entities.tiposJornadasEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tipo_jornada")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_jornada_obj")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class TipoJornadaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Setter protected String descripcion;
}
