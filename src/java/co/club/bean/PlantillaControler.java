/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.bean;

import co.club.dto.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@Named
@ViewScoped
public class PlantillaControler implements Serializable{

    private static final Logger LOG = LogManager.getLogger(PlantillaControler.class);
    public void verificarSesion(){
      try {
        Usuario us=  (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");  
        if(us==null){
             FacesContext.getCurrentInstance().getExternalContext().redirect("permisos.xhtml");
             LOG.debug("Intento de entrar sin autentificacion");
        }
      } catch (Exception e) {
       LOG.error("Se presento el siguiente error:", e);
      }
      
      
  }
  public void volver()  {
        try {
           
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            LOG.error("Se presento el siguiente Error: ", ex);
        }

    }
    
}
