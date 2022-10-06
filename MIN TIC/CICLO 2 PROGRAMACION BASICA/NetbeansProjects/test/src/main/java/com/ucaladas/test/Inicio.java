 package com.ucaladas.test;
 
 import java.util.Scanner;

/**
 *
 * @author ANDRES
 */
public class Inicio{

   //static String nombre = "Andres";
   int edad = 30;
   boolean registrado = true;
   String[] argumentos;
   public static void main(String[] args){
   
       Scanner entrada = new Scanner(System.in);
       System.out.println("digite su nombre");
       String nombre  = entrada.nextLine();
       
       System.out.println("helo"+ nombre + "World");
        
   }
   
}