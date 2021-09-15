package com.gdg.gestiondegastos.repositories;

import com.gdg.gestiondegastos.entities.Presupuesto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresupuestoRepository extends JpaRepository<Presupuesto,Integer>{
    
    
     //public Optional<Presupuesto> findByIdGrupo(Integer idGrupo); 
     
     
}