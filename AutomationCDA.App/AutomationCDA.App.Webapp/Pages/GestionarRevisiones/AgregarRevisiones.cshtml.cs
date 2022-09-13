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
  public class AgregarRevisionesModel : PageModel
  {
    private IRevisionRepositorio _revisionRepositorio = new RevisionRepositorio( new AutomationCDA.App.Persistencia.AppContext());
    public void OnGet()
    {
    }

    public IActionResult OnPost()
    {
      var fechaRevision = Request.Form["fechaRevision"];
      var nivelAceite = Request.Form["nivelAceite"];
      var nivelFrenos = Request.Form["nivelFrenos"];
      var nivelRefrigerante = Request.Form["nivelRefrigerante"];
      var nivelDireccion = Request.Form["nivelDireccion"];

      // Validacion de los datos recibidos

      var revision = new Revision{
        FechaRevision = fechaRevision,
        NivelAceite = nivelAceite,
        NivelFrenos = nivelFrenos,
        NivelRefrigerante = nivelRefrigerante,
        NivelDireccion = nivelDireccion,
        IdVehiculo = 1
      };

      var result = _revisionRepositorio.AgregarRevision(revision);
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