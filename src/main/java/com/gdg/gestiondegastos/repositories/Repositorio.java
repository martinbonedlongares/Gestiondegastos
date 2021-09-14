package com.gdg.gestiondegastos.repositories;

import com.gdg.gestiondegastos.entities.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repositorio extends JpaRepository<Entidad, Integer> {
}