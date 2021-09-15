package com.gdg.gestiondegastos.repositories;

import com.gdg.gestiondegastos.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientosRepository extends JpaRepository<Movimiento,Integer>{
}