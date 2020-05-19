/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.dao;

import co.club.dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author Familia
 */
public class OperLogin {
 
    private static final Logger LOG = LogManager.getLogger(OperLogin.class);
     
     public  boolean login(Usuario v, String rol) {
        Connection c = new AdminConexion().getConnection();
        if (c!= null){
            PreparedStatement ps;
            try{
                
             ps = c.prepareStatement("SELECT usuario, password, rol FROM usuario where usuario= ? and password= ? and rol= ?",ResultSet.TYPE_SCROLL_INSENSITIVE, 
                            ResultSet.CONCUR_UPDATABLE);
             ps.setString(1, v.getUsuario());
            ps.setString(2, v.getPassword());
            ps.setString(3, rol);
                ResultSet rs = ps.executeQuery();
            if (rs.absolute(1)) 
            {
            
                return true;
            }
           
        } catch (Exception ex) {
            LOG.error("Se presento el siguiente error: ", ex);
            return false;
        } finally {
           new AdminConexion().cerrarConnexion(c);
        }
    }
         return false;
  
     }   

    
}
