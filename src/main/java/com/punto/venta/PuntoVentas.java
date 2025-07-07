/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.punto.venta;

import com.punto.venta.vista.vtnLogin;


/**
 *
 * @author Jazzi
 */
public class PuntoVentas {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vtnLogin().setVisible(true);
            }
        });
    }
}
