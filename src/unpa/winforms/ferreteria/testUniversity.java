/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unpa.winforms.ferreteria;

import unpa.winforms.ferreteria.el.Proveedor;
import unpa.winforms.ferreteria.el.ProveedorTelefono;
import unpa.winforms.ferreteria.el.Alumno;
import unpa.winforms.ferreteria.util.DbUtil;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import unpa.winforms.ferreteria.bll.BLL_Alumno;
import unpa.winforms.ferreteria.bll.BLL_Proveedor;
import unpa.winforms.ferreteria.bll.BLL_ProveedorTelefono;
import unpa.winforms.ferreteria.dal.DAL_Alumno;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class testUniversity {

    private Connection dbCon;
    private DbUtil Conexion;
    private List<Alumno> listaAlumno;
    private List<Proveedor> listaProveedor;
    private List<ProveedorTelefono> listaProveedorTelefono;
    private Proveedor proveedor = new Proveedor();

    
public testUniversity() {
        this.Initialize();

    }

    public void Initialize() {
        dbCon = DbUtil.getInstance().getConnection();

    }
    
    public List<Alumno> AlumnoQry() throws Exception {

        //DAL_Alumno DAL_alumno = new DAL_Alumno(dbCon,_alumno);
        BLL_Alumno bll_alumno = new BLL_Alumno();
        listaAlumno = bll_alumno.QueryDataBase(dbCon, "");
        //System.out.println("Verificador :" + alumno.getMatricula() + "\n");

        // int verificador = DAL_alumno.addToDataBase();       // esto es por la instancia que se
        return listaAlumno;

    }

    public Alumno AlumnoQry(Alumno _alumno) throws Exception {

        //DAL_Alumno DAL_alumno = new DAL_Alumno(dbCon,_alumno);
        BLL_Alumno bll_alumno = new BLL_Alumno();
        _alumno = bll_alumno.QueryDataBase(dbCon, _alumno);
        //System.out.println("Verificador :" + alumno.getMatricula() + "\n");

        // int verificador = DAL_alumno.addToDataBase();       // esto es por la instancia que se
        return _alumno;
    }

    public String AlumnoAdd(Alumno _alumno) throws Exception {
        //DAL_Alumno DAL_alumno = new DAL_Alumno(dbCon,_alumno);
        BLL_Alumno bll_alumno = new BLL_Alumno();
        String verificador = bll_alumno.AddToDataBase(dbCon, _alumno);
        System.out.println("Verificador :" + verificador + "\n");

        // int verificador = DAL_alumno.addToDataBase();       // esto es por la instancia que se
        return verificador;
    }

    public int AlumnoUpd(Alumno _alumno) throws Exception {
        //DAL_Alumno DAL_alumno = new DAL_Alumno(dbCon,_alumno);
        BLL_Alumno bll_alumno = new BLL_Alumno();
        int verificador = bll_alumno.uPdataBase(dbCon, _alumno);
        System.out.println("Verificador :" + verificador + "\n");

        // int verificador = DAL_alumno.addToDataBase();       // esto es por la instancia que se
        return verificador;
    }

    public int AlumnoELogic(Alumno _alumno) throws Exception {
        //DAL_Alumno DAL_alumno = new DAL_Alumno(dbCon,_alumno);
        BLL_Alumno bll_alumno = new BLL_Alumno();
        int verificador = bll_alumno.deletLogicDatabase(dbCon, _alumno);
        System.out.println("Verificador :" + verificador + "\n");

        // int verificador = DAL_alumno.addToDataBase();       // esto es por la instancia que se
        return verificador;
    }

    public void AlumnoLst(String Matricula) throws Exception {
        List<Alumno> alumnoList = new ArrayList<Alumno>();
        BLL_Alumno bll_alumno = new BLL_Alumno();
        alumnoList = bll_alumno.QueryDataBase(dbCon, Matricula);

    }

    /////////////////////proveedor//////////////
    public String ProveedorAdd(Proveedor _proveedor) throws Exception {
        //DAL_Alumno DAL_alumno = new DAL_Alumno(dbCon,_alumno);
        BLL_Proveedor bbl_Proveedor = new BLL_Proveedor();
        String verificador = bbl_Proveedor.AddToDataBaseProveedor(dbCon, _proveedor);
        System.out.println("Verificador :" + verificador + "\n");

        // int verificador = DAL_alumno.addToDataBase();       // esto es por la instancia que se
        return verificador;
    }
    
    public Proveedor ProveedorQryPorNombre(String nombreProveedor) throws Exception {

        //DAL_Alumno DAL_alumno = new DAL_Alumno(dbCon,_alumno);
        BLL_Proveedor bbl_Proveedor = new BLL_Proveedor();
        return bbl_Proveedor.QueryProveedorForNameDataBase(dbCon,nombreProveedor);
        //System.out.println("Verificador :" + alumno.getMatricula() + "\n");

        // int verificador = DAL_alumno.addToDataBase();       // esto es por la instancia que se
        //return _proveedor;
    }

    public Proveedor ProveedorQry(Proveedor _proveedor) throws Exception {

        //DAL_Alumno DAL_alumno = new DAL_Alumno(dbCon,_alumno);
        BLL_Proveedor bbl_Proveedor = new BLL_Proveedor();
        _proveedor = bbl_Proveedor.QueryDataBase(dbCon, _proveedor);
        //System.out.println("Verificador :" + alumno.getMatricula() + "\n");

        // int verificador = DAL_alumno.addToDataBase();       // esto es por la instancia que se
        return _proveedor;
    }

    public Proveedor ProveedorQry(String _idProveedor) throws Exception {

        //DAL_Alumno DAL_alumno = new DAL_Alumno(dbCon,_alumno);
        BLL_Proveedor bbl_Proveedor = new BLL_Proveedor();
        this.proveedor = bbl_Proveedor.QueryProveedorDataBase(dbCon, _idProveedor);
        //System.out.println("Verificador :" + alumno.getMatricula() + "\n");

        // int verificador = DAL_alumno.addToDataBase();       // esto es por la instancia que se
        return proveedor;
    }

    public int ProveedorTelefonoAdd(ProveedorTelefono _proveedorTelefono) throws Exception {
        //DAL_Alumno DAL_alumno = new DAL_Alumno(dbCon,_alumno);
        BLL_ProveedorTelefono bbl_ProveedorTelefono = new BLL_ProveedorTelefono();
        int verificador = bbl_ProveedorTelefono.AddToDataBaseProveedorTelefono(dbCon, _proveedorTelefono);
        System.out.println("Verificador :" + verificador + "\n");

        // int verificador = DAL_alumno.addToDataBase();       // esto es por la instancia que se
        return verificador;
    }

    public int PoveedorDelete(Proveedor _proveedor) throws Exception {
        //DAL_Alumno DAL_alumno = new DAL_Alumno(dbCon,_alumno);
        BLL_Proveedor bbl_Proveedor = new BLL_Proveedor();
        int verificador = bbl_Proveedor.deleteProveedorDatabase(dbCon, _proveedor);
        System.out.println("Proveedor_Eliminar_SP | Verificador :" + verificador + "\n");

        // int verificador = DAL_alumno.addToDataBase();       // esto es por la instancia que se
        return verificador;
    }

    public int PoveedorTelefonoDelete(ProveedorTelefono _proveedorTelefono) throws Exception {
        //DAL_Alumno DAL_alumno = new DAL_Alumno(dbCon,_alumno);
        BLL_ProveedorTelefono bbl_ProveedorTelefono = new BLL_ProveedorTelefono();
        int verificador = bbl_ProveedorTelefono.deletProveedorDatabase(dbCon, _proveedorTelefono);
        System.out.println("Verificador :" + verificador + "\n");

        // int verificador = DAL_alumno.addToDataBase();       // esto es por la instancia que se
        return verificador;
    }

    public List<Proveedor> ProveedorAllQry() throws Exception {

        //DAL_Alumno DAL_alumno = new DAL_Alumno(dbCon,_alumno);
        BLL_Proveedor bbl_Proveedor = new BLL_Proveedor();
        listaProveedor = bbl_Proveedor.QueryAllProveedorDataBase(dbCon, "");
        //System.out.println("Verificador :" + alumno.getMatricula() + "\n");

        // int verificador = DAL_alumno.addToDataBase();       // esto es por la instancia que se
        return listaProveedor;

    }

    public List<ProveedorTelefono> ProveedorTelefonoAllQry() throws Exception {

        //DAL_Alumno DAL_alumno = new DAL_Alumno(dbCon,_alumno);
        BLL_ProveedorTelefono bbl_ProveedorTelefono = new BLL_ProveedorTelefono();
        listaProveedorTelefono = bbl_ProveedorTelefono.QueryProveedorTelefonoAllDataBase(dbCon, null);
        //System.out.println("Verificador :" + alumno.getMatricula() + "\n");

        // int verificador = DAL_alumno.addToDataBase();       // esto es por la instancia que se
        return listaProveedorTelefono;

    }

    public List<ProveedorTelefono> ProveedorTelefonoQry(String idProveedor) throws Exception {

        //DAL_Alumno DAL_alumno = new DAL_Alumno(dbCon,_alumno);
        BLL_ProveedorTelefono bbl_ProveedorTelefono = new BLL_ProveedorTelefono();
        listaProveedorTelefono = bbl_ProveedorTelefono.QueryProveedorTelefonoDataBase(dbCon, idProveedor);
        //System.out.println("Verificador :" + alumno.getMatricula() + "\n");

        // int verificador = DAL_alumno.addToDataBase();       // esto es por la instancia que se
        return listaProveedorTelefono;

    }
    //////////////////////////ACTUALIZAR//////////////////////////
  
    public int unpdateProveedor(Proveedor proveedor) throws Exception{
        BLL_Proveedor bbl_Proveedor = new BLL_Proveedor();
        return  bbl_Proveedor.updateProveedorDataBase(dbCon,proveedor) ;
        
    }
    
    public int unpdateTelefonoProveedor(ProveedorTelefono proveedorTlefono) throws Exception{
        BLL_ProveedorTelefono bbl_ProveedorTelefono = new BLL_ProveedorTelefono();
        return  bbl_ProveedorTelefono.updateProveedorTelefonoDatabase(dbCon,proveedorTlefono) ;
        
    }
    
    
    
    
    
      ////////////////////////eliminar ProveedorTelefono///////////////////////////
    public int deleteProveedorTelefono(Proveedor proveedor) throws Exception{
        BLL_ProveedorTelefono bbl_ProveedorTelefono = new BLL_ProveedorTelefono();
        return  bbl_ProveedorTelefono.deleteProveedorTelefonoDatabase(dbCon,proveedor) ;
        
    }
    
     ////////////////////////eliminar Proveedor///////////////////////////
     public int deleteProveedor(Proveedor proveedor) throws Exception{
        BLL_Proveedor bbl_Proveedor = new BLL_Proveedor();
        return  bbl_Proveedor.deleteProveedorDatabase(dbCon,proveedor) ;
        
    }
    
    
}
