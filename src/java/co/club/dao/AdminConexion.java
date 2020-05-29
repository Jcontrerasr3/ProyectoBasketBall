/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.dao;

/**
 *
 * @author Familia
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;






public class AdminConexion {
   private static final Logger LOG = LogManager.getLogger(AdminConexion.class);
    public AdminConexion() { 
    }
     public Connection getConnection()
    {
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/Baloncesto", "unicentral", "123");
               
            return c;
         
        } catch (ClassNotFoundException ex) {
           LOG.error("Se prensento el siguiente error", ex);
        } catch (SQLException ex) {
           LOG.error("Se prensento el siguiente error", ex);
        }
        return null;
    }
    public void cerrarConnexion(Connection con){
         try {
             con.close();
         } catch (SQLException ex) {
             System.out.println("Error in login() -->" + ex.getMessage());
         }
    }

}

