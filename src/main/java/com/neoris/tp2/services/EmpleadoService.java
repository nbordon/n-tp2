package com.neoris.tp2.services;

import com.neoris.tp2.entities.EmpleadoDAO;
import com.neoris.tp2.model.Empleado;
import com.neoris.tp2.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service de empleados
@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Listar todos los empleados
    public List<EmpleadoDAO> listarEmpleados(){
        return empleadoRepository.findAll();
    }

    // Alta de empleado
    public void crear(Empleado empleado) {
        EmpleadoDAO nuevoEmpleado = new EmpleadoDAO();
        nuevoEmpleado.setNombre(empleado.getNombre());
        nuevoEmpleado.setApellido(empleado.getApellido());
        empleadoRepository.save(nuevoEmpleado);
    }

    // Buscar Empleado por Id
    public Empleado buscarEmpledo(Integer id) {
        EmpleadoDAO empleadoBuscado = empleadoRepository.findById(id).get();
        return new Empleado(empleadoBuscado.getNombre(), empleadoBuscado.getApellido());
    }
}
