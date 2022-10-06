/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Clases.Proveedores;
import Model.ModeloProveedores;
import Model.ProductoModelo;
import clasesreportes.ReportProductos;
import clasesreportes.ReporteListadoProducto;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author ANDRES
 */
public class ctlProveedores {

    private ModeloProveedores modeloProveedores;
    private ProductoModelo modeloProducto;
  
    
    public ctlProveedores(){
        this.modeloProveedores = new ModeloProveedores();
        this.modeloProducto = new ProductoModelo();
    }
    
    public boolean RegistrarProveedor(Proveedores objectProveedores){
        boolean result = modeloProveedores.crear(objectProveedores);
        return result;
    }
    
    public boolean EliminarProveedor(String Nit){
        boolean result = modeloProveedores.eliminar(Nit);
        return result;
    }
     
    public Proveedores BuscarProveedor(String nit){
        Proveedores proveedor = modeloProveedores.obtenerProveedor(nit);
        return proveedor;
    }
    
    public String ActualizarProveedor(Proveedores proveedores){
         Proveedores result = this.BuscarProveedor(proveedores.getNit());
         if(result != null){
             boolean resultModel = modeloProveedores.actualizar(proveedores);
             if(resultModel){
                return "";
             }else{
                return "ocurrio un error al actualizar el proveedor";
             }
         }
         else {
             return "el proveedor con el nit ingresado no existe";
         }
    }
    
    public LinkedList<ReportProductos> obtenerListado() throws SQLException{
        return this.modeloProducto.obtenerListado(); 
    }
    
    public LinkedList<ReporteListadoProducto> obtenerListadoProducto() throws SQLException{
        return this.modeloProducto.obtenerListadoProducto();
    }
    
}
