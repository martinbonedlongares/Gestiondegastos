/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdg.gestiondegastos.dto;

import com.gdg.gestiondegastos.entities.UsuarioGrupo;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Joche
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoDto {
    private Integer id;

    private String info; 
    private Date fecha;
    
    private String concepto;
    private Double cantidad;
    private UsuarioGrupo usuarioGrupo;
}
