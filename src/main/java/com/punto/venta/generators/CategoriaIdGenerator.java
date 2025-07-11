/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.punto.venta.generators;

import java.io.Serializable;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 *
 * @author Jazzi
 */
public class CategoriaIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        String prefix = "CG";
        String query = "SELECT idCategoria FROM Categorias ORDER BY idCategoria DESC LIMIT 1";

        String lastId = (String) session.createNativeQuery(query).uniqueResult();
        int next = 1;

        if (lastId != null && lastId.startsWith(prefix)) {
            try {
                next = Integer.parseInt(lastId.substring(prefix.length())) + 1;
            } catch (NumberFormatException e) {
                next = 1;
            }
        }

        String newId = prefix + next;

        if (object instanceof com.punto.venta.model.Categoria categoria) {
            categoria.setIdCategoria(newId);
        }

        return newId;
    }
}
