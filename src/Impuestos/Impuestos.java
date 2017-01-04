/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impuestos;

import Objetos.Fecha;

/**
 *
 * @author Esteban Pastelín
 */
public class Impuestos {
    
    public static void main(String[] args) {
        
        Fecha f = new Fecha(2,11,2017);
        System.out.println(f);
        System.out.println(f.fechaValida());
        
        f.adelantarn(1);               
        System.out.println(f);
        
        f.retrasarn(2);
        System.out.println(f);
    }
}
