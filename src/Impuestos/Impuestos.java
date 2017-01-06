/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impuestos;

import Objetos.Fecha;
import Objetos.Regimen;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Esteban Pastelín
 */
public class Impuestos {
    
    public static void main(String[] args) {
        
//        Fecha f = new Fecha(1,3,2016);
//        System.out.println(f);
//        System.out.println(f.fechaValida());
//        
//        Fecha f2 = new Fecha(17,04,1994);
//        System.out.println(f.compareTo(f2) + " años");
//        
//        f.adelantarn(1);               
//        System.out.println(f);
//        
//        f.retrasarn(2);
//        System.out.println(f);
//        
//        System.out.println("----------------------------");
//        
//        ArrayList<Fecha> fechasInhabiles = new ArrayList<Fecha>();
//        fechasInhabiles.add(new Fecha(1,1,2017));
//        fechasInhabiles.add(new Fecha(5,2,2017));
//        
//        for(Fecha fechasInhabile : fechasInhabiles){
//            System.out.println(fechasInhabile);
//      }       
        HashSet<Regimen> regimenes = new HashSet<>();
        regimenes.add(Regimen.IEPS);
        regimenes.add(Regimen.CEDULAR);
        regimenes.add(Regimen.INCORPORACION);
        
        for (Regimen regimene : regimenes) {
            System.out.println(regimene);
        }
        
    }
}
