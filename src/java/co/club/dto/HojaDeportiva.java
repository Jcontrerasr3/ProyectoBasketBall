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
public class HojaDeportiva implements Serializable{
    private long idHojaVida;
    private String idenPracticante;
    private String Observaciones;
    private int Rendimiento;
    private int habilidad;
    private int compromiso;
    private long cursos;
    private long pago;
    private long evento;
    
     public HojaDeportiva() {
     }

    public long getIdHojaVida() {
        return idHojaVida;
    }

    public void setIdHojaVida(long idHojaVida) {
        this.idHojaVida = idHojaVida;
    }

    public String getIdenPracticante() {
        return idenPracticante;
    }

    public void setIdenPracticante(String idenPracticante) {
        this.idenPracticante = idenPracticante;
    }
    
    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public int getRendimiento() {
        return Rendimiento;
    }

    public void setRendimiento(int Rendimiento) {
        this.Rendimiento = Rendimiento;
    }

    public int getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

    public int getCompromiso() {
        return compromiso;
    }

    public void setCompromiso(int compromiso) {
        this.compromiso = compromiso;
    }

    public long getCursos() {
        return cursos;
    }

    public void setCursos(long cursos) {
        this.cursos = cursos;
    }

    public long getPago() {
        return pago;
    }

    public void setPago(long pago) {
        this.pago = pago;
    }

    public long getEvento() {
        return evento;
    }

    public void setEvento(long evento) {
        this.evento = evento;
    }
    
}
