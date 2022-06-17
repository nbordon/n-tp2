package com.neoris.tp2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neoris.tp2.model.tiposJornadas.TipoJornada;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JornadaLaboral {
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String TIME_PATTERN = "HH:mm";

    @JsonIgnore
    private Empleado empleado;
    @JsonIgnore
    private TipoJornada tipoJornada;
    @JsonFormat(pattern = DATE_PATTERN)
    private LocalDate fecha;
    @JsonFormat(pattern = TIME_PATTERN)
    private LocalTime horaEntrada;
    @JsonFormat(pattern = TIME_PATTERN)
    private LocalTime horaSalida;
}
