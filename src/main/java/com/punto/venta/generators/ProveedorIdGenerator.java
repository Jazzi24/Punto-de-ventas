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
public class ProveedorIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        String prefix = "PV";
        String query = "SELECT id_proveedor FROM proveedores ORDER BY id_proveedor DESC LIMIT 1";

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

        if (object instanceof com.punto.venta.model.Permiso permiso) {
            permiso.setId_permiso(newId);
        }

        return newId;
    }
}
