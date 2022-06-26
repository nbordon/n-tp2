package com.neoris.tp2.controllers;

import com.neoris.tp2.entities.tiposJornadasEntities.TipoJornadaEntity;
import com.neoris.tp2.entities.tiposJornadasEntities.TurnoNormalEntity;
import com.neoris.tp2.services.TipoJornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tipo-jornada-api")
public class TipoJornadaController {
    @Autowired
    private TipoJornadaService tipoJornadaService;

    // Alta de tipo de jornada
    // Para el alta de tipos de jornada opté por recibir el discriminator value por query param,
    // por defecto con valor de tipo JornadaNormal, con ese valor casteo el tipo de jornada y la guardo
    @PostMapping(value = "/tipo-jornadas")
    public ResponseEntity<String> altaTipoJornada(@RequestBody TipoJornadaEntity tipoJornadaEntity){
        tipoJornadaService.altaTipojornada(tipoJornadaEntity);
        return new ResponseEntity<>("Alta de nuevo tipo correcto", HttpStatus.CREATED);
    }

    //TODO baja y modificacion de tipos de jornada
}
