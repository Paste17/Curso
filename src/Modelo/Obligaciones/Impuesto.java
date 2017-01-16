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
public abstract class Impuesto implements Obligacion{
    
    private Periodo periodo;
    private Regimen regimen;
    
    @Override
    public Float calculoImpuesto(){
        return totalPagar() + calculaRecargos();
    }
    
}
