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
  public class AgregarSegurosAdicionalesModel : PageModel
  {
    private ISeguroAdicionalRepositorio _seguroAdicionalRepositorio = new SeguroAdicionalRepositorio( new AutomationCDA.App.Persistencia.AppContext());
    public void OnGet()
    {
    }
    public IActionResult OnPost()
    {
      var tipoSeguro = Request.Form["tipoSeguro"];
      var fechaVencimiento = Request.Form["fechaVencimiento"];
      
      // Validacion de los datos recibidos

      var seguro = new SeguroAdicional{
        TipoSeguro = tipoSeguro,
        FechaVencimiento = fechaVencimiento       
      };

      var result = _seguroAdicionalRepositorio.AgregarSeguroAdicional(seguro);
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