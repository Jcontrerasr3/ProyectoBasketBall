/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.bean;

import co.club.dao.OperAdmin;
import co.club.dto.JovenPracticante;
import co.club.dto.Pago;
import co.club.dto.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Familia
 */
@ManagedBean
@javax.faces.bean.ViewScoped
public class BeanPagos implements Serializable {

    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(BeanAdmin.class);
    private String tipopago;
    private String descripcion;
    private Date fecha;
    private List<SelectItem> listidjoven;
    private JovenPracticante idjoven;
     private Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    private Usuario usu = (Usuario) session.get("usuario");
    private String nombre = usu.getPrimer_nombre();
    private Usuario datos;
    public BeanPagos() {
        idjoven= new JovenPracticante();
    }

    public void volver() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("Admin.xhtml");
        } catch (IOException ex) {
            LOG.error("Se presento el siguiente Error: ", ex);
        }

    }
    
    
    
    public void registrarPago() {
        if (tipopago == null || tipopago.isEmpty() || descripcion == null || descripcion.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención", "Faltan Datos por llenar"));
            return;
        }
       
        java.util.Date fecha1 = new java.util.Date();
        fecha = new java.sql.Date((fecha1.getTime()));
        System.out.println("inicio" + fecha);
       
        Pago p = new Pago();
        p.setTipoPago(tipopago);
        p.setDescripcionPago(descripcion);
        p.setFechapago(fecha);
        p.setIdJovenpracticante(idjoven.getUsuJovenPracticante());
        p.setIdAdmin(nombre);
        
        OperAdmin oper = new OperAdmin();
        int rta = oper.insertarpago(p);
        if (rta == 1) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "PAGO REGISTRADO"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "EROR", "PAGO NO REGISTRADO"));
        }
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

 

    public List<SelectItem> getListidjoven() {
        this.listidjoven=new ArrayList<SelectItem>();
        OperAdmin oper= new OperAdmin();
        List<JovenPracticante> j= oper.consultarJoven();
        for (JovenPracticante idjoves: j){
        SelectItem   idjovenItem= new SelectItem(idjoves.getUsuJovenPracticante());
        this.listidjoven.add(idjovenItem);
        
        }
        return listidjoven;
    }

    public void setListidjoven(List<SelectItem> listidjoven) {
        this.listidjoven = listidjoven;
    }

    public JovenPracticante getIdjoven() {
        return idjoven;
    }

    public void setIdjoven(JovenPracticante idjoven) {
        this.idjoven = idjoven;
    }

    public Usuario buscarJoven() {
        
            long pk = Long.parseLong(idjoven.getUsuJovenPracticante());
            OperAdmin oper = new OperAdmin();
            Usuario rta = oper.buscarjoven(pk);
            this.datos=rta;
    
        return (Usuario) datos;
    } 

    public Usuario getDatos() {
        return (Usuario) datos;
    }

    public void setDatos(Usuario datos) {
        this.datos = datos;
    }

  

}
