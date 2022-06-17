package com.neoris.tp2.services;

import com.neoris.tp2.entities.EmpleadoEntity;
import com.neoris.tp2.entities.JornadaLaboralEntity;
import com.neoris.tp2.model.JornadaLaboral;
import com.neoris.tp2.repositories.EmpleadoRepository;
import com.neoris.tp2.repositories.JornadaLaboralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JornadaLaboralService {
    @Autowired
    private JornadaLaboralRepository repository;
    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Crear jornada laboral
    public void crear(JornadaLaboral jornadaLaboral, Integer empleadoId){
        EmpleadoEntity empleado = empleadoRepository.findById(empleadoId).get();
        JornadaLaboralEntity jornadaLaboralEntity = new JornadaLaboralEntity();
        jornadaLaboralEntity.setEmpleado(empleado);
        jornadaLaboralEntity.setFecha(jornadaLaboral.getFecha());
        jornadaLaboralEntity.setHoraEntrada(jornadaLaboral.getHoraEntrada());
        jornadaLaboralEntity.setHoraSalida(jornadaLaboral.getHoraSalida());
        repository.save(jornadaLaboralEntity);
    }
}
