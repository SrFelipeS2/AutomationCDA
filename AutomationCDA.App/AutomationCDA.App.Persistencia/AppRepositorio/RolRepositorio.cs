using System;
using AutomationCDA.App.Dominio;
using System.Collections.Generic;
using System.Linq;

namespace AutomationCDA.App.Persistencia
{
  public class RolRepositorio: IRolRepositorio
  {
    private readonly AppContext _appContext;

    public RolRepositorio( AppContext context )
    {
      _appContext = context;
    }
    
    // METODOS CRUD PARA LOS REPUESTOS
    int IRolRepositorio.AgregarRol(Rol rol)
    {
      _appContext.Roles.Add(rol);
      return _appContext.SaveChanges();
    }

    Rol IRolRepositorio.BuscarRol(int id)
    {
      return _appContext.Roles.Find(id);
    }

    IEnumerable<Rol> IRolRepositorio.BuscarListaRoles()
    {
      return _appContext.Roles;
    }

    List<Rol> IRolRepositorio.BuscarRolesPorTipoUsuario(string tipoUsuario)
    {
      return _appContext.Roles.Where( r => r.TipoUsuario == tipoUsuario ).ToList();
    }

    int IRolRepositorio.ActualizarRol(Rol rol)
    {
      _appContext.Roles.Update(rol);
      return _appContext.SaveChanges();
    }

    int IRolRepositorio.EliminarRol(Rol rol)
    {
      _appContext.Roles.Remove(rol);
      return _appContext.SaveChanges();
    }

  }

}