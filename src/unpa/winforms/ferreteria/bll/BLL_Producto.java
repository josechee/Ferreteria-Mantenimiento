/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unpa.winforms.ferreteria.bll;

import java.sql.Connection;
import java.util.LinkedList;
import unpa.winforms.ferreteria.dal.DaL_Producto;
import unpa.winforms.ferreteria.el.Producto;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class BLL_Producto {
    public  LinkedList<Producto> QueryAllProductoDataBase(Connection dbCon, int tipoProducto) throws Exception {
        try {
            DaL_Producto dal_producto = new DaL_Producto(dbCon, null);
            return (LinkedList<Producto>) dal_producto.queryProductosToDatabase(tipoProducto);
        } catch (Exception ex) {
            throw ex;
        }
    }
}
    
    
      

