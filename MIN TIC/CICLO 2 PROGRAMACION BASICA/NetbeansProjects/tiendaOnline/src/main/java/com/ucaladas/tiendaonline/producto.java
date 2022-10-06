/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucaladas.tiendaonline;

/**
 *
 * @author ANDRES
 */
public class producto {
    private String id;
    private String denominacion;
    private String proveedor;
    
    public producto(){
    
    }
    
    public producto(String id, String denominacion, String proveedor){
        this.id = id;
        this.denominacion = denominacion;
        this.proveedor = proveedor;
    }
    
}
