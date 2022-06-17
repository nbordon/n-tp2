package com.neoris.tp2.entities;

import com.neoris.tp2.entities.tiposJornadas.TipoJornadaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jornada_laboral")
public class JornadaLaboralEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empleado_id",referencedColumnName = "id")
    private EmpleadoEntity empleado;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_jornada_id", referencedColumnName = "id")
    private TipoJornadaEntity tipoJornada;
    private LocalDate fecha;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;

}
