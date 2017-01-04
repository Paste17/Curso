/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.Date;

/**
 *
 * @author Esteban Pastelín
 */
public class Fecha {
    
    private Integer dia;
    private Integer mes;
    private Integer anio;
    
    public Fecha(Integer dia, Integer mes, Integer anio){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    
    public Fecha(){
        Date date = new Date();
        dia= date.getDay()+1;
        mes = date.getMonth()+1;
        anio = date.getYear()+1900;
    }
    
    public String toString(){
        return String.format("%d/%d/%d", dia, mes, anio);
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
