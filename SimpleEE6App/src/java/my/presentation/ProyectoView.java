/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.ProyectoFacade;
import entities.Proyecto;
import entities.User;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Danny
 */
@Named(value = "proyectoView")
@ApplicationScoped
public class ProyectoView {

    private Proyecto proyecto;
    
    @EJB
    private ProyectoFacade proyectoFacade;
   
     public ProyectoView() {
            this.proyecto = new Proyecto();
        }
     
      public Proyecto getProyecto(){
            return proyecto;
        }
     
    public List<Proyecto> diezProyectos(){
        return proyectoFacade.ultimosDiez();
     }
    
    public List<Proyecto> todosProyectos(){
        return proyectoFacade.findAll();
     }
   
    
}
