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
public class Evento implements Serializable{
    private long idEventoCurso;
    private long idenCurso;
    private long idenEvento;
     public Evento() {
     }

    public long getIdEventoCurso() {
        return idEventoCurso;
    }

    public void setIdEventoCurso(long idEventoCurso) {
        this.idEventoCurso = idEventoCurso;
    }

    public long getIdenCurso() {
        return idenCurso;
    }

    public void setIdenCurso(long idenCurso) {
        this.idenCurso = idenCurso;
    }

    public long getIdenEvento() {
        return idenEvento;
    }

    public void setIdenEvento(long idenEvento) {
        this.idenEvento = idenEvento;
    }
     
     
}
