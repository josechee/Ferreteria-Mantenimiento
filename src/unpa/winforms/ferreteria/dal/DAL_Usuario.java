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
import unpa.winforms.ferreteria.el.Proveedor;
import unpa.winforms.ferreteria.el.Usuario;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class DAL_Usuario {
    private Usuario usuario;
    private Connection dbCon;    
        
    public DAL_Usuario(Connection _dbCon, Usuario _usuario) {
        dbCon = _dbCon;
        if (_usuario != null) {
            this.usuario = _usuario;
        } else {
            this.usuario = new Usuario();
        }
    }
    
    //INSERTAR USUARIO
     public String addProveedorToDataBase() throws SQLException {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        String verificador = null;
        try {
            cstmt = this.dbCon.prepareCall("{call tbl_Usuario_Insertar_SP(?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //cstmt.setString("Out_Matricula", this.alumno.getMatricula());
            
            cstmt.setString("Input_Usuario",this.usuario.getCuentaUsuario());
            cstmt.setString("Input_Contrasenia", this.usuario.getContraseña());
            //cstmt.setString("Out_ID_Usuario", this.proveedor.getColonia());
      

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
                verificador = rs.getString("idUsuario");//aqui se captura el ide del proveedor
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return null;
        }
        return verificador;//retorna el id del Proveedor
    }   

     public Usuario queryUsuarioToDatabase(String idUsuario) {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call Usuario_Consultar_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Usuario", idUsuario);
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
                this.usuario = new Usuario();
                this.usuario.setIdUsuario(rs.getString("ID_Usuario"));
                this.usuario.setCuentaUsuario(rs.getString("Usuario"));
                this.usuario.setContraseña(rs.getString("Contrasenia"));
               
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return this.usuario;
        }
        return this.usuario;
    }
    
     
       public int updateUsuarioDataBase() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call Usuario_Actualizar_SP(?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("Input_ID_Usuario", this.usuario.getIdUsuario());////////////
            cstmt.setString("Input_Usuario", this.usuario.getCuentaUsuario());
            cstmt.setString("Input_Contrasenia", this.usuario.getContraseña());
  

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
    
       
       public int delete_Usuario() {

        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call Usuario_Eliminar_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("ID_Usuario", this.usuario.getIdUsuario());////////////
            

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
