/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucaladas.tiendaonline;

/**
 *
 * @author ANDRES
 */
public class lineaProducto {
    private String id;
    private int cantidad;
    private int precio;
    
    public lineaProducto(){
    
    }
    
    public lineaProducto(String id, int cantidad, int precio){
       this.id = id;
       this.cantidad = cantidad;
       this.precio = precio;
    }
}
