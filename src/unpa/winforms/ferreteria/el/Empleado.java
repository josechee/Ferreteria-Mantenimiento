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
public class Empleado extends Persona{
    private String id_Empleado;
    private String id_Usuario;
    private int id_TipoEmpleado;
    private String fechaNacimiento;
    private String calle;
    private String colonia;
    private String ciudad;
    private int codigoPostal;
    
    public Empleado(){
        
    
    }

    public String getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(String id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public String getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(String id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public int getId_TipoEmpleado() {
        return id_TipoEmpleado;
    }

    public void setId_TipoEmpleado(int id_TipoEmpleado) {
        this.id_TipoEmpleado = id_TipoEmpleado;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
}
