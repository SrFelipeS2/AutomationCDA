/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucaladas.tiendaonline;

/**
 *
 * @author ANDRES
 */
public class envio {
    private String id;
    private String direccionFacturacion;
    private String estado;
    private String fechaEnvio;
    private String compania;
    private String direccionEnvio;
    private String estadoEnvio;

    public envio() {
    }

    public envio(String id, String direccionFacturacion, String estado, String fechaEnvio, String compania, String direccionEnvio, String estadoEnvio) {
        this.id = id;
        this.direccionFacturacion = direccionFacturacion;
        this.estado = estado;
        this.fechaEnvio = fechaEnvio;
        this.compania = compania;
        this.direccionEnvio = direccionEnvio;
        this.estadoEnvio = estadoEnvio;
        
        }
        public void enviarPedido(){
            System.out.println("usted debe realizar el pago");
        }
}