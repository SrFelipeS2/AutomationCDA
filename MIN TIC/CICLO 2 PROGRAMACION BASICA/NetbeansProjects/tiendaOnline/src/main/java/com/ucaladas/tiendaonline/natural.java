/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucaladas.tiendaonline;

/**
 *
 * @author ANDRES
 */
public class natural {
    private String id;
    private String documentoIdentidad;
    private String nombres;
    private String apellidos;

    public natural(){
    }
    
    public natural(String id, String documentoIdentidad, String nombres, String apellidos){
        this.id = id;
        this.documentoIdentidad = documentoIdentidad;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
}
