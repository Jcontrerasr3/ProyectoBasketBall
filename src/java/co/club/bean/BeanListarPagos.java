/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.bean;

import co.club.dao.OperAdmin;
import co.club.dto.JovenPracticante;
import co.club.dto.Pago;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Jonathan
 */
@ManagedBean
@javax.faces.bean.ViewScoped
public class BeanListarPagos implements  Serializable{
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(BeanAdmin.class);
    private List<JovenPracticante> joven;
    private List<Pago> pago; 
    public BeanListarPagos() {
    }

    
    @PostConstruct
    public void init() {
        //this.joven = cargarJov();
        this.pago = cargarPag();
    }
    public List<JovenPracticante> getJoven() {
        return joven;
    }

    public void setJoven(List<JovenPracticante> joven) {
        this.joven = joven;
    }

    public List<Pago> getPago() {
        return pago;
    }

    public void setPago(List<Pago> pago) {
        this.pago = pago;
    }

    private List<JovenPracticante> cargarJov() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private List<Pago> cargarPag() {
          OperAdmin oper = new OperAdmin();
      
      return oper.consultaPago();
    }
    
     public void volver() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("Admin.xhtml");
        } catch (IOException ex) {
            LOG.error("Se presento el siguiente Error: ", ex);
        }
    }    
    
    
}
