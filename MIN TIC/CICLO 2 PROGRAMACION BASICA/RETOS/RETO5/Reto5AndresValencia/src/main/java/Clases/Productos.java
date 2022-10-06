/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author ANDRES
 */
public class Productos {
    private int Cantidad;
    private String Nombre;
    private int ValorUnitario;
    private String Nit;
    
    
    public Productos(int Cantidad, String Nombre, int ValorUnitario, String Nit){
        this.Cantidad = Cantidad;
        this.Nombre = Nombre;
        this.ValorUnitario = ValorUnitario;
        this.Nit = Nit;
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
     * @return the Nit
     */
    public String getNit() {
        return Nit;
    }

    /**
     * @param Nit the Nit to set
     */
    public void setNit(String Nit) {
        this.Nit = Nit;
    }
}
