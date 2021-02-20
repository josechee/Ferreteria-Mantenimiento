/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unpa.winforms.ferreteria;

import unpa.winforms.ferreteria.el.Proveedor;
import unpa.winforms.ferreteria.el.ProveedorTelefono;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import unpa.winforms.ferreteria.el.Alumno;
import unpa.winforms.ferreteria.dal.DAL_ProveedorTelefono;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class UNPAWinformsFerreteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        testUniversity u = new testUniversity();//para hacer uso de sus metodos como add, query, update,  delete
        List<Proveedor> listaProveedor = new ArrayList<Proveedor>();
        List<ProveedorTelefono> listaProveedorTelefono = new ArrayList<ProveedorTelefono>();
        String idproveedor;
        Proveedor proveedor = new Proveedor();//creando un objeto proveedor para insertar a la base de datos

        ProveedorTelefono Telefono1 = new ProveedorTelefono();
        String idProveedor;

        proveedor.setNombre("FERRE DEBIAN");
        /**
         * *Tabla direccion*
         */
        proveedor.setCalle("App");
        proveedor.setColonia("Contenedor");
        proveedor.setCiudad("Docker");
        proveedor.setCodigoPostal(68400);
        //todo esto para insertar un nuevo proveedor y eliminar ello
        idProveedor = u.ProveedorAdd(proveedor);//toma el idProveedor que se inserto para poder insertar su telefono con su id
        //  u.ProveedorAdd(proveedor);
        //  proveedor.setIdProveedor(idProveedor);

        //u.PoveedorDelete(proveedor); /*Eliminar el proveedor*/
        // System.out.println(u.ProveedorAdd(proveedor));
        System.out.println("idProveedor: " + idProveedor);
        // Telefono1.setIdProveedor(u.ProveedorAdd(proveedor)); 

//     /*INSERTAR EL PRIMER TELEFONO DEL PROVEEDOR*/
        Telefono1.setIdProveedor(idProveedor);
        Telefono1.setTipoTelefono(proveedor.getTelefonoPersonal());
        Telefono1.setLada("01");
        Telefono1.setExtension(0);
        Telefono1.setNumero("1112967402");
        System.out.println(u.ProveedorTelefonoAdd(Telefono1));

//        /*INSERTAR EL SEGUNDO TELEFONO DEL PROVEEDOR*/
        Telefono1.setIdProveedor(idProveedor);
        Telefono1.setTipoTelefono(proveedor.getTelefonoCasa());
        Telefono1.setLada("02");
        Telefono1.setExtension(0);
        Telefono1.setNumero("2222967431");
        System.out.println(u.ProveedorTelefonoAdd(Telefono1));

//        /*INSERTAR EL TERCER TELEFONO DEL PROVEEDOR*/
        /*Telefono1.setIdProveedor(idProveedor);
        Telefono1.setTipoTelefono(proveedor.getTelefonoOficina());
        Telefono1.setLada("045");
        Telefono1.setExtension(3);
        Telefono1.setNumero("54296989");
        System.out.println(u.ProveedorTelefonoAdd(Telefono1));
         */
//       
//       
        // u.PoveedorTelefonoDelete(Telefono1);/*Primero se elimina telefonoProveedor [por su idProveedor]*/
        // u.PoveedorDelete(proveedor);/*Posteriormente se elimina el proveedor [con su idProveedor]*/
//    
        listaProveedor = u.ProveedorAllQry();
//        System.out.print("Proveedor|  ");
//        System.out.print("Ciudad|  ");
//        System.out.print("Codigo_Postal| ");
//        System.out.print("Telefono_Personal|  ");
//        System.out.print("Telefono_Casa|  ");
//        System.out.print("Telefono_Oficina|  ");
//        System.out.println();
        /*
        listaProveedor.addAll(u.ProveedorAllQry());
        //listaProveedorTelefono.addAll(u.ProveedorTelefonoAllQry());
        for (int j=0;j<listaProveedor.size();j++) {
            if(listaProveedor.get(j).getNombre().equals("CAT")){
                System.out.print(listaProveedor.get(j).getNombre()+"      ");
                System.out.print(listaProveedor.get(j).getCiudad()+"       ");
                System.out.print(listaProveedor.get(j).getCodigoPostal()+"        ");
            for (int i = 0; i < listaProveedorTelefono.size(); i++) {
                if (listaProveedorTelefono.get(i).getIdProveedor().equals(listaProveedor.get(j).getIdProveedor())) {
               //     System.out.print(listaProveedorTelefono.get(i).getNumero()+"          "); 
                }
            }
            }

        }*/
    }

}
