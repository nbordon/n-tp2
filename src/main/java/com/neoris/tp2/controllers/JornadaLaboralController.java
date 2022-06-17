package com.neoris.tp2.controllers;

import com.neoris.tp2.model.JornadaLaboral;
import com.neoris.tp2.services.JornadaLaboralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/jornada-api")
public class JornadaLaboralController {

    @Autowired
    private JornadaLaboralService jornadaLaboralService;

    @PostMapping(value = "/{empleado_id}/jornada")
    public String crearJornada(
            @PathVariable(name = "empleado_id", required = true) String empleadoId,
            @RequestBody JornadaLaboral jornada
            ){
        jornadaLaboralService.crear(jornada,Integer.parseInt(empleadoId));
        return "Jornada creada con exito";
    }
}
