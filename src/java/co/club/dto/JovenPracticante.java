/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.club.dto;

/**
 *
 * @author Familia
 */
public class JovenPracticante {
     private long idPracticante;
     private long UsuJovenPracticante;
     private int TipoMensualidad;
     private int NivelJoven;
     private String EnfoqueJoven;
     
     public JovenPracticante() {
     }

    public JovenPracticante(long idPracticante, long UsuJovenPracticante) {
        this.idPracticante=idPracticante;
        this.UsuJovenPracticante=UsuJovenPracticante;
    }   

    public long getIdPracticante() {
        return idPracticante;
    }

    public void setIdPracticante(long idPracticante) {
        this.idPracticante = idPracticante;
    }

    public long getUsuJovenPracticante() {
        return UsuJovenPracticante;
    }

    public void setUsuJovenPracticante(long UsuJovenPracticante) {
        this.UsuJovenPracticante = UsuJovenPracticante;
    }

    public int getTipoMensualidad() {
        return TipoMensualidad;
    }

    public void setTipoMensualidad(int TipoMensualidad) {
        this.TipoMensualidad = TipoMensualidad;
    }

    public int getNivelJoven() {
        return NivelJoven;
    }

    public void setNivelJoven(int NivelJoven) {
        this.NivelJoven = NivelJoven;
    }

    public String getEnfoqueJoven() {
        return EnfoqueJoven;
    }

    public void setEnfoqueJoven(String EnfoqueJoven) {
        this.EnfoqueJoven = EnfoqueJoven;
    }

   
    
    
    
}
