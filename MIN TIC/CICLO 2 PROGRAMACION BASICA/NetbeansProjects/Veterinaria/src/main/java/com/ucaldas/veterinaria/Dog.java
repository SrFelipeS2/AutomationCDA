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
public class Dog extends Pet {
    
    private String breed;
    private boolean pedigree;
    
    
    public void WalkAround(){
        
    }
    
    @Override
    public String Sound(){
        return "Woof Woof";
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isPedigree() {
        return pedigree;
    }

    public void setPedigree(boolean pedigree) {
        this.pedigree = pedigree;
    }
    
}
