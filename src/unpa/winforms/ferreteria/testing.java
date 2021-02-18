/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unpa.winforms.ferreteria;

import java.sql.Connection;
import unpa.winforms.ferreteria.el.Proveedor;
import unpa.winforms.ferreteria.el.ProveedorTelefono;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import unpa.winforms.ferreteria.bll.BLL_ProveedorTelefono;
import unpa.winforms.ferreteria.el.Alumno;
import unpa.winforms.ferreteria.dal.DAL_ProveedorTelefono;
import unpa.winforms.ferreteria.util.DbUtil;
/**
 *
 * @author $chee.Joseph_unp@gmail.com
 */
public class testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
         testUniversity u = new testUniversity();//para hacer uso de sus metodos como add, query, update,  delete
        List<Proveedor> listaProveedor = new ArrayList<Proveedor>();
        List<ProveedorTelefono> listaProveedorTelefono = new ArrayList<ProveedorTelefono>();
        String idproveedor;
        Proveedor proveedor = new Proveedor();//creando un objeto proveedor para insertar a la base de datos

        ProveedorTelefono Telefono1 = new ProveedorTelefono();
        String idProveedor;
        
        /*   //obtener todos los proveedores
        listaProveedor=u.ProveedorAllQry();
        System.out.println("size de la lista: "+listaProveedor.size());
        System.out.println("Proveedor|  "+listaProveedor.get(0).getNombre());
        System.out.println("Ciudad|  "+listaProveedor.get(0).getCiudad());
        System.out.println("Codigo_Postal| "+listaProveedor.get(0).getCodigoPostal());
        System.out.println("Telefono_Personal|  "+listaProveedor.get(0).getTelefonoPersonal());
        System.out.println("Telefono_Casa|  "+listaProveedor.get(0).getTelefonoCasa());
        System.out.println("Telefono_Oficina|  "+listaProveedor.get(0).getTelefonoOficina());
        System.out.println();*/
        
        Telefono1.setIdProveedor("7973f5f9-7007-11eb-b5d2-28d244202eee");
        Telefono1.setIdProveedorTelefono("c86dc03d-7008-11eb-b5d2-28d244202eee");
        Telefono1.setTipoTelefono(1);
        Telefono1.setLada("59");
        Telefono1.setExtension(123);
        Telefono1.setNumero("9832341234");
        
        
       
        
        testUniversity tester=new testUniversity();
        
        /*BLL_ProveedorTelefono bll_ProveedorTelefono= new BLL_ProveedorTelefono();
        int retorno=0;
        //retorno=bll_ProveedorTelefono.updateProveedorTelefonoDatabase(dbCon,Telefono1);
        retorno=tester.unpdateTelefonoProveedor(Telefono1);
        System.out.println(retorno);
        */
     //   proveedor.setIdProveedor("7973f5f9");
       // proveedor = tester.ProveedorQry(proveedor);//query solo con los primeros 8 numeros del idProveedor; mandando al objeto Proveedor
        //proveedor = tester.ProveedorQry("7973f5f9");//query pasando el idProveedor peroe ste debe ser de longitud 8 (los primeros 8 digitos del idProveedor)
        
        proveedor=tester.ProveedorQryPorNombre("FERRE_CHEE1");//CHECAR ESTA PARTE 
        
        if(proveedor.getIdProveedor()!=null){            
            System.out.print("Nombre del proveedor: ");
            System.out.println(proveedor.getNombre());
        }else{
            System.out.println("No existe el usuario con ese nombre");
        }
        
        
        
    }
    
}
