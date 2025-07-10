/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.punto.venta.controlador;

import com.punto.venta.model.Permiso;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Jazzi
 */
@Data
@Builder
public class PermisoDAO {
     private EntityManager em;

    public PermisoDAO(EntityManager em) {
        this.em = em;
    }
    
    // Crear un Permiso (por ID)
    public void guardar(Permiso permiso) {
        try {
            em.getTransaction().begin();
            em.persist(permiso);
            em.getTransaction().commit();
            System.out.println("Permiso creado con éxito.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    // Buscar un Permiso (por ID).
    public Permiso buscarPorId(String id) {
        try {
            return em.find(Permiso.class, id);
        } finally {
            em.close();
        }
    }

    // Listar permiso (todos).
    public List<Permiso> listarTodos() {
        try {
            return em.createQuery("SELECT p FROM Permiso p", Permiso.class).getResultList();
        } finally {
            em.close();
        }
    }

    // Actualizar permiso.
    public void actualizar(Permiso permiso) {
        try {
            em.getTransaction().begin();
            em.merge(permiso);
            em.getTransaction().commit();
            System.out.println("permiso actualizado con éxito.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Eliminar permiso.
    public void eliminar(String id) {
        try {
            Permiso permiso = em.find(Permiso.class, id);
            if (permiso != null) {
                em.getTransaction().begin();
                em.remove(permiso);
                em.getTransaction().commit();
                System.out.println("permiso eliminado con éxito.");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
