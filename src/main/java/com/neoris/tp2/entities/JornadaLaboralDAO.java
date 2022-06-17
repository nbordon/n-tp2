package com.neoris.tp2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jornada_laboral")
public class JornadaLaboralDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empleado_id",referencedColumnName = "id")
    private EmpleadoDAO empleado;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_jornada_id", referencedColumnName = "id")
    private TipoJornadaDAO tipoJornada;

}
