/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unpa.winforms.ferreteria.bll;

import java.sql.Connection;
import unpa.winforms.ferreteria.dal.DAL_Usuario;
import unpa.winforms.ferreteria.el.Usuario;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class BLL_Usuario {
    
    
    public String AddToDataBaseUsuario(Connection dbCon, Usuario usuario) throws Exception {
        try {
            DAL_Usuario dal_usuario = new DAL_Usuario(dbCon, usuario);
            return dal_usuario.addProveedorToDataBase();
        } catch (Exception ex) {
            throw ex;
        }
    } 
    
     public Usuario QueryUsuarioDataBase(Connection dbCon, String  idUsuario) throws Exception {
        try {
            DAL_Usuario dal_usuario = new DAL_Usuario(dbCon, null);
            return dal_usuario.queryUsuarioToDatabase(idUsuario);
        } catch (Exception ex) {
            throw ex;
        }
    }
     
     public int updateEmpleadoDataBase(Connection dbCon, Usuario usuario) throws Exception {
        try {
            DAL_Usuario dal_usuario = new DAL_Usuario(dbCon, usuario);
            return dal_usuario.updateUsuarioDataBase();
        } catch (Exception ex) {
            throw ex;
        }
    }
     
     
     public int deleteUsuarioDatabase(Connection dbCon, Usuario usuario) throws Exception {
        try {
            DAL_Usuario dal_usuario = new DAL_Usuario(dbCon, usuario);
            return dal_usuario.delete_Usuario();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
