package com.neoris.tp2.services;

import com.neoris.tp2.entities.EmpleadoEntity;
import com.neoris.tp2.entities.JornadaLaboralEntity;
import com.neoris.tp2.exceptions.HorasMaximasSemanalesException;
import com.neoris.tp2.exceptions.HorasMinimasSinCargarException;
import com.neoris.tp2.exceptions.ResourcesNotFoundException;
import com.neoris.tp2.model.JornadaLaboral;
import com.neoris.tp2.repositories.JornadaLaboralRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

@Service
@Slf4j
public class JornadaLaboralService {
    private static final long HORAS_MAXIMAS_DE_TRABAJO = 48;
    private static final long HORAS_MINIMAS_DE_TRABAJO = 30;
    @Autowired
    private JornadaLaboralRepository repository;

    // Crear jornada laboral
    public JornadaLaboralEntity crear(JornadaLaboral jornadaLaboral, EmpleadoEntity empleado) throws HorasMinimasSinCargarException,HorasMaximasSemanalesException {
        // Valido si cumple con las horas minimas cargadas de la semana anterior
        JornadaLaboralEntity jornadaLaboralEntity = new JornadaLaboralEntity();
        jornadaLaboralEntity.setEmpleado(empleado);
        jornadaLaboralEntity.setFecha(jornadaLaboral.getFecha());
        jornadaLaboralEntity.setHoraEntrada(jornadaLaboral.getHoraEntrada());
        jornadaLaboralEntity.setHoraSalida(jornadaLaboral.getHoraSalida());
        if(!superaHorasMinimasDeLaSemanaAnterior(jornadaLaboralEntity))
            throw new HorasMinimasSinCargarException(empleado.getId());
        if(superaHorasMaximasDeLaSemanaActual(jornadaLaboralEntity))
            throw new HorasMaximasSemanalesException(empleado.getId());
        return repository.save(jornadaLaboralEntity);
    }

    // Listar jornadas para un empleado
    public List<JornadaLaboralEntity> listarJornadas(EmpleadoEntity empleado){
        return repository.findAllByEmpleado(empleado);
    }

    // Obtener jornada por id
    public JornadaLaboralEntity obtenerJornada(Integer id) throws ResourcesNotFoundException{
        return repository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("No se encontro Jornada con Id: " + id));

    }

    // Guarda modificacion en jornada laboral
    public void guardar(JornadaLaboralEntity jornadaLaboralEntity) {
        repository.save(jornadaLaboralEntity);
    }

    // Un empleado no puede trabajar mas de 48 hs semanales, ni menos de 30 hs
    private Boolean superaHorasMaximasDeLaSemanaActual(JornadaLaboralEntity jornada){
        // Recupero fecha de inicio y fin de la semana
        LocalDate fechaTrabajada = jornada.getFecha();
        LocalDate inicioSemana = fechaTrabajada.with(previousOrSame(DayOfWeek.MONDAY));
        LocalDate finSemana = fechaTrabajada.with(nextOrSame(DayOfWeek.SUNDAY));

        // Busco las jornadas cargadas para esa semana
        List<JornadaLaboralEntity> jornadasTrabajadasEnLaSemana = repository.findByEmpleadoAndFechaBetween(jornada.getEmpleado(), inicioSemana,finSemana);

        // Recorro la lista de jornadas y calculo las horas trabajadas en la semana para validar si es posible cargar una nueva jornada
        long horasTotales = calcularHorasTrabajadas(jornadasTrabajadasEnLaSemana);

        // Devuelvo si todavia supera las horas maximas
        return horasTotales >= HORAS_MAXIMAS_DE_TRABAJO;
    }

    // Validacion para semanas con menos de 30 hs
    private Boolean superaHorasMinimasDeLaSemanaAnterior(JornadaLaboralEntity jornada){
        // Obtengo semana anterior
        LocalDate fechaTrabajada = jornada.getFecha();
        LocalDate finSemana = fechaTrabajada.with(previousOrSame(DayOfWeek.MONDAY)).minusDays(1);
        LocalDate inicioSemana = finSemana.with(nextOrSame(DayOfWeek.SUNDAY));

        // Busco jornadas de la semana anterior
        List<JornadaLaboralEntity> jornadasTrabajadasEnLaSemana = repository.findByEmpleadoAndFechaBetween(jornada.getEmpleado(), inicioSemana,finSemana);

        long horasTotales = calcularHorasTrabajadas(jornadasTrabajadasEnLaSemana);

        // Devuelvo si no tiene horas en la semana anterior o si supero las minimas para cargar la semana actual
        return jornadasTrabajadasEnLaSemana.isEmpty() || horasTotales >= HORAS_MINIMAS_DE_TRABAJO;
    }

    // Calculo horas totales de una semana de trabjo
    private long calcularHorasTrabajadas(List<JornadaLaboralEntity> jornadaSemanal){
        return jornadaSemanal.stream()
                .map(j -> ChronoUnit.HOURS.between(j.getHoraSalida(),j.getHoraEntrada()))
                .mapToLong(value -> Long.valueOf(value))
                .sum();
    }
}
