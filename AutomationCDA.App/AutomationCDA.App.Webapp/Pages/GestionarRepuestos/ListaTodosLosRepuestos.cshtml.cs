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
  }
}
