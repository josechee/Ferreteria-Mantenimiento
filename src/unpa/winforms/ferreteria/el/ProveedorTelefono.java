/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unpa.winforms.ferreteria.el;

import java.sql.Connection;
import java.util.LinkedList;
import unpa.winforms.ferreteria.bll.BLL_ProveedorTelefono;
import unpa.winforms.ferreteria.testUniversity;
import unpa.winforms.ferreteria.util.DbUtil;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class ProveedorTelefono {
    private String idProveedorTelefono;
    private String idProveedor;
    private int tipoTelefono;
    private String descripcionTelefono;
    private String lada;
    private int extension=0; //campo null BD
    private String numero;
    
    private Connection dbCon;
    private DbUtil Conexion;
    BLL_ProveedorTelefono bbl_ProveedorTelefono=null;
   testUniversity u = new testUniversity();
    private LinkedList<ProveedorTelefono> listaTelefonoProveedor = new LinkedList();
   
    public void ProveedorTelefono() {
        
    }
    
    

    
    
    
    public String getIdProveedorTelefono() {
        return idProveedorTelefono;
    }

    public void setIdProveedorTelefono(String idProveedorTelefono) {
        this.idProveedorTelefono = idProveedorTelefono;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(int tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    public String getLada() {
        return lada;
    }

    public void setLada(String lada) {
        this.lada = lada;
    }



    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public String getDescripcionTelefono() {
        return descripcionTelefono;
    }

    public void setDescripcionTelefono(String descripcionTelefono) {
        this.descripcionTelefono = descripcionTelefono;
    }
    
    

        
    public void obtenerTodosLosTelefonosProveedor(){
        try{
            BLL_ProveedorTelefono bbl_ProveedorTelefono = new BLL_ProveedorTelefono();        
            this.listaTelefonoProveedor.addAll(u.ProveedorTelefonoQry(idProveedor));
        }
        catch(Exception e){   
            System.out.println("Problemas al obtener todosd los Telefonos proveedores ");
        } 
   }
    
   
    public ProveedorTelefono obtenerProveedorTelefono(int indice){
        obtenerTodosLosTelefonosProveedor();
//        for(int i=0;i<this.listaTelefonoProveedor.size();i++){
//            if(this.listaTelefonoProveedor.get(i).getDescripcionTelefono().equals(descripcion)){
//                return listaTelefonoProveedor.get(i);
//            }
//        
//        
//        }
        return listaTelefonoProveedor.get(indice);
    }
   
    


}
    
    
    
    

