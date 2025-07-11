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
@Table(name = "Categorias")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(generator = "categoria-id-generator")
    @GenericGenerator(
            name = "categoria-id-generator",
            strategy = "com.punto.venta.generators.CategoriaIdGenerator"
    )
    @Size(min = 3, max = 5)
    @Column(name = "idCategoria")
    private String idCategoria;

    @Size(min = 3, max = 30)
    @Column(name = "nombreCategoria", nullable = false, length = 30)
    private String nombreCategoria;
}
