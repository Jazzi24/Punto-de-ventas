/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.punto.venta.conexion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Jazzi
 */
public class ConexionDB {

    private EntityManagerFactory emf;
    private EntityManager em;

    public void ConexionBD() {
        emf = Persistence.createEntityManagerFactory("conexionBD");
    }

    public EntityManager abrirConexion() {
        em = emf.createEntityManager();
        return em;
    }
    
    public void cerrarConexion() {
        if (em.isOpen()) {
        em.close();
    }
    }
}
