/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdg.gestiondegastos.security;

import com.gdg.gestiondegastos.entities.Usuario;
import com.gdg.gestiondegastos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService{
    @Autowired
    private UsuarioRepository uR;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Usuario user=uR.findUserByUsername(username).orElseThrow(()->new UsernameNotFoundException("No exite ese usuario"));
        return user;
    }
    
    public void crearUsuario(UserDetails user){
        uR.save((Usuario) user);
    }
}
