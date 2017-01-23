/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Obligaciones;

import Objetos.Periodo;
import Objetos.Regimen;

/**
 *
 * @author Esteban Pastelín
 */
public class Hospedaje extends General{
    
     public Hospedaje(Periodo per) {
        super(Regimen.HOSPEDAJE, per);
    }

    @Override
    public Float totalPagar() {
        Float impuesto = getIngresos() * (float)0.02;
        return super.totalPagar() + impuesto;
    }
    
    
    
    
    
}
    

