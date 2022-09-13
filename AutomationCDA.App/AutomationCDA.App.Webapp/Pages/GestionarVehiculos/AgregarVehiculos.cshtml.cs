using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using AutomationCDA.App.Dominio;
using AutomationCDA.App.Persistencia;

namespace AutomationCDA.App.Webapp
{
  public class AgregarVehiculosModel : PageModel
  {
    private IVehiculoRepositorio _vehiculoRepositorio = new VehiculoRepositorio( new AutomationCDA.App.Persistencia.AppContext());
    public void OnGet()
    {
      
    }
    public IActionResult OnPost(){
      
      var placa = Request.Form["placa"];
      var modelo = Request.Form["modelo"];
      var marca = Request.Form["marca"];
      int capacidadPasajeros = Int32.Parse(Request.Form["capacidadPasajeros"]);
      var cilindradaMotor = Request.Form["cilindradaMotor"];
      var tipoVehiculo = Request.Form["tipoVehiculo"];
      var observaciones = Request.Form["observaciones"];
      var estadoSoat = Request.Form["estadoSoat"];


      // Validacion de los datos recibidos

      var vehiculo = new Vehiculo{
        Placa = placa,
        Modelo = modelo,
        Marca= marca,
        CapacidadPasajeros=capacidadPasajeros,
        CilindradaMotor=cilindradaMotor,
        TipoVehiculo=tipoVehiculo,
        Observaciones=observaciones,
        EstadoSoat=estadoSoat
       
      };
      //preguntar a ovidio
      var result = _vehiculoRepositorio.AgregarVehiculo(vehiculo);
      if (result > 0)
      {
      return Page();
      }
      else
      {
        return RedirectToPage("./Error");
      }
    }
  }
}