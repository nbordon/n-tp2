package com.neoris.tp2.repositories;

import com.neoris.tp2.entities.JornadaLaboralDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JornadaLaboralRepository extends JpaRepository<JornadaLaboralDAO, Integer> {
}
