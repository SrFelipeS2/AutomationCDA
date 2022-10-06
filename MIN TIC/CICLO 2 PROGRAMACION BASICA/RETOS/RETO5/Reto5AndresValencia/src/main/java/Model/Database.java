/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ANDRES
 */
public class Database {
    
   private String driver = "com.mysql.cj.jdbc.Driver";
   private String user = "root";
   private String password = "123456789";
   private String database = "proveedores";
   private String url = "jdbc:mysql://localhost:3307/" + database ;
   private Connection  connection;
   
   public Connection getConnection(){
       try{
           this.connection = DriverManager.getConnection(this.url, this.user, this.password);
           return this.connection;
       }
       catch(SQLException e){
           System.out.println("error en la conexion con la  base de datos: " + e.getSQLState());
           return null;
       }
   }
           
}
