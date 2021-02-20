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
import java.util.ArrayList;
import java.util.List;
import unpa.winforms.ferreteria.el.Proveedor;
import unpa.winforms.ferreteria.el.ProveedorTelefono;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class DAL_ProveedorTelefono {

    private ProveedorTelefono proveedorTelefono;
    private Connection dbCon;

    //
    public DAL_ProveedorTelefono(Connection _dbCon, ProveedorTelefono _proveedorTelefono) {
        dbCon = _dbCon;
        if (_proveedorTelefono != null) {
            this.proveedorTelefono = _proveedorTelefono;
        } else {
            this.proveedorTelefono = new ProveedorTelefono();
        }
    }

    //INSERTA UN TLEEFONO DEL PROVEEDOR,PASANDO COMO ATRIBUTO TAMBIEN SU ID DEL PROVEEDOR  
    public int addProveedorTelefonoToDataBase() throws SQLException {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call ProveedorTelefono_Insertar_SP(?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("Input_ID_Proveedor", this.proveedorTelefono.getIdProveedor());
            cstmt.setInt("Input_ID_TipoTelefono", this.proveedorTelefono.getTipoTelefono());
            cstmt.setString("Input_Lada", this.proveedorTelefono.getLada());
            cstmt.setInt("Input_Extension", this.proveedorTelefono.getExtension());
            cstmt.setString("Input_Numero", this.proveedorTelefono.getNumero());

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
            if (rs.next()) {
                verificador = rs.getInt("indicador");//CAPTURA EL INDICADOR (1), QUE INDICA UNA INSERCION EXITOSA
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return 0;
        }
        return verificador;//RETORNA EL INDICADOR SI SE REALIZO LA INSERCION CORRECTAMENTE O NO

    }

    //ACTUALIZA LOS DATOS DEL TELEFONO DEL PROVEEDOR EN ESPECIFIO, A PARTIR DEL ID DE ESTE TELEFONO A ACTUALIZARSE
    public int updateProveedorTelefonoToDataBase() throws SQLException {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call ProveedorTelefono_Actualizar_SP(?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("Input_ID_Proveedor_Telefono", this.proveedorTelefono.getIdProveedorTelefono());
            cstmt.setString("Input_Lada", this.proveedorTelefono.getLada());
            cstmt.setInt("Input_Extension", this.proveedorTelefono.getExtension());
            cstmt.setString("Input_Numero", this.proveedorTelefono.getNumero());

            boolean results = cstmt.execute();  //esta parte esta tronando
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
            if (rs.next()) {
                verificador = rs.getInt("1");//CAPTURA EL INDICADOR (1), QUE INDICA UNA INSERCION EXITOSA
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return 0;
        }
        return verificador;//RETORNA EL INDICADOR SI SE REALIZO LA INSERCION CORRECTAMENTE O NO
    }

    //EMININA TODOS LOS TELEFONOS DEL PROVEEDOR, A PARTIR DEL ID DE ESTE PROVEEDOR
    public int delete_ProveedorTelefono() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call ProveedorTelefono_Eliminar_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Proveedor", this.proveedorTelefono.getIdProveedor());

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
            if (rs.next()) {
                verificador = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return 0;
        }
        return verificador;
    }

    //ELIMINA LOS TELEFONOS DEL PROVEEDOR; A PARTIR DEL ID DE PROVEEDOR, IGUAL AL METODO DE ARRIBA
    //SALVO QUE ESTE SE LE PASA COMO PARAMETRO AL OBJETO PROVEEDOR
    public int delete_ProveedorTelefono(Proveedor proveedor) {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call ProveedorTelefono_Eliminar_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Proveedor", proveedor.getIdProveedor());////////////

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

            if (rs.next()) {
                verificador = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return 0;
        }
        return verificador;
    }

    //ELIMINA UN TELEFONO DEL PROVEEDOR EN ESPECIFICO, A PARTIR DEL ID DEL PROPIO TELEFONO A ELIMINAR
    public int delete_Telefono() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call EliminarTelefonoProveedor_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Proveedor_Telefono", this.proveedorTelefono.getIdProveedorTelefono());////////////

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
            if (rs.next()) {
                verificador = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return 0;
        }
        return verificador;
    }

    //OBTIENE TODOS LOS TELEFONOS QUE EXISTEN EN LA BASE DE DATOS
    public List<ProveedorTelefono> queryAllProveedorTelefonoToDatabase() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        List<ProveedorTelefono> listaProveedorTelefono = new ArrayList<ProveedorTelefono>();
        try {
            cstmt = this.dbCon.prepareCall("{call ProveedorTelefono_ConsultarTodo_SP()}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

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
                this.proveedorTelefono = new ProveedorTelefono();
                this.proveedorTelefono.setIdProveedorTelefono(rs.getString("ID_ProveedorTelefono"));
                this.proveedorTelefono.setIdProveedor(rs.getString("ID_Proveedor"));
                this.proveedorTelefono.setTipoTelefono(rs.getInt("ID_TipoTelefono"));
                this.proveedorTelefono.setLada(rs.getString("Lada"));
                this.proveedorTelefono.setExtension(rs.getInt("Extension"));
                this.proveedorTelefono.setNumero(rs.getString("Numero"));

                listaProveedorTelefono.add(proveedorTelefono);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return null;
        }
        return listaProveedorTelefono;
    }

    //CONSULTA PROVEEDOR_TABLA_MULTIPLE INNER_JOIN PROVEEDOR_TELEFON0
    //OBTIENE TODOS LOS TELEFONOS EXISTENTES DEL PROVEEDOR , A PARTIR DEL ID DE ESTE PROVEEDOR
    public List<ProveedorTelefono> queryProveedorTelefonoToDatabase(String IdProveedor) {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        List<ProveedorTelefono> listaProveedoTelefono = new ArrayList<ProveedorTelefono>();
        try {
            cstmt = this.dbCon.prepareCall("{call ProveedorTelefono_Consultar_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Proveedor", IdProveedor);
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
                this.proveedorTelefono = new ProveedorTelefono();
                this.proveedorTelefono.setIdProveedorTelefono(rs.getString("ID_ProveedorTelefono"));
                this.proveedorTelefono.setIdProveedor(rs.getString("ID_Proveedor"));                
                this.proveedorTelefono.setTipoTelefono(rs.getInt("ID_TipoTelefono"));
                this.proveedorTelefono.setLada(rs.getString("Lada"));
                this.proveedorTelefono.setExtension(rs.getInt("Extension"));
                this.proveedorTelefono.setNumero(rs.getString("Numero"));

                listaProveedoTelefono.add(proveedorTelefono);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return null;
        }
        return listaProveedoTelefono;
    }

}
