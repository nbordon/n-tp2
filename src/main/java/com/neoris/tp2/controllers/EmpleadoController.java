package com.neoris.tp2.controllers;

import com.neoris.tp2.entities.EmpleadoEntity;
import com.neoris.tp2.exceptions.ResourcesNotFoundException;
import com.neoris.tp2.model.Empleado;
import com.neoris.tp2.services.EmpleadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST Controller de Empleado
@RestController
@RequestMapping(value = "/empleado-api")
@Slf4j
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    // Listar todos los empleados
    @GetMapping(value = "/empleados")
    public ResponseEntity<List<EmpleadoEntity>> listarEmpleados(){
        List<EmpleadoEntity> empleados = empleadoService.listarEmpleados();
        if(empleados.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    // Buscar empleado por id
    @GetMapping(value="/empleados/{id}")
    public ResponseEntity<EmpleadoEntity> buscarEmpleado(@PathVariable(name = "id") Integer id) {
        try{
            EmpleadoEntity empleadoBuscado = empleadoService.buscarEmpledo(id);
            return new ResponseEntity<>(empleadoBuscado, HttpStatus.OK);
        } catch (ResourcesNotFoundException e){
            log.warn(e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // Crear nuevo empleado
    @PostMapping(value = "/empleados")
    public ResponseEntity<EmpleadoEntity> altaEmpleado(@RequestBody Empleado empleado){
        EmpleadoEntity empleadoEntity = empleadoService.crear(empleado);
        return new ResponseEntity<>(empleadoEntity, HttpStatus.CREATED);
    }
}
