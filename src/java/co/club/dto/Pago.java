/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.dto;

import java.io.Serializable;
import java.sql.Date;


/**
 *
 * @author Familia
 */
public class Pago implements Serializable{
   private String TipoPago;
   private String DescripcionPago;
   private Date Fechapago;
   private String idJovenpracticante;
   private String idAdmin;
   private int idpago; 
    public Pago() {
          }

     public Pago(String TipoPago, String DescripcionPago, Date Fechapago, int idpago, String idAdmin, String idJovenpracticante) {
        this.TipoPago = TipoPago;
        this.DescripcionPago = DescripcionPago;
        this.Fechapago = Fechapago;
        this.idJovenpracticante = idJovenpracticante;
        this.idAdmin = idAdmin;
        this.idpago = idpago;
    }
    public String getTipoPago() {
        return TipoPago;
    }

    public void setTipoPago(String TipoPago) {
        this.TipoPago = TipoPago;
    }

    public String getDescripcionPago() {
        return DescripcionPago;
    }

    public void setDescripcionPago(String DescripcionPago) {
        this.DescripcionPago = DescripcionPago;
    }

    public Date getFechapago() {
        return Fechapago;
    }

    public void setFechapago(Date Fechapago) {
        this.Fechapago = Fechapago;
    }

    public String getIdJovenpracticante() {
        return idJovenpracticante;
    }

    public void setIdJovenpracticante(String idJovenpracticante) {
        this.idJovenpracticante = idJovenpracticante;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

  

    

 

    
    
    
}
