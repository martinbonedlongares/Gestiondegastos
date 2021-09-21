<<<<<<< OURS
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdg.gestiondegastos.configuracion;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 *
 * @author Usuario
 */
public class ApplicationConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    DataSource dataSource;
    
    @Bean
    public PasswordEncoder passEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    /*@Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select correo,contrasenya from usuarios where correo=?");
    }*/
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.anonymous().disable().csrf().disable().authorizeRequests().antMatchers("/registro**")
                .permitAll().anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").usernameParameter("correo").passwordParameter("contrasenya")
                .successForwardUrl("/paginaPrincipal/{id}").failureForwardUrl("/paginaPrincipal")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/paginaPrincipal").invalidateHttpSession(true)
                .clearAuthentication(true).permitAll();
    }
}