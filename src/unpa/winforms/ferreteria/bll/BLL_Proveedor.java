/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unpa.winforms.ferreteria.bll;

import java.sql.Connection;
import java.util.List;
import unpa.winforms.ferreteria.el.Alumno;
import unpa.winforms.ferreteria.el.Proveedor;
import unpa.winforms.ferreteria.dal.DAL_Alumno;
import unpa.winforms.ferreteria.dal.DAL_Proveedor;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class BLL_Proveedor {

    //AGREGAR UN NUEVO PROVEEDOR
    public String AddToDataBaseProveedor(Connection dbCon, Proveedor proveedor) throws Exception {
        try {
            DAL_Proveedor dal_proveedor = new DAL_Proveedor(dbCon, proveedor);
            return dal_proveedor.addProveedorToDataBase();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //CONSULTAR  PROVEEDOR A PARTIR DEL NOMBRE INTRODUCIDO EN EL CAMPO NOMBRE EN LA INTERFAZ GRAFICA DEL USUARIO
    public Proveedor QueryProveedorForNameDataBase(Connection dbCon, String nombreProveedor) throws Exception {
        try {
            DAL_Proveedor dal_proveedor = new DAL_Proveedor(dbCon, null);
            return dal_proveedor.queryProveedorForNameToDatabase(nombreProveedor);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //CONSULTAR PROVEEDOR A PARTIR DE SU ID, SIN ARGUMENTO
    public Proveedor QueryDataBase(Connection dbCon, Proveedor proveedor) throws Exception {
        try {
            DAL_Proveedor dal_proveedor = new DAL_Proveedor(dbCon, proveedor);
            return dal_proveedor.queryProveedorToDatabase();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //CONSULTAR PROVEEDOR A PARTIR DE SU ID, CON ARGUMENTO
    public Proveedor QueryProveedorDataBase(Connection dbCon, String _idProveedor) throws Exception {
        try {
            DAL_Proveedor dal_proveedor = new DAL_Proveedor(dbCon, null);
            return dal_proveedor.queryProveedorToDatabase(_idProveedor);
        } catch (Exception ex) {
            throw ex;
        }
    }

    //ELIMINAR PROVEEDOR A PARTIR DE SU ID
    public int deleteProveedorDatabase(Connection dbCon, Proveedor proveedor) throws Exception {
        try {
            DAL_Proveedor dal_proveedor = new DAL_Proveedor(dbCon, proveedor);
            return dal_proveedor.delete_Proveedor();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //OBTENER TODOS LOS PROVEEDORES EXISTENTES EN LA BASE DE DATOS
    public List<Proveedor> QueryAllProveedorDataBase(Connection dbCon, String Matricula) throws Exception {
        try {
            DAL_Proveedor dal_proveedor = new DAL_Proveedor(dbCon, null);
            return dal_proveedor.queryAllProveedorToDatabase(null);
        } catch (Exception ex) {
            throw ex;
        }
    }

    //ACTUALIZAR PROVEEDOR, A PARTIR DE SU ID
    public int updateProveedorDataBase(Connection dbCon, Proveedor proveedor) throws Exception {
        try {
            DAL_Proveedor dal_proveedor = new DAL_Proveedor(dbCon, proveedor);
            return dal_proveedor.updateProveedorDataBase();
        } catch (Exception ex) {
            throw ex;
        }
    }

}
