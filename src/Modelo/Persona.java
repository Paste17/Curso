/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Excepciones.IntervalosFechaException;
import Excepciones.RegimenIncompatibleException;
import Modelo.Obligaciones.Cedular;
import Modelo.Obligaciones.Hospedaje;
import Modelo.Obligaciones.Ieps;
import Modelo.Obligaciones.Impuesto;
import Modelo.Obligaciones.Incorporacion;
import Modelo.Obligaciones.Intermedio;
import Modelo.Obligaciones.Obligacion;
import Objetos.Fecha;
import Objetos.HashConjunto;
import Objetos.Periodo;
import Objetos.RFC;
import Objetos.Regimen;
import Objetos.TipoDireccion;
import Objetos.TipoPeriodo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Esteban Pastelín
 */
public abstract class Persona {
    
    private RFC rfc;
    private HashSet<Direccion> direcciones;
    private String telefono;
    private Fecha fechaInscripcion;
    private Fecha fechaInicioOperaciones;
    private HashConjunto regimenes;
    private ArrayList<Obligacion> obligaciones;

    public Persona(RFC rfc, String telefono, Fecha fechaInscripcion, Fecha fechaInicioOperaciones) throws IntervalosFechaException {
        this.rfc = rfc;
        this.telefono = telefono;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaInicioOperaciones = fechaInicioOperaciones;
        direcciones = new HashSet<>();
        regimenes = new HashConjunto();
        obligaciones = new ArrayList<>();
    }
        
    public boolean isValido(){
        return fechaInscripcion.compareTo(fechaInicioOperaciones) <= 0;
    }
    
    public boolean addDireccion(Direccion direccion){
        return direcciones.add(direccion);
    }
    
    public boolean isDireccion(TipoDireccion td){
        return direcciones.stream().filter(obj -> obj.getTipo() == td).count() > 0;
    }
    
    public Direccion getDireccion(TipoDireccion td){
        Direccion direccionRetorno = null;
        for (Direccion direccioncita : direcciones) {
             if (direccioncita.getTipo() == td ){
                 direccionRetorno = direccioncita;
             }
        }
        return direccionRetorno;
    }
    
    public List<Direccion> getDirecciones(){
        return new ArrayList<>(direcciones);
    }
    
    public void addRegimen(Regimen rgm) throws RegimenIncompatibleException{
        if (!regimenes.add(rgm)){
            throw new RegimenIncompatibleException();
        }
    }
    
    public List<Regimen> getRegimenes(){
        return new ArrayList<>(regimenes);
    }
    
    
    public void actualizarObligaciones(){         
        Integer anio = fechaInicioOperaciones.getAnio();
        for (Regimen regimen : regimenes) {
            TipoPeriodo tp = TipoPeriodo.getPeriodo(regimen.getPeriodicidad(), fechaInicioOperaciones);
            Periodo periodo = new Periodo(tp, anio);  
            Integer anioActual = (new Fecha()).getAnio();
            do{
            Obligacion obligacion = null;
            switch (regimen) {
                case INCORPORACION:
                    obligacion = new Incorporacion(periodo);
                    break;
                case INTERMEDIO:
                    obligacion = new Intermedio(periodo);
                    break;
                case CEDULAR:
                    obligacion = new Cedular(periodo);
                    break;                
                case IEPS:
                    obligacion = new Ieps(periodo);
                    break;                
                case HOSPEDAJE:
                    obligacion = new Hospedaje(periodo);
                    break;                
                default:
                    throw new AssertionError();
            }
            obligaciones.add(obligacion);
            periodo = periodo.next();
            }while(periodo.getEjercicio() <= anioActual);
        }
    }
     
    public Obligacion getObligacion(Regimen regimen){
        for (Obligacion obligacion : obligaciones) {
            Impuesto impuesto = (Impuesto)obligacion;
            if (impuesto.getRegimen() == regimen){
                if (!impuesto.getObligacionCumplida()){
                    return impuesto;
                }
            }
        }
        return null;
    }
    
    
    public RFC getRfc() {
        return rfc;
    }

    public void setRfc(RFC rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Fecha getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Fecha fechaInscripcion) throws IntervalosFechaException {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Fecha getFechaInicioOperaciones() {
        return fechaInicioOperaciones;
    }

    public void setFechaInicioOperaciones(Fecha fechaInicioOperaciones) {
        this.fechaInicioOperaciones = fechaInicioOperaciones;
    }
    
    
}