package com.neoris.tp2.entities.tiposJornadasEntities;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
@JsonTypeName("2")
public class TurnoExtraEntity extends TipoJornadaEntity{
}
