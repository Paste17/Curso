/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impuestos;

import Excepciones.DireccionException;
import Excepciones.IntervalosFechaException;
import Excepciones.PersonaFisicaException;
import Excepciones.RFCException;
import Excepciones.RegimenIncompatibleException;
import GUI.PrincipalFrame;
import Modelo.Direccion;
import Modelo.Fisica;
import Modelo.Moral;
import Modelo.Obligaciones.Cedular;
import Modelo.Obligaciones.Ieps;
import Modelo.Obligaciones.Incorporacion;
import Modelo.Obligaciones.Obligacion;
import Objetos.Fecha;
import Objetos.Periodicidad;
import Objetos.Periodo;
import Objetos.RFC;
import Objetos.Regimen;
import Objetos.TipoDireccion;
import Objetos.TipoPeriodo;
import Objetos.TipoPersona;
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
    public static void main(String[] args) throws DireccionException, RegimenIncompatibleException {
        
         PrincipalFrame main = new PrincipalFrame();

        Fisica fisica = null;
        Moral moral = null;
        Fisica juan = null;
        
        try {
            RFC rfc = new RFC("RIOD810904815", TipoPersona.FISICA);        
            fisica = new Fisica(rfc, "Daniel Karim", "Ricardez", "Ortiz", new Fecha(4,9,1981), "9515693556", new Fecha(15,12,2003), new Fecha(15, 12, 2003));

            juan = new Fisica(new RFC("GABJ9403189IP", TipoPersona.FISICA), "Juan Antonio", "Gabriel", "Bolaños", new Fecha(18,3,1994), "9512515114", new Fecha(15, 8, 2016), new Fecha(1, 12, 2017));
            
            moral = new Moral(new RFC("AAA900912", TipoPersona.MORAL), "Provedora Escolar", "S.C. de R.L.", fisica, "5130223", new Fecha(1,1,2000), new Fecha(1, 1, 2000), new Fecha(1, 1, 2000));
        } catch (IntervalosFechaException ex) {
            ex.printStackTrace();
        } catch (PersonaFisicaException ex) {
            ex.printStackTrace();
        } catch (RFCException ex) {
            ex.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        
        Direccion direccinoFisica = new Direccion(TipoDireccion.FISICA, "Prolg. Almendros", "509", "1", "Las Flores", "68050", "Oaxaca de Juarez");
        Direccion direccinoFiscal = new Direccion(TipoDireccion.FISCAL, "Prolg. Almendros", "509", "1", "Las Flores", "68050", "Oaxaca de Juarez");
        
        fisica.addDireccion(direccinoFisica);
        fisica.addDireccion(direccinoFiscal);
        
        moral.addDireccion(direccinoFiscal);
        moral.addDireccion(direccinoFisica);
        
        
        juan.addDireccion(new Direccion(TipoDireccion.FISCAL, "Cui", "12", null, "Del Valle", "68150", "Xoxo"));
        
        try {
            fisica.addRegimen(Regimen.INCORPORACION);
            fisica.addRegimen(Regimen.IEPS);
            
            moral.addRegimen(Regimen.IEPS);
            
            juan.addRegimen(Regimen.INCORPORACION);
            
            //fisica.addRegimen(Regimen.INTERMEDIO);
        } catch (RegimenIncompatibleException ex) {
            ex.printStackTrace();
        }
        
        juan.actualizarObligaciones();
        
        Incorporacion incor = (Incorporacion)juan.getObligacion(Regimen.INCORPORACION);
        System.out.println(incor);
        
        incor.setIngresosBismestrales((float)34000);
        System.out.println(incor.totalPagar());
        incor.setObligacionCumplida(true);
       
        Incorporacion incor2 = (Incorporacion)juan.getObligacion(Regimen.INCORPORACION);
        System.out.println(incor2);
        


//        TipoPeriodo tp = TipoPeriodo.getPeriodo(Periodicidad.TRIMESTRAL, new Fecha(1,9,2015));
//
//        Periodo periodo = new Periodo(tp, 2016);
//        
//        Integer anioActual = (new Fecha()).getAnio();
//        
//        do{
//            System.out.println(periodo);
//            periodo = periodo.next();
//        }while(periodo.getEjercicio() <= anioActual);
//        
//        
//        



        
    }

}



