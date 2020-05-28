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

    public boolean login(Usuario v, String rol) {
        Connection c = new AdminConexion().getConnection();
        if (c != null) {
            PreparedStatement ps;
            try {
              if(null!=rol)switch (rol) {
                  case "Administrador":
                ps = c.prepareStatement("SELECT identificacionu, password, iden_admin_usu FROM usuario, administrador where identificacionu= ? and password= ? and iden_admin_usu= ?", ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, v.getUsuario());
                ps.setString(2, v.getPassword());
                ps.setString(3, v.getUsuario());
                ResultSet rs = ps.executeQuery();
                if (rs.absolute(1)) {

                    return true;
                }
                break;
                 case "JovenPracticante":
                 ps = c.prepareStatement("SELECT identificacionu, password, iden_prac_usu FROM usuario, jovenpracticante where identificacionu= ? and password= ? and iden_prac_usu= ?", ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, v.getUsuario());
                ps.setString(2, v.getPassword());
                ps.setString(3, v.getUsuario());
                ResultSet rs2 = ps.executeQuery();
                if (rs2.absolute(1)) {

                    return true;
                }
                 break;
                 case "Entrenador":
                  ps = c.prepareStatement("SELECT identificacionu, password, iden_usu_pro FROM usuario, profesor where identificacionu= ? and password= ? and iden_usu_pro= ?", ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, v.getUsuario());
                ps.setString(2, v.getPassword());
                ps.setString(3, v.getUsuario());
                ResultSet rs3 = ps.executeQuery();
                if (rs3.absolute(1)) {

                    return true;
                }
                 break;    
                 default:
                        break;
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
