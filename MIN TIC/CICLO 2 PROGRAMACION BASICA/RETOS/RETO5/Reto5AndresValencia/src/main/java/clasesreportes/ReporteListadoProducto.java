/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesreportes;

/**
 *
 * @author zambr
 */
public class ReporteListadoProducto {
    
   
    private String razon_social;
    private String telefono;
    private String barrio;
    private String ciudad;
    private String representate_legal;
    private String Nombre;
    private int ValorUnitario;
    private int Cantidad;

    public ReporteListadoProducto(String razon_social, String telefono, String barrio, String ciudad, String representate_legal, String Nombre, int ValorUnitario, int Cantidad) {
        this.razon_social = razon_social;
        this.telefono = telefono;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.representate_legal = representate_legal;
        this.Nombre = Nombre;
        this.ValorUnitario = ValorUnitario;
        this.Cantidad = Cantidad;
    }

   
    
    public ReporteListadoProducto(){
        
    }

    /**
     * @return the razon_social
     */
    public String getRazon_social() {
        return razon_social;
    }

    /**
     * @param razon_social the razon_social to set
     */
    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the barrio
     */
    public String getBarrio() {
        return barrio;
    }

    /**
     * @param barrio the barrio to set
     */
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the representate_legal
     */
    public String getRepresentate_legal() {
        return representate_legal;
    }

    /**
     * @param representate_legal the representate_legal to set
     */
    public void setRepresentate_legal(String representate_legal) {
        this.representate_legal = representate_legal;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the ValorUnitario
     */
    public int getValorUnitario() {
        return ValorUnitario;
    }

    /**
     * @param ValorUnitario the ValorUnitario to set
     */
    public void setValorUnitario(int ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }

    /**
     * @return the Cantidad
     */
    public int getCantidad() {
        return Cantidad;
    }

    /**
     * @param Cantidad the Cantidad to set
     */
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    
}
