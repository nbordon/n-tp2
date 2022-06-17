package com.neoris.tp2.repositories;

import com.neoris.tp2.entities.EmpleadoEntity;
import com.neoris.tp2.entities.JornadaLaboralEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JornadaLaboralRepository extends JpaRepository<JornadaLaboralEntity, Integer> {
    List<JornadaLaboralEntity> findAllByEmpleado(EmpleadoEntity empleadoEntity);
}
