/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author ANDRES
 */
public class Proveedores {
    
    private String Nit;
    private String RazonSocial;
    private String Telefono;
    private String CorreoElectronico;
    private String Representante;
    private String SitioWeb;
    private String Calle_Carrera;
    private String Numero;
    private String Barrio;
    private String Ciudad;
    
     public Proveedores() {
        this.Nit = "";
        this.RazonSocial = "";
        this.Telefono = "";
        this.CorreoElectronico = "";
        this.Representante = "";
        this.SitioWeb = "";
        this.Calle_Carrera = "";
        this.Numero = "";
        this.Barrio = "";
        this.Ciudad = "";
    }

    public Proveedores(String Nit, String RazonSocial, String Telefono, String CorreoElectronico, String Representante, String SitioWeb, String Calle_Carrera, String Numero, String Barrio, String Ciudad) {
        this.Nit = Nit;
        this.RazonSocial = RazonSocial;
        this.Telefono = Telefono;
        this.CorreoElectronico = CorreoElectronico;
        this.Representante = Representante;
        this.SitioWeb = SitioWeb;
        this.Calle_Carrera = Calle_Carrera;
        this.Numero = Numero;
        this.Barrio = Barrio;
        this.Ciudad = Ciudad;
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

    /**
     * @return the RazonSocial
     */
    public String getRazonSocial() {
        return RazonSocial;
    }

    /**
     * @param RazonSocial the RazonSocial to set
     */
    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the CorreoElectronico
     */
    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    /**
     * @param CorreoElectronico the CorreoElectronico to set
     */
    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    /**
     * @return the Representante
     */
    public String getRepresentante() {
        return Representante;
    }

    /**
     * @param Representante the Representante to set
     */
    public void setRepresentante(String Representante) {
        this.Representante = Representante;
    }

    /**
     * @return the SitioWeb
     */
    public String getSitioWeb() {
        return SitioWeb;
    }

    /**
     * @param SitioWeb the SitioWeb to set
     */
    public void setSitioWeb(String SitioWeb) {
        this.SitioWeb = SitioWeb;
    }

    /**
     * @return the Calle_Carrera
     */
    public String getCalle_Carrera() {
        return Calle_Carrera;
    }

    /**
     * @param Calle_Carrera the Calle_Carrera to set
     */
    public void setCalle_Carrera(String Calle_Carrera) {
        this.Calle_Carrera = Calle_Carrera;
    }

    /**
     * @return the Numero
     */
    public String getNumero() {
        return Numero;
    }

    /**
     * @param Numero the Numero to set
     */
    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    /**
     * @return the Barrio
     */
    public String getBarrio() {
        return Barrio;
    }

    /**
     * @param Barrio the Barrio to set
     */
    public void setBarrio(String Barrio) {
        this.Barrio = Barrio;
    }

    /**
     * @return the Ciudad
     */
    public String getCiudad() {
        return Ciudad;
    }

    /**
     * @param Ciudad the Ciudad to set
     */
    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }
    
}
