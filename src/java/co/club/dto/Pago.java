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
    
    public Pago() {
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

    

 

    
    
    
}
