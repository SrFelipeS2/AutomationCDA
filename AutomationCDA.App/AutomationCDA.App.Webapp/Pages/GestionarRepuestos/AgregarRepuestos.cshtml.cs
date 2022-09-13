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
  public class AgregarRepuestosModel : PageModel
  {
    private IRepuestoRepositorio _repuestoRepositorio = new RepuestoRepositorio( new AutomationCDA.App.Persistencia.AppContext());
    public void OnGet()
    {

    }

    public IActionResult OnPost()
    {
      var descripcion = Request.Form["descripcion"];
      int valor = Int32.Parse(Request.Form["valor"]);
      int cantidad = Int32.Parse(Request.Form["cantidad"]);

      // Validacion de los datos recibidos

      var repeusto = new Repuesto{
        Descripcion = descripcion,
        ValorRepuesto = valor,
        CantidadRepuesto = cantidad
      };

      var result = _repuestoRepositorio.AgregarRepuesto(repeusto);
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
