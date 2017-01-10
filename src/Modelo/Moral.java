/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Objetos.Fecha;

/**
 *
 * @author Esteban Pastelín
 */
public class Moral extends Persona{
    
    private String razonSocial;
    private String tipoSociedad;
    private Fisica representanteLegal;
    private String nombre;
    private Fecha fechaCreacion;

    public Moral(String razonSocial, String tipoSociedad, Fisica representanteLegal, String nombre, Fecha fechaCreacion) {
        this.razonSocial = razonSocial;
        this.tipoSociedad = tipoSociedad;
        this.representanteLegal = representanteLegal;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
    }
    
    
     
}
