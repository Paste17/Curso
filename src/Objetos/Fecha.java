/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.time.*;
import java.util.*;

/**
 *
 * @author Esteban Pastelín
 */
public class Fecha implements Comparable<Fecha> {

    private Integer dia;
    private Integer mes;
    private Integer anio;

    private static HashSet<Fecha> diasInhabiles = new HashSet<>();

    
    public Integer diferenciaAnios(){
        Fecha fechaActual = new Fecha();
        int anios = fechaActual.getAnio() - this.getAnio();
        if (this.getMes() > fechaActual.getMes()){
            anios--;
        }else if ((fechaActual.getMes() == this.getMes())&&((this.getDia() > fechaActual.getDia() ))){
            anios--;
        }
        return anios;
    }
    
    public static void agregarDiaInhabil(Fecha fecha) {
        diasInhabiles.add(fecha);
    }

    public static boolean isDiaInhabil(Fecha fecha) {
        return diasInhabiles.contains(fecha);
    }

    public Fecha(Integer dia, Integer mes, Integer anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public Fecha() {
        LocalDate date = LocalDate.now();
        dia = date.getDayOfMonth();
        mes = date.getMonthValue();
        anio = date.getYear();
    }
    
      public DayOfWeek diaSemana(){
        LocalDate dateTemporal = LocalDate.of(anio, mes, dia);
        return dateTemporal.getDayOfWeek();
    }  

    public String toString() {
        return String.format("%d/%d/%d", dia, mes, anio);
    }

    @Override
    public int compareTo(Fecha fechita) {
        int resultado = this.anio - fechita.anio;
        if (resultado == 0) {
            resultado = this.mes - fechita.mes;
            if (resultado == 0) {
                resultado = this.dia - fechita.dia;
            }
        }
        return resultado;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fecha) {
            Fecha fechita = (Fecha) obj;
            return this.compareTo(fechita) == 0;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.dia);
        hash = 71 * hash + Objects.hashCode(this.mes);
        hash = 71 * hash + Objects.hashCode(this.anio);
        return hash;
    }

    public void incrementar() {
        dia++;
        if (dia > diasDelMes()) {
            mes++;
            dia = 1;
            if (mes > 12) {
                mes = 1;
                anio++;
            }
        }
    }

    public void incrementarDiaHabil() {
        do {
            incrementar();
        } while (isDiaInhabil(this));
    }
    
   
    public void incrementarDiaHabil(DayOfWeek ...days) {        
        boolean bandera = false;
        do {
            bandera = false;
            incrementar();
            for (int i = 0; i < days.length; i++) {
                if (days[i] == this.diaSemana()){
                    bandera = true;
                }
            }
        } while (isDiaInhabil(this) || bandera);
    }
    

    private int diasDelMes() {
        int diaAuxiliar = 0;
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                diaAuxiliar = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diaAuxiliar = 30;
                break;
            case 2:
                diaAuxiliar = anio % 4 == 0 ? 29 : 28;
        }
        return diaAuxiliar;
    }

    public boolean fechaValida() {

        if ((anio >= 1900) && (anio <= 2100)) {
            if ((mes >= 1) && (mes <= 12)) {
                if ((dia >= 1) && (dia <= diasDelMes())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

}