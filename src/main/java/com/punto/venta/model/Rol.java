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
    @Column(name = "id")
    private String id_rol;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre_rol;
}
