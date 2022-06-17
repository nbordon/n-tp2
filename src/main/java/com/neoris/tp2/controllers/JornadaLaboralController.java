package com.neoris.tp2.controllers;

import com.neoris.tp2.model.Empleado;
import com.neoris.tp2.model.JornadaLaboral;
import com.neoris.tp2.services.EmpleadoService;
import com.neoris.tp2.services.JornadaLaboralService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/jornada-api")
public class JornadaLaboralController {
    private JornadaLaboralService jornadaLaboralService;
    private EmpleadoService empleadoService;

    @PostMapping(value = "/{empleado_id}/jornada")
    public String crearJornada(
            @PathVariable(name = "empleado_id", required = true) String empleadoId,
            @RequestBody JornadaLaboral jornada
            ){
        Empleado empleado = empleadoService.buscarEmpledo(Integer.parseInt(empleadoId));
        jornada.setEmpleado(empleado);
        jornadaLaboralService.crear(jornada);
        return "Jornada creada con exito";
    }
}
