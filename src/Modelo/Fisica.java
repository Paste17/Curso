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
public class Fisica extends Persona{

    private String nombre;
    private String paterno;
    private String materno;
    private String estadoCivil;
    private String nacionalidad;
    private Fecha fechaNacimiento;
    
    public Fisica(String nombre, String paterno, String materno, String estadoCivil, String nacionalidad, Fecha fechaNacimiento) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.estadoCivil = estadoCivil;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }
    
   

}
