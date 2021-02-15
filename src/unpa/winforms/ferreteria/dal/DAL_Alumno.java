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
import java.util.LinkedList;
import java.util.List;
import unpa.winforms.ferreteria.el.Alumno;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class DAL_Alumno {

    private Alumno alumno;
    private Connection dbCon;    

    public DAL_Alumno(Connection _dbCon, Alumno _alumno) {
        dbCon = _dbCon;
        if (_alumno != null) {
            this.alumno = _alumno;
        } else {
            this.alumno = new Alumno();
        }
    }

    public List<Alumno> queryToDatabase(String Matricula) {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        
        List <Alumno> listaAlumno = new ArrayList<Alumno>();        
        try {
            cstmt = this.dbCon.prepareCall("{call Alumno_ConsultarTodo_SP()}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
                this.alumno = new Alumno();
                this.alumno.setMatricula(rs.getString("Matricula"));
                this.alumno.setNombre(rs.getString("Nombre"));
                this.alumno.setAp_Paterno(rs.getString("Ap_Paterno"));
                this.alumno.setAp_Materno(rs.getString("Ap_Materno"));
                this.alumno.setDireccion(rs.getString("Direccion"));
                this.alumno.setTelefono(rs.getString("Direccion"));
                this.alumno.setActivo(rs.getInt("Activo"));
                listaAlumno.add(alumno);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return null;
        }
        return listaAlumno;
    }

    public Alumno queryToDatabase() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call Alumno_Consultar_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_Matricula", this.alumno.getMatricula());
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
                this.alumno = new Alumno();
                this.alumno.setMatricula(rs.getString("Matricula"));
                this.alumno.setNombre(rs.getString("Nombre"));
                this.alumno.setAp_Paterno(rs.getString("ApPaterno"));
                this.alumno.setAp_Materno(rs.getString("ApMaterno"));
                this.alumno.setDireccion(rs.getString("Direccion"));
                this.alumno.setTelefono(rs.getString("Telefono"));
                this.alumno.setActivo(rs.getInt("Activo"));
                // verificador = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return this.alumno;
        }
        return this.alumno;
    }

    public String addToDataBase() throws SQLException {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        String verificador = null;
        try {
            cstmt = this.dbCon.prepareCall("{call Alumno_Insertar_SP(?,?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //cstmt.setString("Out_Matricula", this.alumno.getMatricula());
            cstmt.setString("Input_Nombre", this.alumno.getNombre());
            cstmt.setString("Input_ApPaterno", this.alumno.getAp_Paterno());
            cstmt.setString("Input_ApMaterno", this.alumno.getAp_Materno());
            cstmt.setString("Input_Direccion", this.alumno.getDireccion());
            cstmt.setString("Input_Telefono", this.alumno.getTelefono());
            cstmt.setInt("Input_Activo", this.alumno.getActivo());

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
                //verificador = rs.getInt(1);
                verificador = rs.getString("matricula");
            }

        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return null;
        }
        return verificador;
    }

    public int uPdataBase() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call Alumno_Actualizar_SP(?,?,?,?,?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_Matricula", this.alumno.getMatricula());////////////
            cstmt.setString("In_Nombre", this.alumno.getNombre());
            cstmt.setString("In_ApPaterno", this.alumno.getAp_Paterno());
            cstmt.setString("In_ApMaterno", this.alumno.getAp_Materno());
            cstmt.setString("In_Direccion", this.alumno.getDireccion());
            cstmt.setString("In_Telefono", this.alumno.getTelefono());
            cstmt.setInt("In_Activo", this.alumno.getActivo());

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

    public int delete_Logic() {

        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call Alumno_Eliminacion_logica_SP(?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_Matricula", this.alumno.getMatricula());////////////
            cstmt.setInt("In_Activo", this.alumno.getActivo());

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

}
