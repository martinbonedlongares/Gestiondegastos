package com.gdg.gestiondegastos.repositories;

import com.gdg.gestiondegastos.entities.Grupo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GrupoRepository extends JpaRepository<Grupo,Integer>{
    
    @Query("UPDATE Grupo g set g.nombre = :nombre where g.id = :id_grupo")
    public String cambiarNombre(Integer id_grupo, String nombre);
    
}