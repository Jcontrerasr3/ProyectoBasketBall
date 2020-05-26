/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.dao;

import co.club.dto.Pago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Familia
 */
public class OperAdmin {
    public int insertarpago(Pago dato){
        Connection c = new AdminConexion().getConnection();
        if (c!= null){
            PreparedStatement ps;
            try {
                ps = c.prepareStatement("INSERT INTO pago(idpago, tipopago, descripcionpago, fechapago, iden_pago_prac, iden_pago_admin)VALUES (?, ?, ?, ?, ?, ?)");
           ps.setLong(1, dato.getIdPago());
           ps.setString(2, dato.getTipoPago());
           ps.setString(3, dato.getDescripcionPago());
           ps.setDate(4, dato.getFechapago());
           ps.setLong(5, dato.getIdJovenpracticante());
           ps.setLong(6, dato.getIdAdmin());
           
            return ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(OperAdmin.class.getName()).log(Level.SEVERE, "Error al insertar vehiculo", ex);
            }finally{
                new AdminConexion().cerrarConnexion(c);
            }
        }
        return 0;
        
    }
}
