/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.bean;

import co.club.dao.OperAdmin;
import co.club.dao.OperEntre;
import co.club.dto.HojaDeportiva;
import co.club.dto.JovenPracticante;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author sanco
 */
@ManagedBean
@javax.faces.bean.ViewScoped
public class BeanHvidaDep {
    
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(BeanAdmin.class);
    
    private JovenPracticante IdPrac;
    private String obser_hv;
    private int rendi_hv;
    private int hab_hv;
    private int comp_hv;
    private long even_hv;
    private long pago_hv;
    private long curso_hv;
    private List<SelectItem> ListPrac;
    private List<SelectItem> ListCurso;
    
    
    public void volver() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("Admin.xhtml");
        } catch (IOException ex) {
            LOG.error("Se presento el siguiente Error: ", ex);
        }

    }
    
    public void registrarHojaVida() {
        
        HojaDeportiva hv = new HojaDeportiva();
        hv.setIdenPracticante(IdPrac.getIdPracticante());
        hv.setHabilidad(hab_hv);
        hv.setRendimiento(rendi_hv);
        hv.setCompromiso(comp_hv);
        hv.setObservaciones(obser_hv);
        
        OperEntre oper = new OperEntre();
        int rta = oper.insertarHVD(hv);
        if (rta == 1) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "HOJA DE VIDA REGISTRADA"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "EROR", "HOJA DE VIDA NO REGISTRADA"));
        }
    }

    public JovenPracticante getIdPrac() {
        return IdPrac;
    }

    public void setIdPrac(JovenPracticante IdPrac) {
        this.IdPrac = IdPrac;
    }

    public String getObser_hv() {
        return obser_hv;
    }

    public void setObser_hv(String obser_hv) {
        this.obser_hv = obser_hv;
    }

    public int getRendi_hv() {
        return rendi_hv;
    }

    public void setRendi_hv(int rendi_hv) {
        this.rendi_hv = rendi_hv;
    }

    public int getHab_hv() {
        return hab_hv;
    }

    public void setHab_hv(int hab_hv) {
        this.hab_hv = hab_hv;
    }

    public int getComp_hv() {
        return comp_hv;
    }

    public void setComp_hv(int comp_hv) {
        this.comp_hv = comp_hv;
    }

    public long getEven_hv() {
        return even_hv;
    }

    public void setEven_hv(long even_hv) {
        this.even_hv = even_hv;
    }

    public long getPago_hv() {
        return pago_hv;
    }

    public void setPago_hv(long pago_hv) {
        this.pago_hv = pago_hv;
    }

    public long getCurso_hv() {
        return curso_hv;
    }

    public void setCurso_hv(long curso_hv) {
        this.curso_hv = curso_hv;
    }

    public List<SelectItem> getListPrac() {
        this.ListPrac = new ArrayList<>();
        OperAdmin oper = new OperAdmin();
        List<JovenPracticante> j = oper.consultarJoven();
        for (JovenPracticante idPracti : j){
            SelectItem idJovenItem = new SelectItem(idPracti.getUsuJovenPracticante());
            this.ListPrac.add(idJovenItem);
        }
        return ListPrac;
    }

    public void setListPrac(List<SelectItem> ListPrac) {
        this.ListPrac = ListPrac;
    }

    public List<SelectItem> getListCurso() {
        return ListCurso;
    }

    public void setListCurso(List<SelectItem> ListCurso) {
        this.ListCurso = ListCurso;
    }
    
    
}
