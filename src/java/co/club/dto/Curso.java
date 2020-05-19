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
public class Curso implements Serializable{
     
    private long idCruso;
    private int NivelCurso;
    private long idEntrenador;
    private long idJovenpracticante;
     public Curso() {
     }

    public long getIdCruso() {
        return idCruso;
    }

    public void setIdCruso(long idCruso) {
        this.idCruso = idCruso;
    }

    public int getNivelCurso() {
        return NivelCurso;
    }

    public void setNivelCurso(int NivelCurso) {
        this.NivelCurso = NivelCurso;
    }

    public long getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(long idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public long getIdJovenpracticante() {
        return idJovenpracticante;
    }

    public void setIdJovenpracticante(long idJovenpracticante) {
        this.idJovenpracticante = idJovenpracticante;
    }
    
}
