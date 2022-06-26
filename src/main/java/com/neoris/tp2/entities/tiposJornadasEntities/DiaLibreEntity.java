package com.neoris.tp2.entities.tiposJornadasEntities;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("3")
@JsonTypeName("3")
public class DiaLibreEntity extends TipoJornadaEntity{
}
