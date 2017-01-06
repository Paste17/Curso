/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Esteban Pastelín
 */
public class Direccion {
    private TipoDireccion tipo;
    private String calle;
    private String noExterior;
    private String noInterior;
    private String colonia;
    private String cp;
    private String municipio;

    public Direccion(TipoDireccion tipo, String calle, String noExterior, String noInterior, String colonia, String cp, String municipio) {
        this.tipo = tipo;
        this.calle = calle.toUpperCase();
        this.noExterior = noExterior;
        this.noInterior = noInterior;
        this.colonia = colonia;
        this.cp = cp;
        this.municipio = municipio;
    }

    public boolean validar(){
        if (!cp.matches("^[0-9]{5}$")) {
            throw new 
        }
        boolean resultado = true;
        resultado = resultado && cp.matches("^[0-9]{5}$");
        resultado = resultado && calle.matches("[A-Z .]*$");
        return resultado;
    }



}

