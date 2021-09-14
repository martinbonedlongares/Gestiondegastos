
package com.gdg.gestiondegastos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "UsuarioGrupo")
@Data
@NoArgsConstructor
public class UsuarioGrupo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private Long idUsuario;
    private Long idGrupo;
    private Boolean rol;
}
