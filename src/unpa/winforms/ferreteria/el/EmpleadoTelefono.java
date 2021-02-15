/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unpa.winforms.ferreteria.el;

import java.sql.Connection;
import java.util.LinkedList;
import unpa.winforms.ferreteria.bll.BLL_EmpleadoTelefono;
import unpa.winforms.ferreteria.bll.BLL_ProveedorTelefono;
import unpa.winforms.ferreteria.testUniversity;
import unpa.winforms.ferreteria.util.DbUtil;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class EmpleadoTelefono {
    private String idEmpleadTelefono;
    private String idEmpleado;
    private int tipoTelefono;
    private String descripcionTelefono;
    private String lada;
    private int extension=0; //campo null BD
    private String numero;
    
    
    
    private Connection dbCon;
    private DbUtil Conexion;
    BLL_EmpleadoTelefono bbl_EmpleadoTelefono=null;
    private LinkedList<EmpleadoTelefono> listaTelefonoEmpleado = new LinkedList();
   
    public EmpleadoTelefono(){
    
    
   }

    public String getIdEmpleadTelefono() {
        return idEmpleadTelefono;
    }

    public void setIdEmpleadTelefono(String idEmpleadTelefono) {
        this.idEmpleadTelefono = idEmpleadTelefono;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(int tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    public String getDescripcionTelefono() {
        return descripcionTelefono;
    }

    public void setDescripcionTelefono(String descripcionTelefono) {
        this.descripcionTelefono = descripcionTelefono;
    }

    public String getLada() {
        return lada;
    }

    public void setLada(String lada) {
        this.lada = lada;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Connection getDbCon() {
        return dbCon;
    }

    public void setDbCon(Connection dbCon) {
        this.dbCon = dbCon;
    }

    public DbUtil getConexion() {
        return Conexion;
    }

    public void setConexion(DbUtil Conexion) {
        this.Conexion = Conexion;
    }

    public BLL_EmpleadoTelefono getBbl_EmpleadoTelefono() {
        return bbl_EmpleadoTelefono;
    }

    public void setBbl_EmpleadoTelefono(BLL_EmpleadoTelefono bbl_EmpleadoTelefono) {
        this.bbl_EmpleadoTelefono = bbl_EmpleadoTelefono;
    }

 

    public LinkedList<EmpleadoTelefono> getListaTelefonoEmpleado() {
        return listaTelefonoEmpleado;
    }

    public void setListaTelefonoEmpleado(LinkedList<EmpleadoTelefono> listaTelefonoEmpleado) {
        this.listaTelefonoEmpleado = listaTelefonoEmpleado;
    }
    
//    public void obtenerTodosLosTelefonosEmpleado(){
//        try{
//            BLL_ProveedorTelefono bbl_ProveedorTelefono = new BLL_ProveedorTelefono();        
//            this.listaTelefonoEmpleado.addAll(u.ProveedorTelefonoQry(idEmpleado));
//        }
//        catch(Exception e){   
//            System.out.println("Problemas al obtener todos los Telefonos Empleados .entity layer ");
//        } 
//   }
    
   
    
    
    
}
