package com.neoris.tp2.services;

import com.neoris.tp2.entities.JornadaLaboralDAO;
import com.neoris.tp2.model.JornadaLaboral;
import com.neoris.tp2.repositories.JornadaLaboralRepository;
import org.springframework.stereotype.Service;

@Service
public class JornadaLaboralService {
    private JornadaLaboralRepository repository;

    // Crear jornada laboral
    public void crear(JornadaLaboral jornadaLaboral){
        JornadaLaboralDAO jornadaLaboralDAO = new JornadaLaboralDAO();
        jornadaLaboralDAO.setFecha(jornadaLaboral.getFecha());
        jornadaLaboralDAO.setHoraEntrada(jornadaLaboral.getHoraEntrada());
        jornadaLaboralDAO.setHoraSalida(jornadaLaboral.getHoraSalida());
        repository.save(jornadaLaboralDAO);
    }
}
