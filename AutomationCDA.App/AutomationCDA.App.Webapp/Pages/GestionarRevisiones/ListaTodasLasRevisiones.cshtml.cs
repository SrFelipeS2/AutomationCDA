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
  }
}
