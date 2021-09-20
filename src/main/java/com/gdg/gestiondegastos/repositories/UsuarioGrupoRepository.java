package com.gdg.gestiondegastos.repositories;

import com.gdg.gestiondegastos.entities.UsuarioGrupo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioGrupoRepository extends JpaRepository<UsuarioGrupo,Integer>{
    
    @Query("select ug from UsuarioGrupo ug where ug.grupo.id = :id_grupo")
    public List<UsuarioGrupo> leerPorGrupo(Integer id_grupo);
}