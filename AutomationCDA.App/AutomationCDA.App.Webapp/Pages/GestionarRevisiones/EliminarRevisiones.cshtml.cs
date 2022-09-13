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
  public class EliminarRevisionesModel : PageModel
  {
    private IRevisionRepositorio _revisionRepositorio = new RevisionRepositorio( new AutomationCDA.App.Persistencia.AppContext());
    public Revision revision;
    public IActionResult OnGet(int Id)
    {
      revision = _revisionRepositorio.BuscarRevision(Id);

      if (revision == null)
      {
        return RedirectToPage("./ListaTodasLasRevisiones");
      }
      else
      {
        return Page();
      }
    }

    public IActionResult OnPost()
    {
      var id = Int32.Parse(Request.Form["Id"]);
      var fechaRevision = Request.Form["fechaRevision"];
      var nivelAceite = Request.Form["nivelAceite"];
      var nivelFrenos = Request.Form["nivelFrenos"];
      var nivelRefrigerante = Request.Form["nivelRefrigerante"];
      var nivelDireccion = Request.Form["nivelDireccion"];
      
      // Validacion de los datos recibidos

      var resultRevision = _revisionRepositorio.BuscarRevision(id);

      if (resultRevision != null)
      { 
        
        var result = _revisionRepositorio.EliminarRevision(resultRevision);
        if (result > 0)
        {
          ViewData["mensaje"] = "Se Elimino correctamente";
        }
        else
        {
          ViewData["mensaje"] = "NO se pudo Eliminar";
        }
      }
      else
      {
        ViewData["mensaje"] = "La revision ha Eliminar no existe";
      }

      // return Page();
      return RedirectToPage("./ListaTodasLasRevisiones");

    }
  }
}
