
package com.gdg.gestiondegastos.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Por definir")
@Data
@NoArgsConstructor
public class Entidad {

    @Id
    private Long id;
}