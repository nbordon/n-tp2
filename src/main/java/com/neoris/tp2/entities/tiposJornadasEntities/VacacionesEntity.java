package com.neoris.tp2.entities.tiposJornadasEntities;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("4")
@JsonTypeName("4")
public class VacacionesEntity extends TipoJornadaEntity{
}
