package com.neoris.tp2.controllers;

import com.neoris.tp2.entities.EmpleadoEntity;
import com.neoris.tp2.entities.JornadaLaboralEntity;
import com.neoris.tp2.exceptions.ResourcesNotFoundException;
import com.neoris.tp2.model.JornadaLaboral;
import com.neoris.tp2.services.EmpleadoService;
import com.neoris.tp2.services.JornadaLaboralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//REST Controller para jornadas laborales
@RestController
@RequestMapping(value = "/jornada-api")
@Slf4j
public class JornadaLaboralController {
    @Autowired
    private JornadaLaboralService jornadaLaboralService;
    @Autowired
    private EmpleadoService empleadoService;

    // Alta de jornada Laboral para un empleado por su id
    @PostMapping(value = "/{empleado_id}/jornadas")
    public ResponseEntity<JornadaLaboralEntity> crearJornada(
            @PathVariable(name = "empleado_id") String empleadoId,
            @RequestBody JornadaLaboral jornada
            ){
        try{
            EmpleadoEntity empleadoEntity = empleadoService.buscarEmpledo(Integer.parseInt(empleadoId));
            JornadaLaboralEntity jornadaLaboralEntity = jornadaLaboralService.crear(jornada,empleadoEntity);
            return new ResponseEntity<>(jornadaLaboralEntity, HttpStatus.CREATED);
        }catch (ResourcesNotFoundException e){
            log.warn(e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Listar las jornadas de un empleado
    @GetMapping(value = "/{empleado_id}/jornadas")
    public ResponseEntity<List<JornadaLaboralEntity>> listarJornadas(
            @PathVariable(name = "empleado_id") String empleadoId
    ){
        try{
            EmpleadoEntity empleado = empleadoService.buscarEmpledo(Integer.parseInt(empleadoId));
            List<JornadaLaboralEntity> jornadas = jornadaLaboralService.listarJornadas(empleado);
            if(jornadas.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(jornadas, HttpStatus.OK);
        }catch (ResourcesNotFoundException e){
            log.warn(e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // Actualizar jornada por id
    @PutMapping(value = "/jornadas/{id}")
    public ResponseEntity<JornadaLaboralEntity> actualizarJornada(
        @PathVariable(name = "id") String id,
        @RequestBody JornadaLaboral jornadaLaboral
    ){
        try{
            JornadaLaboralEntity jornadaLaboralEntity = jornadaLaboralService.obtenerJornada(Integer.parseInt(id));
            jornadaLaboralEntity.setFecha(jornadaLaboral.getFecha());
            jornadaLaboralEntity.setHoraEntrada(jornadaLaboral.getHoraEntrada());
            jornadaLaboralEntity.setHoraSalida(jornadaLaboral.getHoraSalida());
            jornadaLaboralService.guardar(jornadaLaboralEntity);
            return new ResponseEntity<>(jornadaLaboralEntity,HttpStatus.OK);
        } catch (ResourcesNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // Buscar jornada por id
    @GetMapping(value = "/jornadas/{id}")
    public ResponseEntity<JornadaLaboralEntity> buscarJornada(
        @PathVariable(name = "id") String id
    ){
        try{
            JornadaLaboralEntity jornadaLaboralEntity = jornadaLaboralService.obtenerJornada(Integer.parseInt(id));
            return new ResponseEntity<>(jornadaLaboralEntity,HttpStatus.OK);
        } catch (ResourcesNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
