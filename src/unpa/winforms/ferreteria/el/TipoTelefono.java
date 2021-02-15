/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unpa.winforms.ferreteria.el;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class TipoTelefono {
    private final int telefonoPersonal=1;
    private final int telefonoCasa=2;
    private final int telefonoOficina=3;

    public TipoTelefono(){ 
            
            
    }

    public int getTelefonoPersonal() {
        return telefonoPersonal;
    }

    public int getTelefonoCasa() {
        return telefonoCasa;
    }

    public int getTelefonoOficina() {
        return telefonoOficina;
    } 
}