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
@Table(name = "Proveedores")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {
    
    @Id
    @GeneratedValue(generator = "proveedor-id-generator")
    @GenericGenerator(
            name = "proveedor-id-generator",
            strategy = "com.punto.venta.generators.ProveedorIdGenerator"
    )
    @Size(min = 3, max = 5)
    @Column(name = "idproveedor", nullable = false, length = 5)
    private String idProveedor;

    @Size(min = 3, max = 100)
    @Column(name = "nombreProveedor", nullable = false, length = 100)
    private String nombreProveedor;

    @Size(min = 10, max = 10)
    @Column(name = "telefono", nullable = true, length = 10)
    private String telefono;

    @Size(min = 3, max = 200)
    @Column(name = "direccion", nullable = true, length = 200)
    private String direccion;

    @Size(min = 3, max = 100)
    @Column(name = "correo", nullable = true, length = 100)
    private String correo;
}
