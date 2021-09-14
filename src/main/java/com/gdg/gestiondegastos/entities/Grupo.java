package com.gdg.gestiondegastos.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Grupo")
@Data
@NoArgsConstructor
public class Grupo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String nombre;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaCreacion;
}
