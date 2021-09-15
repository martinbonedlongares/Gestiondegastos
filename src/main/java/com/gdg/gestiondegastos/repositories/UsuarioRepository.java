package com.gdg.gestiondegastos.repositories;

import com.gdg.gestiondegastos.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
}