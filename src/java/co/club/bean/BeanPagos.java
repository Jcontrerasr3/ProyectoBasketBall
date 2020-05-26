/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.bean;

import co.club.dao.OperAdmin;
import co.club.dto.Pago;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

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
public class BeanPagos implements Serializable {

    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(BeanAdmin.class);
    private int idpago;
    private String tipopago;
    private String descripcion;
    private Date fecha;
    private int idJoven;
    private int idAdmin;

    public BeanPagos() {

    }

    public void cerrarSesion() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            LOG.error("Se presento el siguiente Error: ", ex);
        }

    }
    
    
    
    public void registrarPago() {
        if (tipopago == null || tipopago.isEmpty() || descripcion == null || descripcion.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención", "Faltan Datos por llenar"));
            return;
        }
        if (idJoven < 0 || idAdmin < 0 || idpago < 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención", "Faltan Datos por llenar"));
            return;
        }
        java.util.Date fecha1 = new java.util.Date();
        fecha = new java.sql.Date((fecha1.getTime()));
        System.out.println("inicio" + fecha);

        Pago p = new Pago();
        p.setIdPago(idpago);
        p.setTipoPago(tipopago);
        p.setDescripcionPago(descripcion);
        p.setFechapago(fecha);
        p.setIdJovenpracticante(idJoven);
        p.setIdAdmin(idAdmin);
        OperAdmin oper = new OperAdmin();
        int rta = oper.insertarpago(p);
        if (rta == 1) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "PAGO REGISTRADO"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "EROR", "PAGO NO REGISTRADO"));
        }
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

   

    public int getIdJoven() {
        return idJoven;
    }

    public void setIdJoven(int idJoven) {
        this.idJoven = idJoven;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

}
