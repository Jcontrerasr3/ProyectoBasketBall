/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.bean;

import co.club.dao.OperAdmin;
import co.club.dto.JovenPracticante;
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
public class BeanRegisJov implements Serializable {

    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(BeanAdmin.class);

    private String identJov;
    private String pri_nom;
    private String seg_nom;
    private String pri_apl;
    private String seg_apl;
    private String sex_jov;
    private String clav_jov;
    private int tip_men;
    private int niv_jov;
    private String enfo_jov;
    //private Usuario id_usu_jov;

    public void volver() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("Admin.xhtml");
        } catch (IOException ex) {
            LOG.error("Se presento el siguiente Error: ", ex);
        }
    }

    public void registrarJoven() {
        if (identJov == null || pri_nom == null || pri_nom.isEmpty() || seg_nom == null || seg_nom.isEmpty() || pri_apl == null || pri_apl.isEmpty() || seg_apl == null || seg_apl.isEmpty() || sex_jov == null || sex_jov.isEmpty() || clav_jov == null || clav_jov.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención", "Faltan Datos por llenar"));
            return;
        }

        Usuario u = new Usuario();
        u.setUsuario(identJov);
        u.setPrimer_nombre(pri_nom);
        u.setSegundo_nombre(seg_nom);
        u.setPrimer_apellido(pri_apl);
        u.setSegundo_apellido(seg_apl);
        u.setSexo(sex_jov);
        u.setPassword(clav_jov);
        u.setRol("JovenPracticante");

        JovenPracticante jp = new JovenPracticante();
        jp.setTipoMensualidad(tip_men);
        jp.setNivelJoven(niv_jov);
        jp.setEnfoqueJoven(enfo_jov);
        jp.setUsuJovenPracticante(identJov);

        OperAdmin oper = new OperAdmin();
        String rta = oper.insertarJoven(u, jp);
        System.out.println(rta);

        if (rta.equals("11")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "JOVEN PRACTICANTE REGISTRADO"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "EROR", "JOVEN PRACTICANTE NO REGISTRADO"));
        }

        identJov = null;
        pri_nom = null;
        seg_nom = null;
        pri_apl = null;
        seg_apl = null;
        sex_jov = null;
        clav_jov = null;
        tip_men = 0;
        niv_jov = 0;
        enfo_jov = null;

    }

    public String getIdentJov() {
        return identJov;
    }

    public void setIdentJov(String identJov) {
        this.identJov = identJov;
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

    public String getSex_jov() {
        return sex_jov;
    }

    public void setSex_jov(String sex_jov) {
        this.sex_jov = sex_jov;
    }

    public String getClav_jov() {
        return clav_jov;
    }

    public void setClav_jov(String clav_jov) {
        this.clav_jov = clav_jov;
    }

    public int getTip_men() {
        return tip_men;
    }

    public void setTip_men(int tip_men) {
        this.tip_men = tip_men;
    }

    public int getNiv_jov() {
        return niv_jov;
    }

    public void setNiv_jov(int niv_jov) {
        this.niv_jov = niv_jov;
    }

    public String getEnfo_jov() {
        return enfo_jov;
    }

    public void setEnfo_jov(String enfo_jov) {
        this.enfo_jov = enfo_jov;
    }

}
