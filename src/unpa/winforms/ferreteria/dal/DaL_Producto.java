/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unpa.winforms.ferreteria.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import unpa.winforms.ferreteria.el.Producto;
import unpa.winforms.ferreteria.el.Usuario;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class DaL_Producto {

    private Producto producto;
    private Connection dbCon;

    public DaL_Producto(Connection _dbCon, Producto _producto) {
        dbCon = _dbCon;
        if (_producto != null) {
            this.producto = _producto;
        } else {
            this.producto = new Producto();
        }
    }

    public List<Producto> queryProductosToDatabase(int tipoProducto) {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        LinkedList<Producto> listaProducto = new LinkedList<Producto>();
        try {
            cstmt = this.dbCon.prepareCall("{call Producto_ConsultarTodo_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setInt("Input_Tipo_Producto", tipoProducto);
            boolean results = cstmt.execute();
            int rowsAffected = 0;

            while (results || rowsAffected != -1) {
                if (results) {
                    rs = cstmt.getResultSet();
                    break;
                } else {
                    rowsAffected = cstmt.getUpdateCount();
                }
                results = cstmt.getMoreResults();
            }
            while (rs.next()) {
                this.producto = new Producto();
                this.producto.setIdProducto(rs.getString("ID_Producto"));
                this.producto.setIdProvedor(rs.getString("ID_Proveedor"));
                this.producto.setIdTipoProdcuto(rs.getInt("ID_tipoProducto"));
                this.producto.setNombre(rs.getString("Nombre"));
                this.producto.setExistencia(rs.getFloat("Existencia"));
                this.producto.setPrecio(rs.getFloat("Precio"));
                this.producto.setMarca(rs.getString("Marca"));
                this.producto.setDescuento(rs.getInt("DescuentoPorciento"));
                listaProducto.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return null;
        }
        return listaProducto;
    }
}
