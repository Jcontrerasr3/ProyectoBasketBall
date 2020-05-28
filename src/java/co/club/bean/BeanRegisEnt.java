/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.bean;

import co.club.dao.OperAdmin;
import co.club.dto.Entrenador;
import co.club.dto.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author sanco
 */

@ManagedBean
@javax.faces.bean.ViewScoped
public class BeanRegisEnt implements Serializable{
    
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(BeanAdmin.class);

    private String identEnt;
    private String pri_nom;
    private String seg_nom;
    private String pri_apl;
    private String seg_apl;
    private String sex_ent;
    private String clav_ent;
    private String esp_ent;
    
    public void volver() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("Admin.xhtml");
        } catch (IOException ex) {
            LOG.error("Se presento el siguiente Error: ", ex);
        }
    }
    
    public void registrarEntrenador(){
        if (identEnt == null || pri_nom == null || pri_nom.isEmpty() || pri_apl == null || pri_apl.isEmpty() || seg_apl == null || seg_apl.isEmpty() || sex_ent == null || sex_ent.isEmpty() || clav_ent == null || clav_ent.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención", "Faltan Datos por llenar"));
            return;
        }
        
        Usuario u = new Usuario();
        u.setUsuario(identEnt);
        u.setPrimer_nombre(pri_nom);
        u.setSegundo_nombre(seg_nom);
        u.setPrimer_apellido(pri_apl);
        u.setSegundo_apellido(seg_apl);
        u.setSexo(sex_ent);
        u.setPassword(clav_ent);
        u.setRol("Entrenador");
        
        Entrenador ent = new Entrenador();
        ent.setEspecialidad(esp_ent);
        ent.setUsuEntrenador(identEnt);
        
        OperAdmin oper = new OperAdmin();
        String rta = oper.insertarEntrenador(u, ent);
        System.out.println(rta);
        
        if (rta.equals("11")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "JOVEN PRACTICANTE REGISTRADO"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "EROR", "JOVEN PRACTICANTE NO REGISTRADO"));
        }
        
        identEnt = null;
        pri_nom = null;
        seg_nom = null;
        pri_apl = null;
        seg_apl = null;
        sex_ent = null;
        clav_ent = null;
        esp_ent = null;
        
    } 

    public String getIdentEnt() {
        return identEnt;
    }

    public void setIdentEnt(String identEnt) {
        this.identEnt = identEnt;
    }

    public String getPri_nom() {
        return pri_nom;
    }

    public void setPri_nom(String pri_nom) {
        this.pri_nom = pri_nom;
    }

    public String getSeg_nom() {
        return seg_nom;
    }

    public void setSeg_nom(String seg_nom) {
        this.seg_nom = seg_nom;
    }

    public String getPri_apl() {
        return pri_apl;
    }

    public void setPri_apl(String pri_apl) {
        this.pri_apl = pri_apl;
    }

    public String getSeg_apl() {
        return seg_apl;
    }

    public void setSeg_apl(String seg_apl) {
        this.seg_apl = seg_apl;
    }

    public String getSex_ent() {
        return sex_ent;
    }

    public void setSex_ent(String sex_ent) {
        this.sex_ent = sex_ent;
    }

    public String getClav_ent() {
        return clav_ent;
    }

    public void setClav_ent(String clav_ent) {
        this.clav_ent = clav_ent;
    }

    public String getEsp_ent() {
        return esp_ent;
    }

    public void setEsp_ent(String esp_ent) {
        this.esp_ent = esp_ent;
    }
}
