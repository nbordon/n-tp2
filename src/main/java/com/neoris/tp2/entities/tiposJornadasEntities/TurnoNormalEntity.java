package com.neoris.tp2.entities.tiposJornadasEntities;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
@JsonTypeName("1")
public class TurnoNormalEntity extends TipoJornadaEntity{
}
