/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.punto.venta.controlador;

import com.punto.venta.model.Rol;
import jakarta.persistence.EntityManager;

/**
 *
 * @author Jazzi
 */
public class RolDAO {

    private EntityManager em;

    public RolDAO(EntityManager em) {
        this.em = em;
    }

    public void guardar(Rol rol) {
        try {
            em.getTransaction().begin();
            em.persist(rol);
            em.getTransaction().commit();
            System.out.println("Rol creado con éxito.");
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
