/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Dog;
import Model.modeloPerro;

/**
 *
 * @author zambr
 */
public class ctlPerro {
    
    private modeloPerro modeloPerro;
    
    public ctlPerro(){
        this.modeloPerro = new modeloPerro();
    }
    
    public boolean registrarPerro(Dog objectDog){
        
        //Validar que el objeto de tipo perro es correcto
        
        boolean result = modeloPerro.crear(objectDog);
        
        return result;
        
    }
    
    public boolean eliminarPerro(int codigo){
        
        //Validar si existe el dato
        
        boolean result = modeloPerro.eliminar(codigo);
        
        return result;
    }
    
    public Dog[] buscarGeneral(String buscar, String valor){    
        
        //Validar antes de enviar al modelo
        
        
        if(buscar.equals("nombre")){
            return modeloPerro.obtenerListadoPorNombre(valor);
        }else{
            return modeloPerro.obtenerListadoPorRaza(valor);
        }
        
    }
    
    public Dog buscarPerroCodigo(int codigo){    
        
        //Validar antes de enviar al modelo
        
        Dog perro = modeloPerro.obtenerPerro(codigo);
        
        return perro;
        
    }
    
    public String actualizar(Dog dog){
        
        Dog result = this.buscarPerroCodigo(dog.getCode());

        if( result != null ){
            boolean resultModel = modeloPerro.actualizar(dog);
            if(resultModel)
                return "";
            else
                return "Ocurrio un error al actualizar la mascota";
        }else{
            return "La mascota a actualizar no existe";
        }
    }
    
    public boolean eliminar(int codigo){
        return this.modeloPerro.eliminar(codigo);
    }
    
    public boolean eliminarLogico(int codigo){
        return this.modeloPerro.eliminarLogico(codigo);
    }
    
}
