/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.dao;

import co.club.bean.BeanAdmin;
import co.club.dto.Entrenador;
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
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Familia
 */
public class OperAdmin {
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(BeanAdmin.class);
    public int insertarpago(Pago dato) {
        Connection c = new AdminConexion().getConnection();
        if (c != null) {
            PreparedStatement ps;
            try {
                ps = c.prepareStatement("INSERT INTO pago(tipopago, descripcionpago, fechapago, iden_pago_admin, iden_pago_prac)VALUES (?, ?, ?, ?, ?)");
                ps.setString(1, dato.getTipoPago());
                ps.setString(2, dato.getDescripcionPago());
                ps.setDate(3, dato.getFechapago());
                ps.setString(4, dato.getIdAdmin());
                ps.setString(5, dato.getIdJovenpracticante());

                return ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(OperAdmin.class.getName()).log(Level.SEVERE, "Error al insertar Pago", ex);
            } finally {
                new AdminConexion().cerrarConnexion(c);
            }
        }
        return 0;

    }

    public String insertarJoven(Usuario dato, JovenPracticante dato1) {
        Connection c = new AdminConexion().getConnection();
        String rta = null;
        if (c != null) {
            PreparedStatement ps;
            PreparedStatement ps1;
            try {
                ps = c.prepareStatement("INSERT INTO usuario(identificacionu, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, sexou, password, rol)VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, dato.getUsuario());
                ps.setString(2, dato.getPrimer_nombre());
                ps.setString(3, dato.getSegundo_nombre());
                ps.setString(4, dato.getPrimer_apellido());
                ps.setString(5, dato.getSegundo_apellido());
                ps.setString(6, dato.getSexo());
                ps.setString(7, dato.getPassword());
                ps.setString(8, dato.getRol());

                rta = ps.executeUpdate()+"";

            } catch (SQLException ex) {
                Logger.getLogger(OperAdmin.class.getName()).log(Level.SEVERE, "Error al insertar al usuario", ex);
            } 

            try {
                ps1 = c.prepareStatement("INSERT INTO jovenpracticante(tipomensaulidadprac, nivelprac, enfoqueprac, iden_prac_usu)VALUES (?, ?, ?, ?)");
                ps1.setInt(1, dato1.getTipoMensualidad());
                ps1.setInt(2, dato1.getNivelJoven());
                ps1.setString(3, dato1.getEnfoqueJoven());
                ps1.setString(4, dato1.getUsuJovenPracticante());

                rta = ps1.executeUpdate()+rta;
            } catch (SQLException ex) {
                Logger.getLogger(OperAdmin.class.getName()).log(Level.SEVERE, "Error al insertar al Joven Practicante", ex);
            } finally {
                new AdminConexion().cerrarConnexion(c);
            }

        }
        return rta;
    }
    
    public String insertarEntrenador(Usuario dato, Entrenador dato1) {
        Connection c = new AdminConexion().getConnection();
        String rta = null;
        if (c != null) {
            PreparedStatement ps;
            PreparedStatement ps1;
            try {
                ps = c.prepareStatement("INSERT INTO usuario(identificacionu, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, sexou, password, rol)VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, dato.getUsuario());
                ps.setString(2, dato.getPrimer_nombre());
                ps.setString(3, dato.getSegundo_nombre());
                ps.setString(4, dato.getPrimer_apellido());
                ps.setString(5, dato.getSegundo_apellido());
                ps.setString(6, dato.getSexo());
                ps.setString(7, dato.getPassword());
                ps.setString(8, dato.getRol());

                rta = ps.executeUpdate()+"";

            } catch (SQLException ex) {
                Logger.getLogger(OperAdmin.class.getName()).log(Level.SEVERE, "Error al insertar al usuario", ex);
            } 

            try {
                ps1 = c.prepareStatement("INSERT INTO public.profesor(especialidadpro, iden_usu_pro)VALUES (?, ?);");
                ps1.setString(1, dato1.getEspecialidad());
                ps1.setString(2, dato1.getUsuEntrenador());

                rta = ps1.executeUpdate()+rta;
            } catch (SQLException ex) {
                Logger.getLogger(OperAdmin.class.getName()).log(Level.SEVERE, "Error al insertar al Joven Practicante", ex);
            } finally {
                new AdminConexion().cerrarConnexion(c);
            }

        }
        return rta;
    }

    public List<JovenPracticante> consultarJoven() {
        Connection c = new AdminConexion().getConnection();
        List<JovenPracticante> lista = new ArrayList<JovenPracticante>();
        if (c != null) {
            PreparedStatement ps;
            try {
                ps = c.prepareStatement("SELECT iden_prac_usu, idprac FROM jovenpracticante");

                ResultSet results = ps.executeQuery();

                while (results.next()) {

                    lista.add(new JovenPracticante(results.getString(1), results.getString(2)));
                }

            } catch (SQLException ex) {
                Logger.getLogger(OperAdmin.class.getName()).log(Level.SEVERE, "Error al insertar vehiculo", ex);
            } finally {
                new AdminConexion().cerrarConnexion(c);
            }
        }
        return lista;

    }

    public Usuario buscarjoven(long pk) {
        Connection c = new AdminConexion().getConnection();
        Usuario encontradousuario = null;
        if (c != null) {
            PreparedStatement ps;
            try {
                ps = c.prepareStatement("SELECT identificacionu, primer_nombre, primer_apellido FROM  usuario where identificacionu=? ");
                ps.setLong(1, pk);
                ResultSet results = ps.executeQuery();

                while (results.next()) {

                    encontradousuario = new Usuario(results.getString(2), results.getString(3));
                }

            } catch (SQLException ex) {
                Logger.getLogger(OperAdmin.class.getName()).log(Level.SEVERE, "Error al insertar vehiculo", ex);
            } finally {
                new AdminConexion().cerrarConnexion(c);
            }
        }
        return encontradousuario;

    }

    public List<Pago> consultaPago() {
          List<Pago> lista = new ArrayList<Pago>();

       Connection c = new AdminConexion().getConnection();
       if (c != null) {

           PreparedStatement ps;
           try {
               ps = c.prepareStatement("SELECT tipopago, descripcionpago, fechapago, idpago, iden_pago_admin, iden_pago_prac\n" +
"	FROM pago;");

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

}
