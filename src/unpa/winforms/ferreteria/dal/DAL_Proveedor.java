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
import unpa.winforms.ferreteria.el.Alumno;
import unpa.winforms.ferreteria.el.Proveedor;
import unpa.winforms.ferreteria.el.ProveedorTelefono;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class DAL_Proveedor {

    private Proveedor proveedor;
    private Connection dbCon;

    public DAL_Proveedor(Connection _dbCon, Proveedor _proveedor) {
        dbCon = _dbCon;
        if (_proveedor != null) {
            this.proveedor = _proveedor;
        } else {
            this.proveedor = new Proveedor();
        }
    }

    public String addProveedorToDataBase() throws SQLException {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        String verificador = null;
        try {
            cstmt = this.dbCon.prepareCall("{call Proveedor_Insertar_SP(?,?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //cstmt.setString("Out_Matricula", this.alumno.getMatricula());

            cstmt.setString("Input_Nombre", this.proveedor.getNombre());
            cstmt.setString("Input_Calle", this.proveedor.getCalle());
            cstmt.setString("Input_Colonia", this.proveedor.getColonia());
            cstmt.setString("Input_Ciudad", this.proveedor.getCiudad());
            cstmt.setInt("Input_CodigoPostal", this.proveedor.getCodigoPostal());
            //  cstmt.setString("Out_ID_Proveedor",null);
            // cstmt.setString("Out_ID_Proveedor", this.getIdProveedor());

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
                //verificador = rs.getInt(1);
                verificador = rs.getString("idProveedor");//aqui se captura el ide del proveedor
            }

        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return null;
        }
        return verificador;//retorna el id del Proveedor

    }

    public Proveedor queryProveedorToDatabase() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call Proveedor_Consultar_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Proveedor", this.proveedor.getIdProveedor());
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
                this.proveedor = new Proveedor();
                this.proveedor.setIdProveedor(rs.getString("ID_Proveedor"));
                this.proveedor.setNombre(rs.getString("Nombre"));
                this.proveedor.setCalle(rs.getString("Calle"));
                this.proveedor.setColonia(rs.getString("Colonia"));
                this.proveedor.setCiudad(rs.getString("Ciudad"));
                this.proveedor.setCodigoPostal(rs.getInt("CodigoPostal"));

            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return this.proveedor;
        }
        return this.proveedor;
    }
    ///////////////////////////////////////////////////

    public Proveedor queryProveedorToDatabase(String idProveedor) {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call Proveedor_Consultar_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Proveedor", idProveedor);
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
                this.proveedor = new Proveedor();
                this.proveedor.setIdProveedor(rs.getString("ID_Proveedor"));
                this.proveedor.setNombre(rs.getString("Nombre"));
                this.proveedor.setCalle(rs.getString("Calle"));
                this.proveedor.setColonia(rs.getString("Colonia"));
                this.proveedor.setCiudad(rs.getString("Ciudad"));
                this.proveedor.setCodigoPostal(rs.getInt("CodigoPostal"));

            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return this.proveedor;
        }
        return this.proveedor;
    }

    ///////////////actualizar Proveedor//////////
    public int updateProveedorDataBase() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call Proveedor_Actualizar_SP(?,?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("input_Id_Proveedor", this.proveedor.getIdProveedor());////////////
            cstmt.setString("Input_Nombre", this.proveedor.getNombre());
            cstmt.setString("Input_Calle", this.proveedor.getCalle());
            cstmt.setString("Input_Colonia", this.proveedor.getColonia());
            cstmt.setString("Input_Ciudad", this.proveedor.getCiudad());
            cstmt.setInt("Input_CodigoPostal", this.proveedor.getCodigoPostal());

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
        return 1;
    }

    public int delete_Proveedor() {

        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call Proveedor_Eliminar_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Proveedor", this.proveedor.getIdProveedor());////////////

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

    public List<Proveedor> queryAllProveedorToDatabase(String Matricula) {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;

        List<Proveedor> listaProveedor = new ArrayList<Proveedor>();
        try {
            cstmt = this.dbCon.prepareCall("{call Proveedor_ConsultarTodo_SP()}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //   cstmt.setString("In_Matricula", this.alumno.getMatricula());
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
                this.proveedor = new Proveedor();
                this.proveedor.setIdProveedor(rs.getString("ID_Proveedor"));
                this.proveedor.setNombre(rs.getString("Nombre"));
                this.proveedor.setCalle(rs.getString("Calle"));
                this.proveedor.setColonia(rs.getString("Colonia"));
                this.proveedor.setCiudad(rs.getString("Ciudad"));
                this.proveedor.setCodigoPostal(rs.getInt("CodigoPostal"));

                listaProveedor.add(proveedor);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return null;
        }
        return listaProveedor;
    }

}
