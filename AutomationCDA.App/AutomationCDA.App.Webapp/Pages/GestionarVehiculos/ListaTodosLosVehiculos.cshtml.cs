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
  public class ListaTodosLosVehiculosModel : PageModel
  {
    private IVehiculoRepositorio _vehiculoRepositorio = new VehiculoRepositorio( new AutomationCDA.App.Persistencia.AppContext());
    public IEnumerable<Vehiculo> listaVehiculos;
    public void OnGet()
    {
      listaVehiculos = _vehiculoRepositorio.BuscarListaVehiculos();
    }
  
  
  public IActionResult OnPostUpdateJson([FromBody]Vehiculo vehiculo)
  {
    var vehiculoResultUpdate = _vehiculoRepositorio.BuscarVehiculo(vehiculo.Id);
    var mensaje = "";

    if (vehiculoResultUpdate != null)
    {
      vehiculoResultUpdate.Placa = vehiculo.Placa;
      vehiculoResultUpdate.Modelo = vehiculo.Modelo;
      vehiculoResultUpdate.Marca = vehiculo.Marca;
      vehiculoResultUpdate.CapacidadPasajeros = vehiculo.CapacidadPasajeros;
      vehiculoResultUpdate.CilindradaMotor = vehiculo.CilindradaMotor;
      vehiculoResultUpdate.TipoVehiculo = vehiculo.TipoVehiculo;
      vehiculoResultUpdate.Observaciones = vehiculo.Observaciones;
      vehiculoResultUpdate.EstadoSoat = vehiculo.EstadoSoat;

      var resultUpdate = _vehiculoRepositorio.ActualizarVehiculo(vehiculoResultUpdate);
      if (resultUpdate > 0)
      {
        mensaje = "Se Actualizó correctamente";
      }
      else
      {
        mensaje = "No se pudo Actualizar";
      }
    }
    else
    {
      mensaje = "El vehiculo a Actualizar no existe";
    }

    return Content(mensaje);
        
  }

  public IActionResult OnPostDeleteJson([FromBody]Vehiculo vehiculo)
  {
    var vehiculoResultDelete = _vehiculoRepositorio.BuscarVehiculo(vehiculo.Id);
    var mensaje = "";

    if (vehiculoResultDelete != null)
    {
          
      var resultDelete = _vehiculoRepositorio.EliminarVehiculo(vehiculoResultDelete);
      if (resultDelete > 0)
      {
        mensaje = "Se Eliminó correctamente";
      }
      else
      {
        mensaje = "No se pudo Eliminar";
      }
    }
    else
    {
      mensaje = "El vehiculo a Eliminar no existe";
    }

    return Content(mensaje);
      
  }    
  }
}

