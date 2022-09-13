using System;
using AutomationCDA.App.Dominio;
using System.Collections.Generic;
using System.Linq;

namespace AutomationCDA.App.Persistencia
{
  public interface IUsuarioRepositorio
  {
    int AgregarUsuario(Usuario usuario);

    Usuario BuscarUsuario(int id);

    IEnumerable<Usuario> BuscarListaUsuarios();

    List<Usuario> BuscarUsuariosPorCedula(string nombreUsuario);

    int ActualizarUsuario(Usuario usuario);

    int EliminarUsuario(Usuario usuario);
  }
}