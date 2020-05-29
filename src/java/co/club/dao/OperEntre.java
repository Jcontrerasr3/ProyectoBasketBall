/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.dao;

import co.club.dto.HojaDeportiva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanco
 */
public class OperEntre {
    
    public int insertarHVD (HojaDeportiva hd){
        
        Connection c = new AdminConexion().getConnection();
        
        if(c != null) {
            PreparedStatement ps;
            try {
                ps = c.prepareStatement("INSERT INTO hojavidadeportiva(observacioneshv, rendimientohv, habilidadhv, compromisohv, iden_prac_hv, iden_event_hv, iden_curso_hv, iden_pago_hv)VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, hd.getObservaciones());
                ps.setInt(2, hd.getRendimiento());
                ps.setInt(3, hd.getHabilidad());
                ps.setInt(4, hd.getCompromiso());
                ps.setString(5, hd.getIdenPracticante());
                ps.setLong(6, hd.getEvento());
                ps.setLong(7, hd.getCursos());
                ps.setLong(8, hd.getPago());
                
                return ps.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(OperAdmin.class.getName()).log(Level.SEVERE, "Error al insertar Hoja de vida deportiva del Joven practicante", ex);
            } finally {
                new AdminConexion().cerrarConnexion(c);
            }
        }
        return 0;
    }
}
