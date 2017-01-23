/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Excepciones.IntervalosFechaException;
import Excepciones.PersonaFisicaException;
import Excepciones.RFCException;
import GUI.Componentes.TEdit;
import Modelo.Fisica;
import Modelo.Persona;
import Objetos.Fecha;
import Objetos.RFC;
import Objetos.TipoPersona;
import javax.swing.JFrame;

/**
 *
 * @author Esteban Pastelín
 */
public class FisicaDialog extends PersonaDialog {
    
    private TEdit edtNombre;
    private TEdit edtPaterno;
    private TEdit edtMaterno;
    
    public FisicaDialog(JFrame frame) {
        super(frame);
        
        edtNombre = new TEdit("Nombre:", 7);
        edtNombre.setBounds(50, 100);
        edtPaterno = new TEdit("Paterno", 6);
        edtPaterno.setBounds(230, 100);
        edtMaterno = new TEdit("Materno", 6);
        edtMaterno.setBounds(400, 100);
        
        super.getPnlElementos().add(edtNombre);
        super.getPnlElementos().add(edtPaterno);
        super.getPnlElementos().add(edtMaterno);

    }

    @Override
    protected Persona crearObjeto() throws IntervalosFechaException, PersonaFisicaException, RFCException {
        Fisica fisica = new Fisica(new RFC(super.edtRFC.getText(), TipoPersona.FISICA), 
                edtNombre.getText(), 
                edtPaterno.getText(), 
                edtMaterno.getText(), 
                new Fecha(4,9,1981), 
                super.edtTelefono.getText(), 
                new Fecha(), 
                new Fecha());
        return fisica;
    }
    
}