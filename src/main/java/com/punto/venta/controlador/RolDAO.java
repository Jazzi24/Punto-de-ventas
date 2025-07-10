/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.punto.venta.controlador;

import com.punto.venta.model.Rol;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author Jazzi
 */
public class RolDAO {

    private EntityManager em;

    public RolDAO(EntityManager em) {
        this.em = em;
    }

    // Crear un rol (por ID)
    public void guardar(Rol rol) {
        try {
            em.getTransaction().begin();
            em.persist(rol);
            em.getTransaction().commit();
            System.out.println("Rol creado con éxito.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    // Buscar un rol (por ID).
    public Rol buscarPorId(String id) {
        try {
            return em.find(Rol.class, id);
        } finally {
            em.close();
        }
    }

    // Listar roles (todos).
    public List<Rol> listarTodos() {
        try {
            return em.createQuery("SELECT r FROM Rol r", Rol.class).getResultList();
        } finally {
            em.close();
        }
    }

    // Actualizar roles.
    public void actualizar(Rol rol) {
        try {
            em.getTransaction().begin();
            em.merge(rol);
            em.getTransaction().commit();
            System.out.println("Rol actualizado con éxito.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Eliminar roles.
    public void eliminar(String id) {
        try {
            Rol rol = em.find(Rol.class, id);
            if (rol != null) {
                em.getTransaction().begin();
                em.remove(rol);
                em.getTransaction().commit();
                System.out.println("Rol eliminado con éxito.");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
