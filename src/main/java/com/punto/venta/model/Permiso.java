/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

/**
 *
 * @author Jazzi
 */
@Entity
@Table(name = "Permisos")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Permiso {
    
    @Id
    @GeneratedValue(generator = "permiso-id-generator")
    @GenericGenerator(
            name = "permiso-id-generator",
            strategy = "com.punto.venta.generators.PermisoIdGenerator"
    )
    @Size(min = 2, max = 3)
    @Column(name = "idPermiso")
    private String idPermiso;
    
    @Size(min = 3, max = 30)
    @Column(name = "nombrePermiso", nullable = false, length = 30)
    private String nombrePermiso;
}
