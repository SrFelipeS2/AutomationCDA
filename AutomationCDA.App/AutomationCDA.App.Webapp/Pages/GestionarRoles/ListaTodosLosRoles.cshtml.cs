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
  public class ListaTodosLosRolesModel : PageModel
  {
    private IRolRepositorio _rolRepositorio = new RolRepositorio( new AutomationCDA.App.Persistencia.AppContext());
    public void OnGet()
    {
    }
  }
}