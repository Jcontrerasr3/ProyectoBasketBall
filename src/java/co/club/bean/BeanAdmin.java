/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.bean;


import co.club.dto.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Familia
 */
@ManagedBean
@javax.faces.bean.ViewScoped
public class BeanAdmin implements Serializable{

    private Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    private Usuario usu = (Usuario) session.get("usuario");
    private String nombre = usu.getPrimer_nombre();
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(BeanAdmin.class);
    public BeanAdmin() {

    }

    public void cerrarSesion()  {
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            LOG.error("Se presento el siguiente Error: ", ex);
        }

    }

    public void pagos()  {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("pagos.xhtml");
        } catch (IOException ex) {
              LOG.error("Se presento el siguiente Error: ", ex);
        }
    }
    public void registrarJoven() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("RegistroJ.xhtml");
        } catch (IOException ex) {
              LOG.error("Se presento el siguiente Error: ", ex);
        }

    }

    public void registrarEntrenador() {
       
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("RegistroE.xhtml");
        } catch (IOException ex) {
              LOG.error("Se presento el siguiente Error: ", ex);
        }

    }

    public void consultaPagos() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("Cpagos.xhtml");
        } catch (IOException ex) {
              LOG.error("Se presento el siguiente Error: ", ex);
        }

    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
