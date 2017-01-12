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
public class Periodo {
    
    private TipoPeriodo tipoPeriodo;
    private Periodicidad periodicidad;
    private Fecha fechaLimitePago;
    
    public Periodo(Periodicidad p, TipoPeriodo tp){
        periodicidad = p;
        tipoPeriodo = tp;
    }    
    
    private void setFechaLimite(){
        
    }
}
