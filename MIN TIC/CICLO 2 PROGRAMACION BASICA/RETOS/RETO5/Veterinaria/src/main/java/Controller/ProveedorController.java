/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Proveedor;
import Classes.Reportes.ReporteListadoProducto;
import Classes.Reportes.ReporteProveedor;
import Model.ProveedorModel;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author zambr
 */
public class ProveedorController {
    
    private ProveedorModel model;
    
    public ProveedorController(){
        model = new ProveedorModel();
    }
    
    public LinkedList<Proveedor> obtenerProveedores() throws SQLException{
        
        try{
            return model.obtenerListado();    
        }catch(SQLException e){
            throw e;
        }        
    }
    
    public LinkedList<ReporteProveedor> obtenerReporte() throws SQLException{
        
        try{
            return model.obtenerReporte();    
        }catch(SQLException e){
            throw e;
        }        
    }
    
    public LinkedList<ReporteListadoProducto> obtenerListadoProducto() throws SQLException{
        
        try{
            return model.obtenerListadoProducto();    
        }catch(SQLException e){
            throw e;
        }        
    }
    
}
