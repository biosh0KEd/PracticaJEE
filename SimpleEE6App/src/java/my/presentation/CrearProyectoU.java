/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.CategoriaFacade;
import boundary.ProyectoFacade;
import boundary.UserproyectoFacade;
import entities.Categoria;
import entities.Proyecto;
import entities.User;
import entities.Userproyecto;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Efraín
 */
@Named(value = "crearProyectoU")
@ApplicationScoped
public class CrearProyectoU {

    @EJB
    private UserproyectoFacade userproyectoFacade;

    @EJB
    private CategoriaFacade categoriaFacade;

    @EJB
    private ProyectoFacade proyectoFacade;
    
    private Proyecto nuevoProyecto;
    private Categoria cDelProyecto;
    private Userproyecto relacionUP;
    /**
     * Creates a new instance of CrearProyectoU
     */
    
    
    public CrearProyectoU() {
        this.nuevoProyecto = new Proyecto();
        this.cDelProyecto = new Categoria();
        this.relacionUP = new Userproyecto();
    }
    
    public Proyecto getNuevoProyecto() {
        return this.nuevoProyecto;
    }
    
    public Categoria getCDelProyecto() {
        return this.cDelProyecto;
    }
    
    public String CrearProyecto(User usr){
        this.nuevoProyecto.setIdCategoria(categoriaFacade.find(this.cDelProyecto.getIdCategoria()));
        this.proyectoFacade.create(nuevoProyecto);
        this.relacionUP.setIdUser(usr);
        this.relacionUP.setIdProyecto(nuevoProyecto);
        this.userproyectoFacade.create(relacionUP);
        return "mainPage";
    }
    
    public boolean EvaluarCrearProyectos(User usr){
        boolean valor = true;
        if(usr.getLimiteDeProyectos() == false){
            List<Userproyecto> UP = userproyectoFacade.findAll();
            for (Userproyecto ups : UP){
                if(ups.getIdUser().equals(usr)){
                    valor = false;
                } 
            }
        } 
        return valor;
    }
}
