/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Danny
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "SimpleEE6AppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    public User encontrarUsuario(String nombre, String contrasena){
        Query q = em.createNamedQuery("User.control",User.class).setParameter("usuario", nombre).setParameter("contrasena", contrasena);
        
        List<User> Usuarios = q.getResultList();
        if(!Usuarios.isEmpty()){
            return Usuarios.get(0);
        }
        return null;
    }
    
}
