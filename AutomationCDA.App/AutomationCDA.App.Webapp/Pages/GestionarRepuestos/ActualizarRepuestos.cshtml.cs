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
  public class ActualizarRepuestosModel : PageModel
  {
    private IRepuestoRepositorio _repuestoRepositorio = new RepuestoRepositorio( new AutomationCDA.App.Persistencia.AppContext());

    public Repuesto repuesto;
    public IActionResult OnGet(int Id)
    {
      repuesto = _repuestoRepositorio.BuscarRepuesto(Id);

      if (repuesto == null)
      {
        return RedirectToPage("./ListaTodosLosRepuestos");
      }
      else
      {
        return Page();
      }
    }

    public IActionResult OnPost()
    {
      var id = Int32.Parse(Request.Form["Id"]);
      var descripcion = Request.Form["descripcion"];
      int valor = Int32.Parse(Request.Form["valor"]);
      int cantidad = Int32.Parse(Request.Form["cantidad"]);

      // Validacion de los datos recibidos

      var resultRepuesto = _repuestoRepositorio.BuscarRepuesto(id);

      if (resultRepuesto != null)
      { 
        resultRepuesto.Descripcion =  descripcion;
        resultRepuesto.ValorRepuesto = valor;
        resultRepuesto.CantidadRepuesto = cantidad;

        var result = _repuestoRepositorio.ActualizarRepuesto(resultRepuesto);
        if (result > 0)
        {
          ViewData["mensaje"] = "Se actualizo correctamente";
        }
        else
        {
          ViewData["mensaje"] = "NO se pudo actualizar";
        }
      }
      else
      {
        ViewData["mensaje"] = "El repuesto ha actualizar no existe";
      }

      // return Page();
      return RedirectToPage("./ListaTodosLosRepuestos");

    }
  }
}
