package com.neoris.tp2.services;

import com.neoris.tp2.entities.EmpleadoEntity;
import com.neoris.tp2.entities.JornadaLaboralEntity;
import com.neoris.tp2.exceptions.ResourcesNotFoundException;
import com.neoris.tp2.model.JornadaLaboral;
import com.neoris.tp2.repositories.EmpleadoRepository;
import com.neoris.tp2.repositories.JornadaLaboralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JornadaLaboralService {
    @Autowired
    private JornadaLaboralRepository repository;
    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Crear jornada laboral
    public JornadaLaboralEntity crear(JornadaLaboral jornadaLaboral, EmpleadoEntity empleado){
        JornadaLaboralEntity jornadaLaboralEntity = new JornadaLaboralEntity();
        jornadaLaboralEntity.setEmpleado(empleado);
        jornadaLaboralEntity.setFecha(jornadaLaboral.getFecha());
        jornadaLaboralEntity.setHoraEntrada(jornadaLaboral.getHoraEntrada());
        jornadaLaboralEntity.setHoraSalida(jornadaLaboral.getHoraSalida());
        return repository.save(jornadaLaboralEntity);
    }

    // Listar jornadas para un empleado
    public List<JornadaLaboralEntity> listarJornadas(EmpleadoEntity empleado){
        return repository.findAllByEmpleado(empleado);
    }

    // Obtener jornada por id
    public JornadaLaboralEntity obtenerJornada(Integer id) throws ResourcesNotFoundException{
        return repository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("No se encontro Jornada con Id: " + id));

    }

    // Guarda modificacion en jornada laboral
    public void guardar(JornadaLaboralEntity jornadaLaboralEntity) {
        repository.save(jornadaLaboralEntity);
    }
}
