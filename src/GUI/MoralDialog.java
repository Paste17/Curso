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
import Modelo.Moral;
import Modelo.Persona;
import Objetos.Fecha;
import Objetos.RFC;
import Objetos.TipoPersona;
import javax.swing.JFrame;

/**
 *
 * @author Esteban Pastelín
 */
public class MoralDialog extends PersonaDialog{
    
    private TEdit edtRazonSocial;
    private TEdit edtTipoSociedad;
    
    public MoralDialog(JFrame frame) {
        super(frame);
        
        edtRazonSocial = new TEdit("RazonSocial:", 7);
        edtRazonSocial.setBounds(50, 100);
        edtTipoSociedad = new TEdit("Tipo", 6);
        edtTipoSociedad.setBounds(230, 100);
        
        super.getPnlElementos().add(edtRazonSocial);
        super.getPnlElementos().add(edtTipoSociedad);
        
    }

    @Override
    protected Persona crearObjeto() throws IntervalosFechaException, PersonaFisicaException, RFCException {
        Moral moral = new Moral (new RFC(super.edtRFC.getText(), TipoPersona.MORAL), 
                edtRazonSocial.getText(), 
                edtTipoSociedad.getText(), 
                null, 
                super.edtTelefono.getText(), 
                new Fecha(), 
                new Fecha(),
                new Fecha());    
        return moral;
    }
    
}