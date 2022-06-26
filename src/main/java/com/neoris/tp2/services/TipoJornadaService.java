package com.neoris.tp2.services;

import com.neoris.tp2.entities.tiposJornadasEntities.TipoJornadaEntity;
import com.neoris.tp2.entities.tiposJornadasEntities.TurnoNormalEntity;
import com.neoris.tp2.repositories.TipoJornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoJornadaService {
    @Autowired
    private TipoJornadaRepository tipoJornadaRepository;

    // Alta de tipo de jornada
    public void altaTipojornada(TipoJornadaEntity tipoJornadaEntity){
        tipoJornadaRepository.save(tipoJornadaEntity);
    }

}
