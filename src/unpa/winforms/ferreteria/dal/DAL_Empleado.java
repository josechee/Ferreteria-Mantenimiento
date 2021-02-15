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
import unpa.winforms.ferreteria.el.Empleado;
import unpa.winforms.ferreteria.el.Proveedor;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class DAL_Empleado {
   
    private Empleado empleado;
    private Connection dbCon;    
        
    public DAL_Empleado(Connection _dbCon, Empleado _empleado) {
        dbCon = _dbCon;
        if (_empleado != null) {
            this.empleado = _empleado;
        } else {
            this.empleado = new Empleado();
        }
    }
    
    
     public String addProveedorToDataBase() throws SQLException {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        String verificador = null;
        try {
            cstmt = this.dbCon.prepareCall("{call Empleado_Insertar_SP(?,?,?,?,?,?,?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //cstmt.setString("Out_Matricula", this.alumno.getMatricula());
            
            cstmt.setString("Input_ID_Usuario", this.empleado.getId_Usuario());
            cstmt.setInt("Input_ID_TipoEmpleado", this.empleado.getId_TipoEmpleado());
            cstmt.setString("Input_Nombre", this.empleado.getNombre());
            cstmt.setString("Input_ApPaterno", this.empleado.getApPaterno());
            cstmt.setString("Input_ApMaterno", this.empleado.getApMaterno());
            cstmt.setString("FechaNacimiento", this.empleado.getFechaNacimiento());
            cstmt.setString("Input_Calle", this.empleado.getCalle());
            cstmt.setString("Input_Colonia", this.empleado.getColonia());
            cstmt.setString("Input_Ciudad", this.empleado.getCiudad());
            cstmt.setInt("Input_CodigoPostal", this.empleado.getCodigoPostal());
          

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
               verificador = rs.getString("idEmpleado");//aqui se captura el ide del proveedor
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return null;
        }
        return verificador;//retorna el id del Proveedor
    }
     
     //CONSULTAR EMPLEADO HACIENDO MATCH CON LOS PRIMEROS 5 CARACTERES DE SU ID
       public Empleado queryEmpleadoToDatabase(String idEmpleado) {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call Empleado_Consultar_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Empleado", idEmpleado);
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
                this.empleado = new Empleado();
                this.empleado.setId_Empleado(rs.getString("ID_Empleado"));
                this.empleado.setId_Usuario(rs.getString("ID_Usuario"));
                this.empleado.setId_TipoEmpleado(rs.getInt("ID_TipoEmpleado"));
                this.empleado.setNombre(rs.getString("Nombre"));
                this.empleado.setApPaterno(rs.getString("ApPaterno"));
                this.empleado.setApMaterno(rs.getString("ApMaterno"));
                this.empleado.setFechaNacimiento(rs.getString("FechaNacimiento"));
                this.empleado.setCalle(rs.getString("Calle"));
                this.empleado.setColonia("Colonia");
                this.empleado.setCiudad(rs.getString("Ciudad"));
                this.empleado.setCodigoPostal(rs.getInt("CodigoPostal"));
                
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return this.empleado;
        }
        return this.empleado;
    }
    
    // actualizar EMPLEADO
     public int updateEmpleadoDataBase() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call Empleado_Actualizar_SP(?,?,?,?,?,?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("Input_ID_Empleado", this.empleado.getId_Empleado());////////////
            cstmt.setInt("Input_ID_TipoEmpleado", this.empleado.getId_TipoEmpleado());
            cstmt.setString("Input_Nombre", this.empleado.getNombre());
            cstmt.setString("Input_ApPaterno", this.empleado.getApPaterno());
            cstmt.setString("Input_ApMaterno", this.empleado.getApMaterno());
            cstmt.setString("FechaNacimiento", this.empleado.getFechaNacimiento());
            cstmt.setString("Input_Calle", this.empleado.getCalle());
            cstmt.setString("Input_Colonia", this.empleado.getColonia());
            cstmt.setString("Input_Ciudad", this.empleado.getCiudad());
            cstmt.setInt("Input_CodigoPostal", this.empleado.getCodigoPostal());

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
    
    public int delete_Empleado() {

        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call Empleado_Eliminar_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Empleado", this.empleado.getId_Empleado());////////////
            

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
}
