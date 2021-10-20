/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.query;

import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Danny
 */
public class DataQuery {
    EntityManagerFactory emf;
    EntityManager em;
    
    public DataQuery(){
        emf = Persistence.createEntityManagerFactory("SimpleEE6AppPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    public boolean loginControl(String usuario, String contrasena){
        try{
            User u = em.createNamedQuery("User.control", User.class)
                    .setParameter("usuario", usuario)
                    .setParameter("contrasena", contrasena)
                    .getSingleResult();
            if(u!=null){
                return true;
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }
}
