/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.bean;

import co.club.dao.OperLogin;
import co.club.dto.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;
import org.apache.logging.log4j.LogManager;


/**
 *
 * @author Familia
 */

@ManagedBean
@javax.faces.bean.ViewScoped
public class loginBean implements Serializable {
    
    private String nombre;
    private String password;
    private String rol;
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(loginBean.class);
     public loginBean() {
        
    }

    public void loginProject() {
        if (nombre == null || nombre.isEmpty() || password == null || password.isEmpty()||rol == null || rol.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención", "Faltan Datos por llenar"));

        }
        Usuario v = new Usuario();
        v.setUsuario(nombre);
        v.setPassword(password);
        OperLogin oper = new OperLogin();
        boolean resut = oper.login(v);
        
        if (resut==true) {
            try {
                Map session= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
                session.put("usuario", v);
                if(null!=rol)switch (rol) {
                    case "Administrador":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("Admin.xhtml");
                        break;
                    case "JovenPracticante":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("JovenPracticante.xhtml");
                        break;
                    case "Entrenador":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("Entrenador.xhtml");
                        break;
                    default:
                        break;
                }
            } catch (IOException ex) {
               LOG.error("Se presento el siguiente error: ", ex);
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Invalid Login!", "Please Try Again!"));
        }
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
