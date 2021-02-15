/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unpa.winforms.ferreteria.el;

import java.util.LinkedList;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class Producto {
    private String idProducto;
    private String idProvedor;
    private int idTipoProdcuto;
    private String nombre;
    private float existencia;
    private float precio;
    private String marca;
    private int Descuento;
    private LinkedList<Producto> listaProductos=new LinkedList<Producto>();
    public Producto() {
        
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getIdProvedor() {
        return idProvedor;
    }

    public void setIdProvedor(String idProvedor) {
        this.idProvedor = idProvedor;
    }

    public int getIdTipoProdcuto() {
        return idTipoProdcuto;
    }

    public void setIdTipoProdcuto(int idTipoProdcuto) {
        this.idTipoProdcuto = idTipoProdcuto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getExistencia() {
        return existencia;
    }

    public void setExistencia(float existencia) {
        this.existencia = existencia;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int Descuento) {
        this.Descuento = Descuento;
    }

    public LinkedList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(LinkedList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    
    
    
        
    
}
