/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entities.Proyecto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Efraín
 */
@Stateless
public class ProyectoFacade extends AbstractFacade<Proyecto> {

    @PersistenceContext(unitName = "SimpleEE6AppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoFacade() {
        super(Proyecto.class);
    }

    public List ultimosDiez() {
        Query q = em.createNamedQuery("Proyecto.ultimosdiez", Proyecto.class).setMaxResults(10);
        List<Proyecto> proyectos = q.getResultList();
        return proyectos;
    }

    public List<Proyecto> findCat(int id) {
        Query q = em.createNamedQuery("Proyecto.findCat", Proyecto.class).setParameter("idCat", id);
        List<Proyecto> Proyectos = q.getResultList();
        if (!Proyectos.isEmpty()) {
            return Proyectos;
        }
        return null;
    }

}
