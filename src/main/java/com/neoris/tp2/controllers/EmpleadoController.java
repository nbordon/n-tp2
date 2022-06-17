package com.neoris.tp2.controllers;

import com.neoris.tp2.entities.EmpleadoEntity;
import com.neoris.tp2.model.Empleado;
import com.neoris.tp2.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST Controller de Empleado
@RestController
@RequestMapping(value = "/empleado-api")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    // Listar todos los empleados
    @GetMapping(value = "/empleados")
    public List<EmpleadoEntity> listarEmpleados(){
        return empleadoService.listarEmpleados();
    }

    // Buscar empleado por id
    @GetMapping(value="/empleados/{id}")
    public Empleado buscarEmpleado(@PathVariable(name = "id") Integer id){
        return empleadoService.buscarEmpledo(id);
    }

    // Crear nuevo empleado
    @PostMapping(value = "/empleados")
    public void altaEmpleado(@RequestBody Empleado empleado){
        empleadoService.crear(empleado);
    }
}
