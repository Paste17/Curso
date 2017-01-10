/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Objetos.Fecha;
import Objetos.RFC;
import Objetos.Regimen;
import java.util.HashSet;

/**
 *
 * @author Esteban Pastelín
 */
public abstract class Persona {
    
    private RFC rfc;
    private HashSet<Direccion> direcciones;
    private String telefono;
    private Fecha fechaInscripcion;
    private Fecha inicioOperaciones;
    private HashSet<Regimen> regimenes;
    
    
}
