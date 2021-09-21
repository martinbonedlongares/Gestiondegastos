package com.gdg.gestiondegastos.repositories;

import com.gdg.gestiondegastos.entities.Grupo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GrupoRepository extends JpaRepository<Grupo,Integer>{
    
    
    
}