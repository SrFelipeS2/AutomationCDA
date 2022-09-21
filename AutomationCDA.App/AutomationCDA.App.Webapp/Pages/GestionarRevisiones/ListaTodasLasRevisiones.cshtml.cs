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
  public class ListaTodasLasRevisionesModel : PageModel
  {
    private IRevisionRepositorio _revisionRepositorio = new RevisionRepositorio( new AutomationCDA.App.Persistencia.AppContext());
    public IEnumerable<Revision> listaRevisiones;
    public void OnGet()
    {
      listaRevisiones = _revisionRepositorio.BuscarListaRevisiones();
    }

    public IActionResult OnPostUpdateJson([FromBody]Revision revision)
    {
      var revisionResultUpdate = _revisionRepositorio.BuscarRevision(revision.Id);
      var mensaje = "";

      if (revisionResultUpdate != null)
      {
        revisionResultUpdate.FechaRevision = revision.FechaRevision;
        revisionResultUpdate.NivelAceite = revision.NivelAceite;
        revisionResultUpdate.NivelFrenos = revision.NivelFrenos;
        revisionResultUpdate.NivelRefrigerante = revision.NivelRefrigerante;
        revisionResultUpdate.NivelDireccion = revision.NivelDireccion;

        var resultUpdate = _revisionRepositorio.ActualizarRevision(revisionResultUpdate);
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
        mensaje = "La revsion a Actualizar no existe";
      }

      return Content(mensaje);
      
    }


    public IActionResult OnPostDeleteJson([FromBody]Revision revision)
    {
      var revisionResultDelete = _revisionRepositorio.BuscarRevision(revision.Id);
      var mensaje = "";

      if (revisionResultDelete != null)
      {
        
        var resultDelete = _revisionRepositorio.EliminarRevision(revisionResultDelete);
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
