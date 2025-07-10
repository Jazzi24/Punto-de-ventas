/*
 * 
 * 
 */
package com.punto.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Roles")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rol {

    @Id
    @GeneratedValue(generator = "rol-id-generator")
    @GenericGenerator(
            name = "rol-id-generator",
            strategy = "com.punto.venta.generators.RolIdGenerator"
    )
    @Size(min = 2, max = 3)
    @Column(name = "id")
    private String id_rol;

    @Size(min = 3, max = 30)
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre_rol;
}
