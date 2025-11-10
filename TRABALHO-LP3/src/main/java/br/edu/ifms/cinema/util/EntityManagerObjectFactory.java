package br.edu.ifms.cinema.util;
import javax.persistence.EntityManager;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author victor ferreira
 */
public class EntityManagerObjectFactory {
    public static EntityManager getEM(){
        return EntityManagerFactorySingleton.getEMF().createEntityManager();
    }
}



