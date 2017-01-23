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
public class Cedular extends Impuesto{
    
    private Float totalCasaHabitacion;
    private Float totalLocalComercial;

    public Cedular(Periodo per){
        super(Regimen.CEDULAR, per);
    }    
   
    @Override
    public Float totalPagar() {
        Float total = totalCasaHabitacion * (float)0.10 + totalLocalComercial * (float)0.25;
        Float iva = (totalCasaHabitacion + totalLocalComercial) * (float)0.16;
        return total + iva;
    }

}