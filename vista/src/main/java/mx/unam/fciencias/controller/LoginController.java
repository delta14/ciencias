/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.controller;

/**
 *
 * @author guillermorojas
 */

import java.io.IOException;
import java.io.Serializable;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;




//@Controller("loginController")
//@Scope("request")
@ManagedBean(name="loginController")
@RequestScoped
public class LoginController implements Serializable {

    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

 
  
    public String login() throws IOException, ServletException {
        
      /*
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
                    .getRequestDispatcher("/j_spring_security_check");
            dispatcher.forward((ServletRequest) context.getRequest(),
                    (ServletResponse) context.getResponse());
            FacesContext.getCurrentInstance().responseComplete();
            
        */
        return "inicio";
    }
    

    public String logout() throws IOException, ServletException {
        /*
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
                .getRequestDispatcher("/j_spring_security_logout");
        dispatcher.forward((ServletRequest) context.getRequest(),
                (ServletResponse) context.getResponse());
        FacesContext.getCurrentInstance().responseComplete();
        */
        return "login";
    }


    public boolean isAuthenticated() {
        return SecurityContextHolder.getContext().getAuthentication() != null;
    }


    public String getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }



    
}
