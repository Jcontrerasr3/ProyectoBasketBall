/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.dto;

import java.io.Serializable;


public class Administrador  implements Serializable{
    
    private long idAdministrador;
    private long usuAdministrador;
    public Administrador() {
     }
    public long getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(long idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public long getUsuAdministrador() {
        return usuAdministrador;
    }

    public void setUsuAdministrador(long usuAdministrador) {
        this.usuAdministrador = usuAdministrador;
    }
    
    
    
}
