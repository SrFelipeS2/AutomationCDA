/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Clases.Productos;
import clasesreportes.ReportProductos;
import clasesreportes.ReporteListadoProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author jotarlo
 */
public class ProductoModelo {
    
    Database bd;
    Connection conexion;
    
    public ProductoModelo(){
        this.bd = new Database();
        this.conexion = bd.getConnection();
    }
    
    public LinkedList<ReportProductos> obtenerListado() throws SQLException{
        
        LinkedList<ReportProductos> listadoProductos = new LinkedList<>();
        
        try{
            String query = "SELECT razon_social, COUNT(Nombre) AS cantidad_Productos\n" +
                           "FROM proveedor\n" +
                           "INNER JOIN productos\n" +
                           "ON  proveedor.NIT = productos.Nit\n" +
                           "GROUP BY razon_social\n";
            PreparedStatement statementProductos = this.conexion.prepareStatement(query);
            
            ResultSet result = statementProductos.executeQuery();
            
            while(result.next() ){
                
                ReportProductos tmpReport = new ReportProductos();
                
                tmpReport.setRazon_social(result.getString("razon_social"));
                tmpReport.setCantidad_Productos(result.getInt("cantidad_Productos"));
                
                listadoProductos.add(tmpReport);
                
            }
            return listadoProductos;
            
        }catch(SQLException e){
            throw e;
           
        }
    }
     public LinkedList<ReporteListadoProducto> obtenerListadoProducto() throws SQLException{
    
        LinkedList<ReporteListadoProducto> list = new LinkedList<ReporteListadoProducto>();
        
        try{
            
            String query = "SELECT razon_social, telefono, barrio, ciudad, representate_legal, Nombre, ValorUnitario, Cantidad \n" +
                           "FROM proveedor\n" +
                           "INNER JOIN productos\n" +
                           "ON  proveedor.NIT = productos.Nit\n" +
                           "WHERE Cantidad > 0;";
            
            PreparedStatement statement = this.conexion.prepareStatement(query);
            
            ResultSet result = statement.executeQuery();
            
            while( result.next() ){
                
                ReporteListadoProducto temp = new ReporteListadoProducto();
                temp.setRazon_social(result.getString("razon_social"));
                temp.setTelefono( result.getString("telefono"));
                temp.setBarrio(result.getString("barrio"));
                temp.setCiudad(result.getString("ciudad"));
                temp.setRepresentate_legal(result.getString("representate_legal"));
                temp.setNombre( result.getString("Nombre") );
                temp.setValorUnitario( result.getInt("ValorUnitario"));
                temp.setCantidad(result.getInt("Cantidad"));
                
                list.add(temp);
            }
            
            return list;            
            
        }catch(SQLException e){
            throw e;
        }
    }
}
