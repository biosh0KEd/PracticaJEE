/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.ProyectoFacade;
import entities.User;
import boundary.UserFacade;
import boundary.UserproyectoFacade;
import com.query.DataQuery;
import entities.Proyecto;
import entities.Userproyecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Danny
 */
@Named(value = "UserView")
@ApplicationScoped
public class UserView {

    @EJB
    private UserproyectoFacade userproyectoFacade;
    
    private User user;
    private String nombre;
    private String password;
    private Proyecto proyecto;

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
     @EJB
    private ProyectoFacade proyectoFacade;
     
    @EJB
    private UserFacade userFacade;
    
        public UserView() {
            this.user = new User();
        }
        
        public User getUser(){
            return user;
        }
        
        public int getNumberofUsers(){
            return userFacade.findAll().size();
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }
    public String ver(int id){
        this.proyecto = proyectoFacade.find(id);
        return "proyecto";
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
        public String postUser(){
            user.setAutorizacion(false);
            user.setLimiteDeProyectos(false);
            user.setTipoDeUsuario(false);
            this.userFacade.create(user);
            return "login";
        }
        
        public String changetoInicio(){
            return "inicio";
        }
        public String changetoMP(){
            return "mainPage";
        }
         
        public String changetoRegister(){
            return "index";
        }
        
        public String changetoLogin(){
            return "login";
        }
        public String changetoCP(){
            return "passConf";
        }
        public String changetoCN(){
            return "nameConf";
        }
         public String changetoNP(){
            return "CrearProyecto";
        }
        public String changetoAdmin(){
            return "Administrador";
        }
        public String changetoMisP(){
            return "MisProyectos";
        }
        public String changetoModP(){
            return "ModificarProyecto";
        }
        public String changetoAllProjects(){
            return "todosproyectos";
        }
        
        public String changetotenProjects(){
            return "diezproyectos";
        }
        public String buscarUsuarios(){
            return user.getUsuario();
        }
        
        public String autenticar(){
            user = userFacade.encontrarUsuario(user.getUsuario(), user.getContrasena());
            if(user!=null){
                return "mainPage";
            }
            return "failure";
        }
        
        public void cambiar(){
           this.userFacade.edit(this.user);
        }
        public String traerCreador(Proyecto pyt){
          List<Userproyecto> UP = userproyectoFacade.findAll();
          for(Userproyecto up : UP){
              if (up.getIdProyecto().equals(pyt)){
                  return up.getIdUser().getUsuario();
              }
          }
           return null;
        } 
}
