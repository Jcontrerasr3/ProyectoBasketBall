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
public class Entrenador implements Serializable{
    private String idEntrenador;
    private String Especialidad;
    private String usuEntrenador;
    
     public Entrenador() {
     }


    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public String getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(String idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getUsuEntrenador() {
        return usuEntrenador;
    }

    public void setUsuEntrenador(String usuEntrenador) {
        this.usuEntrenador = usuEntrenador;
    }
    
    
    
}
