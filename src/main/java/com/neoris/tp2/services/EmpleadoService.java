package com.neoris.tp2.services;

import com.neoris.tp2.entities.EmpleadoEntity;
import com.neoris.tp2.exceptions.ResourcesNotFoundException;
import com.neoris.tp2.model.Empleado;
import com.neoris.tp2.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service de empleados
@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Listar todos los empleados
    public List<EmpleadoEntity> listarEmpleados(){
        return empleadoRepository.findAll();
    }

    // Alta de empleado
    public EmpleadoEntity crear(Empleado empleado) {
        EmpleadoEntity nuevoEmpleado = new EmpleadoEntity();
        nuevoEmpleado.setNombre(empleado.getNombre());
        nuevoEmpleado.setApellido(empleado.getApellido());
        return empleadoRepository.save(nuevoEmpleado);

    }

    // Buscar Empleado por Id
    public EmpleadoEntity buscarEmpledo(Integer id) throws ResourcesNotFoundException {
        EmpleadoEntity empleadoBuscado = empleadoRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("No encontrado empleado con id: " + id));
        return empleadoBuscado;
    }
}
