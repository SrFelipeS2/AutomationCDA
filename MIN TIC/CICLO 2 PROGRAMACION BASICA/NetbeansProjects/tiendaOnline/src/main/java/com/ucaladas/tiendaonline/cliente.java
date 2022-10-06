/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucaladas.tiendaonline;

/**
 *
 * @author ANDRES
 */
public class cliente {
     private String id;
     private String direccion;
     private String telefono;
     private String email;
     

     public cliente (){
         
     }
     
     public cliente(String id,String direccion,String telefono,String email){
         this.id = id;
         this.direccion = direccion;
         this.telefono = telefono;
         this.email = email;
     }
     
     public void realizarPedido(){
         System.out.println("en esta funcion se realizaran los pedidos");
     }
}
