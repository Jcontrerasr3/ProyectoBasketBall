/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.dao;

import co.club.dto.JovenPracticante;
import co.club.dto.Pago;
import co.club.dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
           ps = c.prepareStatement("INSERT INTO pago(tipopago, descripcionpago, fechapago, iden_pago_admin, iden_pago_prac)VALUES (?, ?, ?, ?, ?)");
           ps.setString(1, dato.getTipoPago());
           ps.setString(2, dato.getDescripcionPago());
           ps.setDate(3, dato.getFechapago());
           ps.setString(4, dato.getIdAdmin());
           ps.setLong(5, dato.getIdJovenpracticante());
        
           
            return ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(OperAdmin.class.getName()).log(Level.SEVERE, "Error al insertar vehiculo", ex);
            }finally{
                new AdminConexion().cerrarConnexion(c);
            }
        }
        return 0;
        
    }
     public List<JovenPracticante> consultarJoven(){
        Connection c = new AdminConexion().getConnection();
         List<JovenPracticante> lista = new ArrayList<JovenPracticante>();
        if (c!= null){
            PreparedStatement ps;
            try {
               ps = c.prepareStatement("SELECT iden_prac_usu, idprac FROM jovenpracticante");

               ResultSet results = ps.executeQuery();

               while (results.next()) {

                   lista.add(new JovenPracticante(results.getLong(1), results.getLong(2)));
               }
               
            } catch (SQLException ex) {
                Logger.getLogger(OperAdmin.class.getName()).log(Level.SEVERE, "Error al insertar vehiculo", ex);
            }finally{
                new AdminConexion().cerrarConnexion(c);
            }
        }
        return lista;
        
    }
     
     public Usuario buscarjoven(long pk){
        Connection c = new AdminConexion().getConnection();
        Usuario encontradousuario = null;
        if (c!= null){
            PreparedStatement ps;
            try {
               ps = c.prepareStatement("SELECT identificacionu, primer_nombre, primer_apellido FROM  usuario where identificacionu=? ");
               ps.setLong(1, pk);
               ResultSet results = ps.executeQuery();

               while (results.next()) {

                encontradousuario= new Usuario(results.getString(2), results.getString(3));
               }
               
            } catch (SQLException ex) {
                Logger.getLogger(OperAdmin.class.getName()).log(Level.SEVERE, "Error al insertar vehiculo", ex);
            }finally{
                new AdminConexion().cerrarConnexion(c);
            }
        }
        return encontradousuario;
        
    }
     
}
