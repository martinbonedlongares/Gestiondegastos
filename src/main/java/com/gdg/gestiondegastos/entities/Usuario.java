
package com.gdg.gestiondegastos.entities;

import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;
    private String contrasenya;
    private String telefono;
    private String correo;
    @Column(name="account_non_locked")
    private boolean accountNonLocked;
    
    
    
    //Uniones de Tablas
    
    //(Envia el id a UsuarioGrupo)
    @OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER)
    private List<UsuarioGrupo> usuarioGrupo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(()->"read");
    }

    @Override
    public String getPassword() {
        return contrasenya;
    }

    @Override
    public String getUsername() {
        return nombre;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public void setAccountNonLocked(boolean accountNonLocked){
        this.accountNonLocked=accountNonLocked;
    }
    
    public boolean getAccountNonLocked(){
        return accountNonLocked;
    }
    
}
