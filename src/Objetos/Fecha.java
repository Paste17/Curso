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
    private Object LocalDate;
    
     public void prueba (int ...x){
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);            
        }
    }
    
    private static HashSet<Fecha> diasInhabiles = new  HashSet<>();
    
    public static void agregarDiaInhabil(Fecha fecha){
        diasInhabiles.add(fecha);
    }
    
    public static boolean isDiaInhabil(Fecha fecha){
        return diasInhabiles.contains(fecha);
    }
    
    public Fecha(Integer dia, Integer mes, Integer anio){
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
    
    public String toString(){
        return String.format("%02d/%02d/%d", dia, mes, anio);
    }  
        
    @Override
    public int compareTo(Fecha fechita){
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
    
    public boolean fechaValida(){
        int diaAuxiliar =0;
        
        if((anio >= 1900) && (anio<=2100)){
            if((mes >= 0) && (mes < 13)){
                switch(mes){
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12: diaAuxiliar = 31;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11: diaAuxiliar = 30;
                        break;
                    case 2: diaAuxiliar = anio % 4 == 0 ? 29 : 28;
                        break;
                }
                if ((dia >= 1) && (dia < diaAuxiliar)){
                    return true;
            }
            }
                    }
        return false;       
    }
    
    public void adelantar(){
        this.dia++;
        if(this.dia>=31){
            this.dia=1;
            this.mes++;
            if(this.mes>=12){
                this.mes=1;
                this.anio++;
                }
            }
        }
        
    
    public void adelantarn(int n){
        for(int i=0; i<n; i++){
            this.adelantar();
        }
    }
    
      public void incrementarDiaHabil() {
        do {
            adelantar();
        } while (isDiaInhabil(this));
    }
    
   
    public void incrementarDiaHabil(DayOfWeek ...days) {        
        boolean bandera = false;
        do {
            bandera = false;
            adelantar();
            for (int i = 0; i < days.length; i++) {
                if (days[i] == this.diaSemana()){
                    bandera = true;
                }
            }
        } while (isDiaInhabil(this) || bandera);
    }
      public void retrasar(){
        this.dia--;
        if(this.dia<1){
            this.dia=30;
            this.mes--;
            if(this.mes<1){
                this.mes=12;
                this.anio--;
                }
            }
        }
      
       public void retrasarn(int n){
        for(int i=0; i<n; i++){
            this.retrasar();
        }
    }
   
       
    public void diaSemana(){
        Calendar c = Calendar.getInstance();
        String[] days = new String[]{
            "Domingo",
            "Lunes",
            "Martes",
            "Miércoles",
            "Jueves",
            "Viernes",
            "Sábado",
            "Domingo",
        };
        System.out.println("El dia es: " + days[c.get(Calendar.DAY_OF_WEEK)-1]);
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
