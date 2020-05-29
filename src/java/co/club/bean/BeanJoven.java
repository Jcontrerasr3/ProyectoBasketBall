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
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Familia
 */
@ManagedBean
@javax.faces.bean.ViewScoped
public class BeanJoven implements Serializable{

    private Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    private Usuario usu = (Usuario) session.get("usuario");
    private String nombre = usu.getUsuario();
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(BeanJoven.class);

    public BeanJoven() {
    }

    public void cerrarSesion() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            LOG.error("Se presento el siguiente Error: ", ex);
        }

    }

    public void consultarEvento() {
        try {

            FacesContext.getCurrentInstance().getExternalContext().redirect("ListarEvento.xhtml");
        } catch (IOException ex) {
            LOG.error("Se presento el siguiente Error: ", ex);
        }

    }

    public void consultarPagos() {
        try {

            FacesContext.getCurrentInstance().getExternalContext().redirect("ListarPagos.xhtml");
        } catch (IOException ex) {
            LOG.error("Se presento el siguiente Error: ", ex);
        }

    }

    public void verHojaDeportiva() {
        try {

            FacesContext.getCurrentInstance().getExternalContext().redirect("ConsultarHD.xhtml");
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
