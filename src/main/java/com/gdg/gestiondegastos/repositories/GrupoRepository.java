package com.gdg.gestiondegastos.repositories;

import com.gdg.gestiondegastos.entities.Grupo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository extends JpaRepository<Grupo,Integer>{
    
    
}