package com.gdg.gestiondegastos.repositories;

import com.gdg.gestiondegastos.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
     public Usuario findByCorreo( @Param("correo") String correo);
     //Optional<Usuario> findUserByUsername(String username);
}