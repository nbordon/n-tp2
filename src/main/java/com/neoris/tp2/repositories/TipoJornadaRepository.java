package com.neoris.tp2.repositories;

import com.neoris.tp2.entities.tiposJornadas.TipoJornadaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoJornadaRepository extends JpaRepository<TipoJornadaEntity, Integer> {
}
