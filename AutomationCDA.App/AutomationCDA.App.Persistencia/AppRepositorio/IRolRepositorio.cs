using System;
using AutomationCDA.App.Dominio;
using System.Collections.Generic;
using System.Linq;

namespace AutomationCDA.App.Persistencia
{
  public interface IRolRepositorio
  {
    int AgregarRol(Rol rol);

    Rol BuscarRol(int id);

    IEnumerable<Rol> BuscarListaRoles();

    List<Rol> BuscarRolesPorTipoUsuario(string tipoUsuario);

    int ActualizarRol(Rol rol);

    int EliminarRol(Rol Rol);
  }
}