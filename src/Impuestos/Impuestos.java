/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impuestos;

import Excepciones.DireccionException;
import Modelo.Direccion;
import Modelo.Obligaciones.Cedular;
import Modelo.Obligaciones.Ieps;
import Modelo.Obligaciones.Incorporacion;
import Modelo.Obligaciones.Obligacion;
import Objetos.Fecha;
import Objetos.Periodicidad;
import Objetos.Periodo;
import Objetos.Regimen;
import Objetos.TipoDireccion;
import Objetos.TipoPeriodo;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Esteban Pastelín
 */
public class Impuestos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DireccionException {
        
//        Direccion direccion1 = new Direccion(TipoDireccion.FISICA, "reforme", "405", "1", "Centro", "68050", "Oaxaca");
//        Direccion direccion2 = new Direccion(TipoDireccion.SUCURSAL, "reforme", "405", "1", "Centro", "68050", "Oaxaca");
//        Direccion direccion3 = new Direccion(TipoDireccion.SUCURSAL, "reforme", "405", "1", "Centro", "68050", "Oaxaca");
//        
//        HashSet<Direccion> direcciones = new HashSet<>();
//        
//        direcciones.add(direccion1);
//        direcciones.add(direccion2);
//        direcciones.add(direccion3);
//        
//        
//        for (Direccion direccione : direcciones) {
//            System.out.println(direccione);
//        }
//        
//        long ii = direcciones.stream().filter(p-> p.getTipo() == TipoDireccion.FISICA).count();
//        System.out.println(ii);
//    ArrayList<Obligacion> arreglo = new ArrayList<>();
//    
//    Obligacion ob = new Cedular();
//    arreglo.add(ob);
//    arreglo.add(new Ieps());
//    arreglo.add(new Incorporacion());
//    arreglo.add(new Cedular());
//    
////        for (int i = 0; i < arreglo.size(); i++) {
////            arreglo.get(i).metodoPrueba();
////        }
//        
//        //TipoPeriodo p = TipoPeriodo.getPeriodo(Periodicidad.MENSUAL, new Fecha(1,2,2016) );
//        Periodo per = new Periodo(TipoPeriodo.ENE_FEB_MAR,1);
//        System.out.println(per);


        Cedular cedular = new Cedular();
        
        Float f = cedular.calculoImpuesto();
        
        System.out.println(f);
        

    }
    
}