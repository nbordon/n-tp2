package com.neoris.tp2.controllers;

import com.neoris.tp2.repositories.EmpleadoRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/empleado")
public class EmpleadoController {
    private EmpleadoRepositorio repositorio;

    @GetMapping(value = "/new")
    public String nuevoEmpleado(){
        //TODO alta de empleado
        return "Alta de empleado";
    }
}
