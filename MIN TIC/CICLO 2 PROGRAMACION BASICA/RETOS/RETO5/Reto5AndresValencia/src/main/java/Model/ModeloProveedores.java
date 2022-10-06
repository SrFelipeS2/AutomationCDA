/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Clases.Proveedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author ANDRES
 *
 */
public class ModeloProveedores {
    
    Database bd;
    Connection conexion;
    
    public ModeloProveedores(){
        this.bd = new Database();
        this.conexion = bd.getConnection();
    }
    
    public boolean crear(Proveedores proveedores){
        try{
            String query = "INSERT INTO proveedor(NIT, razon_social, correo_electronico,representate_legal,sitio_web,telefono,calle_carrera,numero,barrio,ciudad) VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statementProveedor = this.conexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statementProveedor.setString(1,proveedores.getNit());
            statementProveedor.setString(2,proveedores.getRazonSocial());
            statementProveedor.setString(3,proveedores.getCorreoElectronico());
            statementProveedor.setString(4,proveedores.getRepresentante());
            statementProveedor.setString(5,proveedores.getSitioWeb());
            statementProveedor.setString(6,proveedores.getTelefono());
            statementProveedor.setString(7,proveedores.getCalle_Carrera());
            statementProveedor.setString(8,proveedores.getNumero());
            statementProveedor.setString(9,proveedores.getBarrio());
            statementProveedor.setString(10,proveedores.getCiudad());
            
            int rowsInserted = statementProveedor.executeUpdate();
            return (rowsInserted>0);                       
        }
        catch(SQLException e){
            return false;
        }
    }
    
    public Proveedores obtenerProveedor(String Nit){
         
       try{
           String query = "SELECT NIT, razon_social, correo_electronico,representate_legal,sitio_web,telefono,calle_carrera,numero,barrio,ciudad FROM proveedor WHERE NIT = ?";
           PreparedStatement statementProveedor = this.conexion.prepareStatement(query);
           statementProveedor.setString(1,Nit);
           ResultSet result = statementProveedor.executeQuery();
           if(result.next()){
           Proveedores proveedores = new Proveedores();
            proveedores.setNit(result.getString(1));            
            proveedores.setRazonSocial(result.getString(2));
            proveedores.setCorreoElectronico(result.getString(3));
            proveedores.setRepresentante(result.getString(4));
            proveedores.setSitioWeb(result.getString(5));
            proveedores.setTelefono(result.getString(6));
            proveedores.setCalle_Carrera(result.getString(7));
            proveedores.setNumero(result.getString(8));
            proveedores.setBarrio(result.getString(9));
            proveedores.setCiudad(result.getString(10));
            
            return proveedores;
            
           }else{
                return null;
           }
       }
       catch(SQLException e){
           System.out.println("ocurrio un error al obtener la informacion de la base de datos: " + e.getMessage());
           return null;
       }
    }
    
    
    public boolean actualizar(Proveedores proveedores){
        try{
            String queryProveedores = "UPDATE proveedor SET  razon_social = ?, correo_electronico = ?,representate_legal = ?,sitio_web = ?,telefono = ?,calle_carrera = ?,numero = ?,barrio = ?,ciudad = ? WHERE NIT = ?";
            PreparedStatement statementProveedor = this.conexion.prepareStatement(queryProveedores,Statement.RETURN_GENERATED_KEYS);
            statementProveedor.setString(1,proveedores.getRazonSocial());
            statementProveedor.setString(2,proveedores.getCorreoElectronico());
            statementProveedor.setString(3,proveedores.getRepresentante());
            statementProveedor.setString(4,proveedores.getSitioWeb());
            statementProveedor.setString(5,proveedores.getTelefono());
            statementProveedor.setString(6,proveedores.getCalle_Carrera());
            statementProveedor.setString(7,proveedores.getNumero());
            statementProveedor.setString(8,proveedores.getBarrio());
            statementProveedor.setString(9,proveedores.getCiudad());
            statementProveedor.setString(10,proveedores.getNit());
            
            int rowsUpdatedProveedor = statementProveedor.executeUpdate();
            return (rowsUpdatedProveedor>0);                       
        }
        catch(SQLException e){
            return false;
        }
    }
    
    public boolean eliminar(String Nit){
    
        try{
         String queryProveedores = "DELETE FROM proveedor WHERE NIT = ?";
         PreparedStatement statementProveedor = this.conexion.prepareStatement(queryProveedores);
         statementProveedor.setString(1, Nit);
         int rowsDeletedProveedores = statementProveedor.executeUpdate();
         return (rowsDeletedProveedores>0);                       

        }
        catch(SQLException e){
            return false;

        }
    }
    
}

