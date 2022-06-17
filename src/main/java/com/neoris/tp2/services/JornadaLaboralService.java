package com.neoris.tp2.services;

import com.neoris.tp2.entities.JornadaLaboralEntity;
import com.neoris.tp2.model.JornadaLaboral;
import com.neoris.tp2.repositories.JornadaLaboralRepository;
import org.springframework.stereotype.Service;

@Service
public class JornadaLaboralService {
    private JornadaLaboralRepository repository;

    // Crear jornada laboral
    public void crear(JornadaLaboral jornadaLaboral){
        JornadaLaboralEntity jornadaLaboralEntity = new JornadaLaboralEntity();
        jornadaLaboralEntity.setFecha(jornadaLaboral.getFecha());
        jornadaLaboralEntity.setHoraEntrada(jornadaLaboral.getHoraEntrada());
        jornadaLaboralEntity.setHoraSalida(jornadaLaboral.getHoraSalida());
        repository.save(jornadaLaboralEntity);
    }
}
