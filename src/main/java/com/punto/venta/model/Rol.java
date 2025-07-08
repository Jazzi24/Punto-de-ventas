/*
 * 
 * 
 */
package com.punto.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Roles")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    @Id
    @Column(name = "id_rol")
    int id_rol;
    
    @Column(name = "nombre")
    String nombre_rol;
}
