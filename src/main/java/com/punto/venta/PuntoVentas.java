/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.punto.venta;

import com.punto.venta.controlador.RolDAO;
import com.punto.venta.model.Rol;
import com.punto.venta.vista.vtnLogin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Jazzi
 */
public class PuntoVentas {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Persistence.createEntityManagerFactory("conexionBD").close();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vtnLogin().setVisible(true);
            }
        });
    }
}
