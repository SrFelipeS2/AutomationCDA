/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.Dog;
import Classes.Pet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author zambr
 */
public class modeloPerro {
    
    Database bd;
    Connection conexion;
    
    public modeloPerro(){
        this.bd = new Database();
        this.conexion = bd.getConnection();
    }
    
    public boolean crear(Dog dog){
        try {
            String query = "INSERT INTO pet (name, born_year, color, health_status) VALUES ( ?, ?, ?, ?)";
            PreparedStatement statementPet = this.conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementPet.setString(1, dog.getName());
            statementPet.setInt(2, dog.getBornYear());
            statementPet.setString(3, dog.getColor());
            statementPet.setInt(4, dog.getHealthStatus());
            
            int rowsInserted = statementPet.executeUpdate();
            
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statementPet.getGeneratedKeys();
                if (generatedKeys.next()) {
                    
                    int codePet = generatedKeys.getInt(1);
                    
                    query = "INSERT INTO dog (breed, pedigree, code_pet) VALUES (?, ?, ?)";
                    PreparedStatement statementDog = this.conexion.prepareStatement(query);                    
                    statementDog.setInt(1, dog.getBreed());
                    statementDog.setBoolean(2, dog.getPedigree());
                    statementDog.setInt(3, codePet);
                    
                    int rowsInsertedDog = statementDog.executeUpdate();
                    
                    return (rowsInserted > 0 && rowsInsertedDog > 0);
                                                            
                }
            }
            return false;
        } catch (SQLException e) {
            return false;
        }        
    }
    
    public Dog obtenerPerro(int codigo){
        try{
            String query = "SELECT code, name, born_year, color, health_status, breed, pedigree FROM pet INNER JOIN dog ON pet.code = dog.code_pet WHERE code = ? AND status = 'A' ";
            PreparedStatement statementDog = this.conexion.prepareStatement(query);
            statementDog.setInt(1, codigo);
            
            ResultSet result = statementDog.executeQuery();
            
            if( result.next() ){
                
                Dog perro = new Dog();
                
                perro.setCode( result.getInt(1) );
                perro.setName( result.getString(2) );
                perro.setBornYear( result.getInt(3) );
                perro.setColor( result.getString(4) );
                perro.setHealthStatus( result.getInt(5) );
                perro.setBreed( result.getInt(6) );
                perro.setPedigree( result.getBoolean(7) );
                
                return perro;
                
            }else{
                return null;
            }
            
        }catch(SQLException e){
            System.out.println("Ocurrio un error: " + e.getMessage() );
            return null;
        }
    }
            
    public boolean actualizar(Dog dog){
        try {
            String queryPet = "UPDATE pet SET name = ?, born_year = ?, color = ?, health_status = ? WHERE code = ?";
            PreparedStatement statementPet = this.conexion.prepareStatement(queryPet);
            statementPet.setString(1, dog.getName());
            statementPet.setInt(2, dog.getBornYear());
            statementPet.setString(3, dog.getColor());
            statementPet.setInt(4, dog.getHealthStatus());
            statementPet.setInt(5, dog.getCode());

            String queryDog = "UPDATE dog SET breed = ?, pedigree = ? WHERE code_pet = ?";
            PreparedStatement statementDog = this.conexion.prepareStatement(queryDog);
            statementDog.setInt(1, dog.getBreed());
            statementDog.setBoolean(2, dog.getPedigree());
            statementDog.setInt(3, dog.getCode());
            
            int rowsUpdatedPet = statementPet.executeUpdate();
            int rowsUpdatedDog = statementDog.executeUpdate();
            
            return rowsUpdatedPet > 0 || rowsUpdatedDog > 0;
            
        } catch (SQLException e) {
            return false;
        }
    }
    
    public Dog obtener(int code){
        
        Dog dog = null;
        try {
            String query = "SELECT code, name, born_year, color, health_status, id, breed, pedigree FROM pet AS p INNER JOIN dog AS d on p.code = d.code_pet WHERE p.code = ? ";
            PreparedStatement statementPet = this.conexion.prepareStatement(query);
            statementPet.setInt(1, code);            
            
            ResultSet result = statementPet.executeQuery();
            
            while (result.next()) {
                int petCode = result.getInt(1);
                String petName = result.getString(2);
                int petBornYear = result.getInt(3);
                String petColor = result.getString(4);
                int petHealthStatus = result.getInt(5);
                int dogId = result.getInt(6);
                int petBreed = result.getInt(7);
                Boolean petPedigree = result.getBoolean(8);
                
                dog = new Dog(dogId, petBreed, petPedigree, petCode, petName, petBornYear, petColor, petHealthStatus);
            }
            return dog;
        } catch (SQLException e) {
            return dog;
        }        
    }
    
    public LinkedList<Pet> obtenerListado(){
        LinkedList<Pet> dogList = new LinkedList<>();
        try {
            String query = "SELECT * FROM pet AS p INNER JOIN dog AS d on p.code = d.code_pet";
            PreparedStatement statementPet = this.conexion.prepareStatement(query);
            ResultSet result = statementPet.executeQuery();
            while (result.next()) {
                int petCode = result.getInt(1);
                String petName = result.getString(2);
                int petBornYear = result.getInt(3);
                String petColor = result.getString(4);
                int petHealthStatus = result.getInt(5);
                int dogId = result.getInt(6);
                int petBreed = result.getInt(7);
                Boolean petPedigree = result.getBoolean(8);
                
                Dog dog = new Dog(dogId, petBreed, petPedigree, petCode, petName, petBornYear, petColor, petHealthStatus);
                dogList.add(dog);
            }
            return dogList;
            
        } catch (SQLException e) {
            return dogList;
        }
    }
    
    public Dog[] obtenerListadoPorNombre(String nombre){
        return null;
    }
    
    public Dog[] obtenerListadoPorRaza(String raza){
        return null;
    }
    
    public boolean eliminar(int codigo){        
        try {
            String queryPet = "DELETE FROM pet WHERE code = ?";
            PreparedStatement statementPet = this.conexion.prepareStatement(queryPet);
            statementPet.setInt(1, codigo);
            
            String queryDog = "DELETE FROM dog WHERE code_pet = ?";
            PreparedStatement statementDog = this.conexion.prepareStatement(queryDog);
            statementDog.setInt(1, codigo);
            
            int rowsDeletedDog = statementDog.executeUpdate();
            int rowsDeletedPet = statementPet.executeUpdate();
                        
            return rowsDeletedPet > 0 && rowsDeletedDog > 0;
            
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean eliminarLogico(int codigo){
        try{
            String queryPet = "UPDATE pet SET status = 'E' WHERE code = ?";
            PreparedStatement statementPet = this.conexion.prepareStatement(queryPet);
            statementPet.setInt(1, codigo);
            
            int rowsDeletedPet = statementPet.executeUpdate();
            
            return rowsDeletedPet > 0;
            
        }catch (SQLException e) {
            return false;
        }
    }
}
