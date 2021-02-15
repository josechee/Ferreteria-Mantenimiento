/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unpa.winforms.ferreteria.bll;

import java.sql.Connection;
import unpa.winforms.ferreteria.dal.DAL_Empleado;
import unpa.winforms.ferreteria.el.Empleado;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class BLL_Empleado {  
    //INSERTAR UN EMPLEADO
    public String AddToDataBaseEmpleado(Connection dbCon, Empleado empleado) throws Exception {
        try {
            DAL_Empleado dal_empleado = new DAL_Empleado(dbCon, empleado);
            return dal_empleado.addProveedorToDataBase();
        } catch (Exception ex) {
            throw ex;
        }
    } 
    //CONSULTAR TABLA EMPLEADO
    public Empleado QueryDataBase(Connection dbCon, String  idEmpleado) throws Exception {
        try {
            DAL_Empleado dal_empleado = new DAL_Empleado(dbCon, null);
            return dal_empleado.queryEmpleadoToDatabase(idEmpleado);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public int updateEmpleadoDataBase(Connection dbCon, Empleado empleado) throws Exception {
        try {
            DAL_Empleado dal_empleado = new DAL_Empleado(dbCon, empleado);
            return dal_empleado.updateEmpleadoDataBase();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public int deleteEmpleadoDatabase(Connection dbCon, Empleado empleado) throws Exception {
        try {
            DAL_Empleado dal_empleado = new DAL_Empleado(dbCon, empleado);
            return dal_empleado.delete_Empleado();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
