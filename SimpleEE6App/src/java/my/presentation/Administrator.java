/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.CategoriaFacade;
import entities.Categoria;
import entities.Proyecto;
import entities.User;
import boundary.ProyectoFacade;
import boundary.UserFacade;
import boundary.UserproyectoFacade;
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
@Named(value = "administrator")
@ApplicationScoped
public class Administrator {

    @EJB
    private UserproyectoFacade userproyectoFacade;
    @EJB
    private CategoriaFacade categoriaFacade;
    @EJB
    private ProyectoFacade proyectoFacade;
    @EJB
    private UserFacade userFacade;
    private User usuarioActual;
    private User usuarioModificar;
    private Proyecto proyectoModificar;
    private Categoria categoriaModificar;
    
       private int cat;   
    /**
     * Creates a new instance of Administrator
     */
    public Administrator() {
        this.usuarioActual = new User();
        this.usuarioModificar = new User();
        this.proyectoModificar = new Proyecto();
        this.categoriaModificar = new Categoria();
    }
    
    public User getUsuarioActual() {
        return usuarioActual;
    }
    
    public User getUsuarioModificar() {
        return usuarioModificar;
    }
    
    public Categoria getCategoriaModificar() {
        return categoriaModificar;
    }
    
    public Proyecto getProyectoModificar(){
        return proyectoModificar;
    }
    
    public List<User> obtenerTodosUsuarios(){
        return userFacade.findAll();
    }
    
    public List<Proyecto> obtenerTodosProyectos(){
        return proyectoFacade.findAll();
    }
     public List<Proyecto> obtenerProyectosByCat(){
        if (cat!=0)
            return proyectoFacade.findCat(cat);
        else return null;
    }
    public String openCat(int cat){
        this.cat = cat;
        return "categoryview";
    }
    
    public List<Categoria> obtenerTodasCategorias(){
        return categoriaFacade.findAll();
    }
    
    public String traerUsuarioActual(User usr){
        this.usuarioActual = usr;
        return "Administrador";
    }
    
    public String modificarUsuario(int id){
        this.usuarioModificar = userFacade.find(id);
        return "ModificaUsuario";
    }
    
    public String ModificarUsuario(){
        List<User> Usuarios = userFacade.findAll();
        for(User usr : Usuarios){
            if (usr.getUsuario().equals(this.usuarioModificar.getUsuario())) {
                usr.setUsuario(this.usuarioModificar.getUsuario());
                usr.setContrasena(this.usuarioModificar.getContrasena());
                this.userFacade.edit(usr);
                return "Administrador";
            } 
        }
        return "failure";
    }
    
    public void autorizarUsuario(int id){
        //if(this.usuarioActual.getTipoDeUsuario()){
            User UsuarioAEditar = this.userFacade.find(id);
            UsuarioAEditar.setAutorizacion(true);
            this.userFacade.edit(UsuarioAEditar);
        //}
    }
    
    public void crearAdmins(int id){
        //if(this.usuarioActual.getTipoDeUsuario()){
            User UsuarioAEditar = this.userFacade.find(id);
            UsuarioAEditar.setTipoDeUsuario(true);
            this.userFacade.edit(UsuarioAEditar);
        //}
    }
    
    public void asignarLimiteAUsuario(int id){
        //if(this.usuarioActual.getTipoDeUsuario()){
            User UsuarioAEditar = this.userFacade.find(id);
            UsuarioAEditar.setLimiteDeProyectos(false);
            this.userFacade.edit(UsuarioAEditar);
        //}
    }
    
    public void noAsignarLimiteAUsuario(int id){
        //if(this.usuarioActual.getTipoDeUsuario()){
            User UsuarioAEditar = this.userFacade.find(id);
            UsuarioAEditar.setLimiteDeProyectos(true);
            this.userFacade.edit(UsuarioAEditar);
        //}
    }
    
    public void eliminarUsuario(int id){
        //if(this.usuarioActual.getTipoDeUsuario()){
            User UsuarioAEliminar = this.userFacade.find(id);
            this.userFacade.remove(UsuarioAEliminar);
        //}
    }
    
   
    public void eliminarProyecto(int idProyecto){
        //if(this.usuarioActual.getTipoDeUsuario()){
            Proyecto proyectoABorrar = this.proyectoFacade.find(idProyecto);
            this.proyectoFacade.remove(proyectoABorrar);
        //}
    }
    
    public String modificarProyecto(int id){
        this.proyectoModificar = proyectoFacade.find(id);
        return "ModificarProyecto";
    }
    
    public String ModificarProyecto(){
        List<Proyecto> Proyectos = proyectoFacade.findAll();
        for(Proyecto pyt : Proyectos){
            if (pyt.getNombre().equals(this.proyectoModificar.getNombre())) {
                pyt.setNombre(this.proyectoModificar.getNombre());
                pyt.setDescripcion(this.proyectoModificar.getDescripcion());
                pyt.setEnlaceCF(this.proyectoModificar.getEnlaceCF());
                pyt.setEnlaceInst(this.proyectoModificar.getEnlaceInst());
                pyt.setEnlaceRepT(this.proyectoModificar.getEnlaceRepT());
                pyt.setEnlaceReq(this.proyectoModificar.getEnlaceReq());
                pyt.setEstado(this.proyectoModificar.getEstado());
                pyt.setFecha(this.proyectoModificar.getFecha());
                if (this.categoriaModificar.getIdCategoria() != null) {
                    pyt.setIdCategoria(categoriaFacade.find(this.categoriaModificar.getIdCategoria()));
                }                           
                pyt.setObjetivos(this.proyectoModificar.getObjetivos());
                this.proyectoFacade.edit(pyt);
                return "mainPage";             
            } 
        }
        return "failure";
    }
    
    public boolean esMiProyecto(User usr, Proyecto pyt){
        List<Userproyecto> UP = userproyectoFacade.findAll();
        for(Userproyecto up : UP){
            if (up.getIdUser().equals(usr)){
                if (up.getIdProyecto().equals(pyt)){
                    return true;
                }
            }
        }
        return false;
    }
}
