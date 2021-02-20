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
import unpa.winforms.ferreteria.el.ProveedorTelefono;
import unpa.winforms.ferreteria.dal.DAL_Alumno;
import unpa.winforms.ferreteria.dal.DAL_Proveedor;
import unpa.winforms.ferreteria.dal.DAL_ProveedorTelefono;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class BLL_ProveedorTelefono {

    //AGREGAR UN NUEVO TELEFONO DEL PROVEEDOR, A PARTIR DEL ID DEL PROVEEDOR
    public int AddToDataBaseProveedorTelefono(Connection dbCon, ProveedorTelefono proveedor) throws Exception {
        try {
            DAL_ProveedorTelefono dal_proveedorTelefono = new DAL_ProveedorTelefono(dbCon, proveedor);
            return dal_proveedorTelefono.addProveedorTelefonoToDataBase();
        } catch (Exception ex) {
            throw ex;
        }
    }

    //ELIMINA TODOS LOS TELEFONOS DEL PROVEEDOR, A PARTIR DEL ID DEL PROVEEDOR
    public int deletProveedorDatabase(Connection dbCon, ProveedorTelefono proveedorTelefono) throws Exception {
        try {
            DAL_ProveedorTelefono dal_proveedorTelefono = new DAL_ProveedorTelefono(dbCon, proveedorTelefono);
            return dal_proveedorTelefono.delete_ProveedorTelefono();
        } catch (Exception ex) {
            throw ex;
        }
    }

    //OBTIENE TODOS LOS TELEFONOS DEL PROVEDOR, A PARTIR DEL ID DEL PROVEEDOR
    public List<ProveedorTelefono> QueryProveedorTelefonoAllDataBase(Connection dbCon, String idProveedor) throws Exception {
        try {
            DAL_ProveedorTelefono dal_proveedorTelefono = new DAL_ProveedorTelefono(dbCon, null);
            return dal_proveedorTelefono.queryProveedorTelefonoToDatabase(idProveedor);
        } catch (Exception ex) {
            throw ex;
        }
    }

    //OBTIENE TODOS LOS TELEFONOS DEL PROVEDOR, A PARTIR DEL ID DEL PROVEEDOR
    public List<ProveedorTelefono> QueryProveedorTelefonoDataBase(Connection dbCon, String idProveedor) throws Exception {
        try {
            DAL_ProveedorTelefono dal_proveedorTelefono = new DAL_ProveedorTelefono(dbCon, null);
            return dal_proveedorTelefono.queryProveedorTelefonoToDatabase(idProveedor);
        } catch (Exception ex) {
            throw ex;
        }
    }

    //ELIMINA TODOS LOS TELEDONOS DEL PROVEEDOR, A PARTIR DEL ID DEL PROVEEDOR
    public int deleteProveedorTelefonoDatabase(Connection dbCon, Proveedor proveedor) throws Exception {
        try {
            DAL_ProveedorTelefono dal_proveedorTelefono = new DAL_ProveedorTelefono(dbCon, null);
            return dal_proveedorTelefono.delete_ProveedorTelefono(proveedor);
        } catch (Exception ex) {
            throw ex;
        }
    }

    //ELIMINA UN NUMERO EN ESPECIFICO DEL PROVEEDOR, A PARTIR DEL ID DEL TELEFONO A ELIMINAR
    public int deleteTelefonoDatabase(Connection dbCon, ProveedorTelefono proveedorTelefono) throws Exception {
        try {
            DAL_ProveedorTelefono dal_proveedorTelefono = new DAL_ProveedorTelefono(dbCon, proveedorTelefono);
            return dal_proveedorTelefono.delete_Telefono();
        } catch (Exception ex) {
            throw ex;
        }
    }

    //ACTUALIZA LOS DATOS DEL TELEFONO EN ESPECIFICO, A PARTIR DEL ID DEL TELEFONO A ACTUALIZARSE
    public int updateProveedorTelefonoDatabase(Connection dbCon, ProveedorTelefono proveedorTelefono) throws Exception {
        try {
            DAL_ProveedorTelefono dal_proveedorTelefono = new DAL_ProveedorTelefono(dbCon, proveedorTelefono);
            return dal_proveedorTelefono.updateProveedorTelefonoToDataBase();
        } catch (Exception ex) {
            throw ex;
        }
    }

}
