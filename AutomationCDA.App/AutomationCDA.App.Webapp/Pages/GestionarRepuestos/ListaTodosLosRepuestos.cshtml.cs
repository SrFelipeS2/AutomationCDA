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
  public class ListaTodosLosRepuestosModel : PageModel
  {
    private IRepuestoRepositorio _repuestoRepositorio = new RepuestoRepositorio( new AutomationCDA.App.Persistencia.AppContext());
    public IEnumerable<Repuesto> listaRepuestos;
    public void OnGet()
    {
      listaRepuestos = _repuestoRepositorio.BuscarListaRepuestos();
    }

    public IActionResult OnPostUpdateJson([FromBody]Repuesto repuesto)
    {
      var repuestoResultUpdate = _repuestoRepositorio.BuscarRepuesto(repuesto.Id);
      var mensaje = "";

      if (repuestoResultUpdate != null)
      {
        repuestoResultUpdate.Descripcion = repuesto.Descripcion;
        repuestoResultUpdate.ValorRepuesto = repuesto.ValorRepuesto;
        repuestoResultUpdate.CantidadRepuesto = repuesto.CantidadRepuesto;
        

        var resultUpdate = _repuestoRepositorio.ActualizarRepuesto(repuestoResultUpdate);
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
        mensaje = "El repuesto a Actualizar no existe";
      }

      return Content(mensaje);
      
    }

    public IActionResult OnPostDeleteJson([FromBody]Repuesto repuesto)
    {
      var repuestoResultDelete = _repuestoRepositorio.BuscarRepuesto(repuesto.Id);
      var mensaje = "";

      if (repuestoResultDelete != null)
      {
        
        var resultDelete = _repuestoRepositorio.EliminarRepuesto(repuestoResultDelete);
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
        mensaje = "La revsion a Eliminar no existe";
      }

      return Content(mensaje);
    
    }
  }
}
