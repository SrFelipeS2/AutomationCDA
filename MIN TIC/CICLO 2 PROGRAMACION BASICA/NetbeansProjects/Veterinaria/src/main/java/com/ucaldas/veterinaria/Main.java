/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucaldas.veterinaria;

import java.util.Scanner;

/**
 *
 * @author zambr
 */

public class Main{

    //Inicio del programa
    public static void main(String[] args){
        
        //Captura de datos
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Digite el nombre de su mascota: ");
        String nombre = entrada.nextLine();
        
        int anioNacimiento = 0;
        boolean validacionAnioNacimiento = false;
        while( validacionAnioNacimiento == false){
            try{
                System.out.println("Digite el año de nacimiento de su mascota: ");
                anioNacimiento = Integer.parseInt(entrada.nextLine());
                validacionAnioNacimiento = true;
            }catch(Exception e){
                System.out.println("Debe digitar solo numeros enteros");
            }
        }
                
        System.out.println("Digite el color de su mascota: ");
        String color = entrada.nextLine();
        
        System.out.println("Digite el estado de salud de su mascota: ");
        String estado = entrada.nextLine();
        
        System.out.println("Digite el codigo interno de su mascota: ");
        int codigo = entrada.nextInt();
        
       
        /*
        mascota1.setName("Pelusa");
        
        System.out.println("El nombre de la mascota 1 es: " + mascota1.getName());
        System.out.println("El nombre de la mascota 2 es: " + mascota2.getName());
        System.out.println("El nombre de la mascota 3 es: " + mascota3.getName());
        System.out.println("El nombre de la mascota 4 es: " + mascota4.getName());
        */
    }
    
}


