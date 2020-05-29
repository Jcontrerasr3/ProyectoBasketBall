/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.dao;

import co.club.bean.BeanAdmin;
import co.club.dto.Pago;
import co.club.dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Familia
 */
public class OperJoven {
 private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(BeanAdmin.class);
    public List<Pago> consultaPago(String usuario) {
          List<Pago> lista = new ArrayList<Pago>();

       Connection c = new AdminConexion().getConnection();
       if (c != null) {

           PreparedStatement ps;
           try {
               ps = c.prepareStatement("SELECT tipopago, descripcionpago, fechapago, idpago, iden_pago_admin, iden_pago_prac FROM pago where iden_pago_prac=?");
               ps.setString(1, usuario);
               ResultSet results = ps.executeQuery();

               while (results.next()) {

                   lista.add(new Pago(results.getString(1), results.getString(2), results.getDate(3), results.getInt(4), results.getString(5), results.getString(6) ));
               }

           } catch (SQLException ex) {
               LOG.error("Error al consultar los pagos", ex);
           } finally {
               new AdminConexion().cerrarConnexion(c);
           }
       }
       return lista;
    }

    public List<Usuario> consultaUsu(String usuario) {
             List<Usuario> lista = new ArrayList<Usuario>();

       Connection c = new AdminConexion().getConnection();
       if (c != null) {

           PreparedStatement ps;
           try {
               ps = c.prepareStatement("SELECT identificacionu, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, sexou, password, rol\n" +
"	FROM usuario WHERE identificacionu = ?;");

               ps.setString(1, usuario);
               ResultSet results = ps.executeQuery();

               while (results.next()) {

                   lista.add(new Usuario(results.getString(1), results.getString(2), results.getString(3), results.getString(4), results.getString(5), results.getString(6), results.getString(7), results.getString(8) ));
               }

           } catch (SQLException ex) {
               LOG.error("Error al consultar los pagos", ex);
           } finally {
               new AdminConexion().cerrarConnexion(c);
           }
       }
       return lista;
    }
    
}
