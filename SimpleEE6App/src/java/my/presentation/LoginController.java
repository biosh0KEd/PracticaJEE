/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.UserFacade;
import com.query.DataQuery;
import entities.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Danny
 */
@Named(value = "login")
@SessionScoped
public class LoginController implements Serializable {
     private User user;
    private String username;
    private String password;

    @EJB
    private UserFacade userFacade;
    public LoginController() {
        this.user = new User();
    }
    
    private final DataQuery query = new DataQuery();
    
    public String loginControl(){
        if(query.loginControl(username, password)){
            return "success";
        }
        return "failure";
    } 

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
