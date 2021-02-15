/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unpa.winforms.ferreteria.bll;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;
import unpa.winforms.ferreteria.el.Alumno;
import unpa.winforms.ferreteria.el.Proveedor;
import unpa.winforms.ferreteria.dal.DAL_Alumno;
import unpa.winforms.ferreteria.dal.DAL_Proveedor;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class BLL_Alumno {

    public String AddToDataBase(Connection dbCon, Alumno alumno) throws Exception {
        try {
            DAL_Alumno dal_alumno = new DAL_Alumno(dbCon, alumno);
            return dal_alumno.addToDataBase();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<Alumno> QueryDataBase(Connection dbCon,String Matricula) throws Exception {
        try {
            DAL_Alumno dal_alumno = new DAL_Alumno(dbCon, null);
            return dal_alumno.queryToDatabase(null);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public Alumno QueryDataBase(Connection dbCon, Alumno alumno) throws Exception {
        try {
            DAL_Alumno dal_alumno = new DAL_Alumno(dbCon, alumno);
            return dal_alumno.queryToDatabase();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public int uPdataBase(Connection dbCon, Alumno alumno) throws Exception {
        try {
            DAL_Alumno dal_alumno = new DAL_Alumno(dbCon, alumno);
            return dal_alumno.uPdataBase();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public int deletLogicDatabase(Connection dbCon, Alumno alumno) throws Exception {
        try {
            DAL_Alumno dal_alumno = new DAL_Alumno(dbCon, alumno);
            return dal_alumno.delete_Logic();
        } catch (Exception ex) {
            throw ex;
        }
    }
    /////////////////////////DAL_pROVEEDRO////////////////
    


}
