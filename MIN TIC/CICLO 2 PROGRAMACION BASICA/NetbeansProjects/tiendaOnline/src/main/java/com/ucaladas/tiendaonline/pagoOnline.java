/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucaladas.tiendaonline;

/**
 *
 * @author ANDRES
 */
public class pagoOnline {
    private String id;    
    private String idCliente;
    private String idPedido;

    public pagoOnline(){
        
    }
    
    public pagoOnline(String id,String idCliente, String idPedidos){
        this.id = id;
        this.idCliente = idCliente;
        this.idPedido = idPedido;
    }
}
