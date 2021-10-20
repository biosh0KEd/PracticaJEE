
package my.presentation;
import entities.Proyecto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bruno Jauregui
 */
@ManagedBean
public class BuscadorController {
    private List<String> datos = null;
    private List<String> resultado = null;
    private String display = "";
    
    /*@EJB
    private BusquedasFacade busquedasFacade;*/
    
    @PostConstruct
    public void init() {
        datos = new ArrayList<>();
        resultado = new ArrayList<>();
        
        datos.add("");
    }
    
    public void search() {
        resultado.clear();
        for (String busqueda:datos) {
            if (busqueda.toLowerCase().startsWith(display.toLowerCase())){
                resultado.add(busqueda);
            }
        }
        
        if (resultado.isEmpty()) {
            resultado.add("No se encontró");
        }
    }

    public List<String> getDatos() {
        return datos;
    }

    public void setDatos(List<String> datos) {
        this.datos = datos;
    }

    public List<String> getResultado() {
        return resultado;
    }

    public void setResultado(List<String> resultado) {
        this.resultado = resultado;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
        
}
