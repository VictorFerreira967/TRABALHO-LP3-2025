/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.cinema.dao;

import br.edu.ifms.cinema.model.Filme;
import java.util.List;
import javax.persistence.EntityManager;
import br.edu.ifms.cinema.util.EntityManagerObjectFactory;
import java.util.LinkedList;
import javax.persistence.Query;

/**
 *
 * @author victor ferreira
 */
public class FilmeDAO implements GenericDAO<Filme> {
    private EntityManager em;
    
    @Override
    public boolean add(Filme entity) {
        em = EntityManagerObjectFactory.getEM();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
            System.err.println(e.getMessage());
            throw new RuntimeException("falha ao alterar os dados");
            // o que vai aqui??
        } finally {
            em.close();
        }
    }

    @Override
    public boolean update(Filme entity) {
        em = EntityManagerObjectFactory.getEM();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean remove(Filme entity) {
        em = EntityManagerObjectFactory.getEM();
        try {
            if(em.find(Filme.class, entity.getId()) == null)
                em.merge(entity);
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public Filme getById(Long id) {
        em = EntityManagerObjectFactory.getEM();
        try {
            Query query = em.createQuery("SELECT c FROM Filme c WHERE c.id = :id");
            query.setParameter("id", id);
            return (Filme) query.getSingleResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Filme> getAll() {
        em = EntityManagerObjectFactory.getEM();
        try {
            Query query = em.createQuery("SELECT c FROM Filme c");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new LinkedList<>();
        } finally {
            em.close();
        }
    }  

    
}


