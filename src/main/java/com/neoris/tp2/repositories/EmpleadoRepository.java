package com.neoris.tp2.repositories;

import com.neoris.tp2.entities.EmpleadoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositorio de empeleados
@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoDAO, Integer> {
}
