/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Obligaciones;

import Objetos.Periodo;
import Objetos.Regimen;
import Objetos.TipoPeriodo;

/**
 *
 * @author Esteban Pastelín
 */
public abstract class General extends Impuesto {
 
    private Float ingresos;
    private Float egresos;    
    
    public General(Regimen rgm, Periodo per) {
        super(rgm, per);
    }
   
    @Override
    public Float totalPagar() {
        Float iva = (ingresos - egresos) * (float)0.16;
        return iva;
    }    

    public Float getIngresos() {
        return ingresos;
    }

    public void setIngresos(Float ingresos) {
        this.ingresos = ingresos;
    }

    public Float getEgresos() {
        return egresos;
    }

    public void setEgresos(Float egresos) {
        this.egresos = egresos;
    }
    
    
    
}