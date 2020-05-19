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
    private long idEntrenador;
    private String Especialidad;
    private long usuEntrenador;
    
     public Entrenador() {
     }

    public long getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(long idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public long getUsuEntrenador() {
        return usuEntrenador;
    }

    public void setUsuEntrenador(long usuEntrenador) {
        this.usuEntrenador = usuEntrenador;
    }
    
    
    
}
