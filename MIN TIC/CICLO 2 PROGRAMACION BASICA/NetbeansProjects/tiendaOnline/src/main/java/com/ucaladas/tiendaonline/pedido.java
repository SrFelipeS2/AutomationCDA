/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucaladas.tiendaonline;

/**
 *
 * @author ANDRES
 */
public class pedido {
    private String id;
    private String fechaRealizacion;
    private String estado;
    private String total;
    
    
    public pedido(){

    }
    public pedido(String id, String fechaRealizacion, String estado, String total) {
            this.id = id;
            this.fechaRealizacion = fechaRealizacion;
            this.estado = estado;
            this.total = total;

    }
}


    

