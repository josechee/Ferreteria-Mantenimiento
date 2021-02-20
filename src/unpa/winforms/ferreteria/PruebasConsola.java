/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unpa.winforms.ferreteria;

import unpa.winforms.ferreteria.el.Proveedor;
import unpa.winforms.ferreteria.el.ProveedorTelefono;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import unpa.winforms.ferreteria.bll.BLL_ProveedorTelefono;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class PruebasConsola {

    public static void main(String[] args) throws Exception {
        //  testUniversity u = new testUniversity();
        List<Proveedor> listaProveedor = new ArrayList<Proveedor>();
        List<ProveedorTelefono> listaProveedorTelefono = new ArrayList<ProveedorTelefono>();
        String idproveedor;
        Proveedor proveedor = new Proveedor();

        //   BLL_ProveedorTelefono bll_proveedorTelefono=new BLL_ProveedorTelefono();
//        //ProveedorTelefono Telefono1 = new ProveedorTelefono();
//        String idProveedor="311c89e9-70c7-11e8-9efa-28d244202eee";
//       proveedor.setIdProveedor(idProveedor);
//        proveedor.setNombre("FERRE_CHEE2 ");
//         proveedor.setCalle("Guadalupe Victoria");
//        proveedor.setColonia("San Antonio");
//        proveedor.setCiudad("Loma");
//        proveedor.setCodigoPostal(68400);
//        
        //u.deleteProveedorTelefono(proveedor);
        // System.out.println(u.deleteProveedor(proveedor));
        // u.ProveedorAdd(proveedor);
        //  u.unpdateProveedor(proveedor); 
        //     proveedor.setIdProveedor(idProveedor);
        // proveedor=u.ProveedorQry(proveedor);
        //   listaProveedorTelefono=u.ProveedorTelefonoQry(idProveedor);
//        
//        System.out.println(proveedor.getIdProveedor());
//        System.out.println(proveedor.getNombre());
//        System.out.println(proveedor.getCalle());
//        
        //   proveedor =u.ProveedorQry(idProveedor);
        // System.out.println(proveedor.getNombre());
//       String fechaNacimiento="8/5/1997";
//       String fNacimiento[]=fechaNacimiento.split("/");
//        System.out.println(fNacimiento[2]);
        Calendar fecha = new GregorianCalendar();
        //Obtenemos el valor del año, mes, día, hora, minuto y segundo del sistema.
        //Usando el método get y el parámetro correspondiente.
        int ano = fecha.get(Calendar.YEAR);
        int mes = Calendar.MONTH;

        int dia = fecha.get(Calendar.DAY_OF_MONTH);
//        int hora = fecha.get(Calendar.HOUR_OF_DAY);
//        int minuto = fecha.get(Calendar.MINUTE);
//        int segundo = fecha.get(Calendar.SECOND);
        //System.out.println("Fecha Actual: "+dia+ "/" +(mes+1)+ "/" +ano);
        //System.out.printf("Hora Actual: %02d:%02d:%02d %n", hora, minuto, segundo);
        //    label_fechasistema.setText(""+dia+"/"+mes+1+"/"+ano+"    "+hora+":"+minuto+":"+segundo);
        System.out.println("" + dia + "/" + mes + "/" + ano);
        //System.out.println(fecha.getTime());
//        System.out.println(fecha.getTime().toString());
        String s;
        s = fecha.getTime().toString();
        System.out.println(s);
    }
}
