/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucaldas.veterinaria;

/**
 *
 * @author zambr
 */
public class Pet {
    
    //Atributos
    private int code;
    private String name;
    private int bornYear;
    private String color;
    private String healthStatus;
    
    public Pet(){
        this.name = "";
        this.color = "";
        this.bornYear = 0;
        this.code = 0;
        this.healthStatus = "";
    }
    
    public Pet(String nombre, String color, int code, int bornYear, String healthStatus){
        this.name = nombre;
        this.color = color;
        this.code = code;
        this.bornYear = bornYear;
        this.healthStatus = healthStatus;
    }
    
    public Pet(String name, String healthStatus){
        this.name = name;
        this.healthStatus = healthStatus;
    }
    
    public void Eat(){
        
    }
    
    public void Move(){
        
    }
    
    public String Sound(){
        return "Generico";
    }
      
    public String getFullPet(){
        return "Su mascota se llama: " + this.getName() 
                + ", el año de nacimiento es: " + this.getBornYear() 
                + ", el color es: " + this.getColor();
    }
    
    public String getFullPet(String name){
        return "Su mascota es: " + name;
    }
    
    public int getFullPet(int bornYear){
        return bornYear + 1;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBornYear() {
        return bornYear;
    }

    public void setBornYear(int bornYear) {
        this.bornYear = bornYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }
              
}
