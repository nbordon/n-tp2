package com.neoris.tp2.controllers;

import com.neoris.tp2.repositories.EmpleadoRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/empleado-api")
public class EmpleadoController {
    private EmpleadoRepositorio repositorio;

    @GetMapping(value = "/empleado")
    public String nuevoEmpleado(){
        //TODO alta de empleado
        return "Alta de empleado";
    }
}
