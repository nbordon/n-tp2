package com.neoris.tp2.model;

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
    private Empleado empleado;
    private TipoJornada tipoJornada;
    private LocalDate fecha;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
}
