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
import unpa.winforms.ferreteria.el.Empleado;
import unpa.winforms.ferreteria.el.EmpleadoTelefono;
import unpa.winforms.ferreteria.el.ProveedorTelefono;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class DAL_EmpleadoTelefono {

    private EmpleadoTelefono empleadoTelefono;
    private Connection dbCon;

    public DAL_EmpleadoTelefono(Connection _dbCon, EmpleadoTelefono _empleadoTelefono) {
        dbCon = _dbCon;
        if (_empleadoTelefono != null) {
            this.empleadoTelefono = _empleadoTelefono;
        } else {
            this.empleadoTelefono = new EmpleadoTelefono();
        }
    }

    public int addEmpleadoTelefonoToDataBase() throws SQLException {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call EmpleadoTelefono_Insertar_SP(?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //cstmt.setString("Out_Matricula", this.alumno.getMatricula());

            cstmt.setString("Input_ID_Empleado", this.empleadoTelefono.getIdEmpleado());
            cstmt.setInt("Input_ID_TipoTelefono", this.empleadoTelefono.getTipoTelefono());
            cstmt.setString("Input_Lada", this.empleadoTelefono.getLada());
            cstmt.setInt("Input_Extension", this.empleadoTelefono.getExtension());
            cstmt.setString("Input_Numero", this.empleadoTelefono.getNumero());

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
                verificador = rs.getInt(1);//aqui se captura el ide del proveedor
            }

        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return 0;
        }
        return verificador;//retorna el id del Proveedor

    }
    
    
      public List<EmpleadoTelefono> queryProveedorTelefonosToDatabase(String IdEmpleado) {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        
        List <EmpleadoTelefono> listaEmpleadoTelefono = new ArrayList<EmpleadoTelefono>();        
        try {
            cstmt = this.dbCon.prepareCall("{call consultarEmpleadoTelefono(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Empleado", IdEmpleado);
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
                this.empleadoTelefono = new EmpleadoTelefono();
                this.empleadoTelefono.setIdEmpleadTelefono(rs.getString("ID_EmpleadoTelefono"));
                this.empleadoTelefono.setIdEmpleado(rs.getString("ID_Empleado"));
                this.empleadoTelefono.setDescripcionTelefono(rs.getString("Descripcion"));
                this.empleadoTelefono.setLada(rs.getString("Lada"));
                this.empleadoTelefono.setExtension(rs.getInt("Extension"));
                this.empleadoTelefono.setNumero(rs.getString("Numero"));
                
                listaEmpleadoTelefono.add(empleadoTelefono);
                
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return null;
        }
        return listaEmpleadoTelefono;
    }
      
      
       public int updateEmpleadoTelefonoToDataBase() throws SQLException {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call EmpleadoTelefono_Actualizar_SP(?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("Input_ID_Empleado_Telefono", this.empleadoTelefono.getIdEmpleadTelefono());
            cstmt.setString("Input_Lada", this.empleadoTelefono.getLada());
            cstmt.setInt("Input_Extension", this.empleadoTelefono.getExtension());
            cstmt.setString("Input_Numero", this.empleadoTelefono.getNumero());
            
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
                verificador = rs.getInt("1");//aqui se captura el ide del proveedor
            }

        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return 0;
        }
        return verificador;//retorna el id del Proveedor
    }     
       
       
        public int delete_EmpleadoTelefono(Empleado empleado) {

        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call Empleado_Telefono_Eliminar_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Empleado", empleado.getId_Empleado());////////////
            

            boolean results = cstmt.execute();
            int rowsAffected     = 0;
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
