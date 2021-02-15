/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unpa.winforms.ferreteria.el;

import java.sql.Connection;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;
import unpa.winforms.ferreteria.bll.BLL_ProveedorTelefono;
import unpa.winforms.ferreteria.testUniversity;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class ModeloTablaProveedor extends AbstractTableModel {
    testUniversity u = new testUniversity();
    private String[] columnNames = {"Tipo_Telefono", "Lada", "Extension", "Numero"};
    private LinkedList<ProveedorTelefono> listaTelefonoProveedor = new LinkedList();
    private String idProveedor;
    private Connection dbCon;
    
    public ModeloTablaProveedor(Connection _dbCon, String _idProveedor) {  // se envia el id del proveedor par aobtener sus telefonos
        ProveedorTelefono proveedorTelefono = new ProveedorTelefono();
        
        this.dbCon = _dbCon;
        this.idProveedor = _idProveedor;        
        this.obtenerTodosLosAlumnos();
    }    
  
    public int getColumnCount() {//los nombres de la columna
        return columnNames.length;
    }

    public int getRowCount() {//
        return listaTelefonoProveedor.size();
    }

    public String getColumnName(int col){//nombre de la columna
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {//obtener el valor en la , 
        ProveedorTelefono proveedorTelefono = listaTelefonoProveedor.get(row);
        switch (col) {
            case 0:
                return proveedorTelefono.getDescripcionTelefono();
            case 1:
                return proveedorTelefono.getLada();
            case 2:
                return proveedorTelefono.getExtension();
            case 3:
                return proveedorTelefono.getNumero();

            default:
                return "Error";
        }
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {//la celda que si es deitable y no editable &&si todas va ser editables va ser toda true
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col){//si puede camviar implementar
        // data[row][col] = value;
        ProveedorTelefono proveedorTelefono= listaTelefonoProveedor.get(row);
        switch (col) {
            case 2:
                proveedorTelefono.setNumero((String) value);
            case 3:
               proveedorTelefono.setLada((String) value);

        }
        fireTableCellUpdated(row, col);

    }

    public void agregarProveedor(ProveedorTelefono proveedorTelefono) {
        listaTelefonoProveedor.add(proveedorTelefono);
        this.fireTableRowsInserted(0, listaTelefonoProveedor.size());
    }

    public void eliminarProveedor(int fila) {
        if (fila >= 0 && fila < listaTelefonoProveedor.size()) {
            listaTelefonoProveedor.remove(fila);
        }

        this.fireTableRowsDeleted(0, listaTelefonoProveedor.size());
    }

    public ProveedorTelefono obtenerProveedor(int fila) {
        if (fila >= 0 && fila < listaTelefonoProveedor.size()) {
            return listaTelefonoProveedor.get(fila);
        }
        return null;
    }

//    public void obtenerProfesores(String cCarrera){
//        Profesor p = new Profesor();
//        this.datos = p.obtenerProfesoresPorCarrera(cCarrera);
//    }
    
    public void obtenerTodosLosAlumnos(){
        try{
            BLL_ProveedorTelefono bbl_ProveedorTelefono = new BLL_ProveedorTelefono();        
            this.listaTelefonoProveedor.addAll(bbl_ProveedorTelefono.QueryProveedorTelefonoDataBase(dbCon,idProveedor));
        }
        catch(Exception e){     
        } 
   }  
    
}
