package com.gdg.gestiondegastos.repositories;

import com.gdg.gestiondegastos.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
     public Usuario findByCorreo( @Param("correo") String correo);
     //Optional<Usuario> findUserByUsername(String username);
    
     
     
    @Modifying
    @Query("update Usuario u set u.contrasenya = :contrasenya where u.id = :id_usuario")
    public void updateContrasenya(Integer id_usuario, String contrasenya);
    
    
    //BORRA DE LA BBDD, NO DEL GRUPO
    @Modifying
    @Query("delete from Usuario u where u.id = :id_usuario")
    public void borrarUsuario(Integer id_usuario);

    
} 