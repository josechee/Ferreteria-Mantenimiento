/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unpa.winforms.ferreteria.bll;

import java.sql.Connection;
import java.util.List;
import unpa.winforms.ferreteria.dal.DAL_EmpleadoTelefono;
import unpa.winforms.ferreteria.dal.DAL_ProveedorTelefono;
import unpa.winforms.ferreteria.el.Empleado;
import unpa.winforms.ferreteria.el.EmpleadoTelefono;
import unpa.winforms.ferreteria.el.ProveedorTelefono;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class BLL_EmpleadoTelefono {
        public int  AddToDataBaseEmpleadoTelefono(Connection dbCon, EmpleadoTelefono empleadoTelefono) throws Exception {
        try {
            DAL_EmpleadoTelefono dal_empleadoTelefono = new DAL_EmpleadoTelefono(dbCon, empleadoTelefono);
            return dal_empleadoTelefono.addEmpleadoTelefonoToDataBase();
        } catch (Exception ex) {
            throw ex;
        }
    }
        
       
 public List<EmpleadoTelefono> QueryEmpleadoTelefonosDataBase(Connection dbCon,String idEmpleado) throws Exception {
        try {
            DAL_EmpleadoTelefono dal_empleadoTelefono = new DAL_EmpleadoTelefono(dbCon, null);
            return dal_empleadoTelefono.queryProveedorTelefonosToDatabase(idEmpleado);
        } catch (Exception ex) {
            throw ex;
        }
 }
 
 
 public int updateEmpleadoTelefonoDatabase(Connection dbCon, EmpleadoTelefono empleadoTelefono) throws Exception {
        try {
            DAL_EmpleadoTelefono dal_empleadoTelefono = new DAL_EmpleadoTelefono(dbCon, empleadoTelefono);
            return dal_empleadoTelefono.updateEmpleadoTelefonoToDataBase();
        } catch (Exception ex) {
            throw ex;
        }
 }
 
    public int deleteEmpleadoTelefonoDatabase(Connection dbCon, Empleado empleado) throws Exception {
        try {
            DAL_EmpleadoTelefono dal_empleadoTelefono = new DAL_EmpleadoTelefono(dbCon, null);
            return dal_empleadoTelefono.delete_EmpleadoTelefono(empleado);
        } catch (Exception ex) {
            throw ex;
        }
    } 




    
}
