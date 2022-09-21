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
  public class ListaTodosLosSegurosAdicionalesModel : PageModel
  {
    private ISeguroAdicionalRepositorio _seguroAdicionalRepositorio = new SeguroAdicionalRepositorio( new AutomationCDA.App.Persistencia.AppContext());
    public IEnumerable<SeguroAdicional> listaSeguroAdicional;
    public void OnGet()
    {
      listaSeguroAdicional = _seguroAdicionalRepositorio.BuscarListaSegurosAdicionales();
    }

    public IActionResult OnPostUpdateJson([FromBody]SeguroAdicional seguro)
    {
      var seguroResultUpdate = _seguroAdicionalRepositorio.BuscarSeguroAdicional(seguro.Id);
      var mensaje = "";

      if (seguroResultUpdate != null)
      {
        seguroResultUpdate.TipoSeguro = seguro.TipoSeguro;
        seguroResultUpdate.FechaVencimiento = seguro.FechaVencimiento;

        var resultUpdate = _seguroAdicionalRepositorio.ActualizarSeguroAdicional(seguroResultUpdate);
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
        mensaje = "El seguro a Actualizar no existe";
      }

      return Content(mensaje);
      
    }
    public IActionResult OnPostDeleteJson([FromBody]SeguroAdicional seguro)
    {
      var seguroResultDelete = _seguroAdicionalRepositorio.BuscarSeguroAdicional(seguro.Id);
      var mensaje = "";

      if (seguroResultDelete != null)
      {
        
        var resultDelete = _seguroAdicionalRepositorio.EliminarSeguroAdicional(seguroResultDelete);
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
        mensaje = "El seguro a Eliminar no existe";
      }

      return Content(mensaje);
    
    }

  }
}