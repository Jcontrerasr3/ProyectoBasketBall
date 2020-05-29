/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.dto;

import java.io.Serializable;

/**
 *
 * @author Familia
 */
public class Usuario implements Serializable{
private String usuario;
private String password;
private String primer_nombre;
private String segundo_nombre;
private String primer_apellido;
private String segundo_apellido;
private String sexo;
private String rol;
 public Usuario() {
     }

    public Usuario(String primer_nombre, String primer_apellido) {
       
        this.primer_nombre = primer_nombre;
        this.primer_apellido = primer_apellido;
    }

    public Usuario(String usuario, String password, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, String sexo, String rol) {
        this.usuario = usuario;
        this.password = password;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.sexo = sexo;
        this.rol = rol;
    }

   

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
        
}
