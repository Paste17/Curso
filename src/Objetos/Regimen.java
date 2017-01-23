/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Esteban Pastelín
 */
public enum Regimen {
     
    INCORPORACION(Periodicidad.BIMESTRAL),
    INTERMEDIO(Periodicidad.MENSUAL),
    CEDULAR(Periodicidad.BIMESTRAL),
    HOSPEDAJE(Periodicidad.TRIMESTRAL),
    IEPS(Periodicidad.MENSUAL);
    
    private Regimen(Periodicidad periodicidad){
        this.periodicidad = periodicidad;
    }
    
    private Periodicidad periodicidad;

    public Periodicidad getPeriodicidad() {
        return periodicidad;
    }
    
}