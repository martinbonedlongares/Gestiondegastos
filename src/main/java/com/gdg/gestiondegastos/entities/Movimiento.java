/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdg.gestiondegastos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Movimiento")
@Data
@NoArgsConstructor
public class Movimiento {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String info;
    private String fecha;
    private String concepto;
    private Integer cantidad;
    
    //@ManyToOne
    //@JoinColumn(name = "id_usuario_grupo")
    //private UsuarioGrupo idUsuarioGrupo;
    
    
}
