/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.bean;


import co.club.dao.OperJoven;
import co.club.dto.JovenPracticante;
import co.club.dto.Pago;
import co.club.dto.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
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
public class BeanListarpagoJoven  implements Serializable{
   private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(BeanAdmin.class);
    private List<Usuario> joven;
    private List<Pago> pago; 
    private Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    private Usuario usu = (Usuario) session.get("usuario");
    public BeanListarpagoJoven() {
        this.pago = cargarPag();
        this.joven = datosUsuario();
        System.out.println("holaaaa"+usu.getUsuario());
    }
    
    
     private List<Pago> cargarPag() {
          OperJoven oper = new OperJoven();
      return oper.consultaPago(usu.getUsuario());
    }
    
    public List<Pago> getPago() {
        return pago;
    }

    public void setPago(List<Pago> pago) {
        this.pago = pago;
    }
    
      public void salir() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("JovenPracticante.xhtml");
        } catch (IOException ex) {
            LOG.error("Se presento el siguiente Error: ", ex);
        }
    }    

    public List<Usuario> getJoven() {
        return joven;
    }

    public void setJoven(List<Usuario> joven) {
        this.joven = joven;
    }
      private List<Usuario> datosUsuario() {
          OperJoven oper = new OperJoven();
      return oper.consultaUsu(usu.getUsuario());
    }
    
}
