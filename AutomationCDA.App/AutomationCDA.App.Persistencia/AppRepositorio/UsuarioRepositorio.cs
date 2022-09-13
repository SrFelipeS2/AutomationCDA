using System;
using AutomationCDA.App.Dominio;
using System.Collections.Generic;
using System.Linq;

namespace AutomationCDA.App.Persistencia
{
  public class UsuarioRepositorio: IUsuarioRepositorio
  {
    private readonly AppContext _appContext;

    public UsuarioRepositorio( AppContext context )
    {
      _appContext = context;
    }
    
    // METODOS CRUD PARA LOS REPUESTOS
    int IUsuarioRepositorio.AgregarUsuario(Usuario usuario)
    {
      _appContext.Usuarios.Add(usuario);
      return _appContext.SaveChanges();
    }

    Usuario IUsuarioRepositorio.BuscarUsuario(int id)
    {
      return _appContext.Usuarios.Find(id);
    }

    IEnumerable<Usuario> IUsuarioRepositorio.BuscarListaUsuarios()
    {
      return _appContext.Usuarios;
    }

    List<Usuario> IUsuarioRepositorio.BuscarUsuariosPorCedula(string nombreUsuario)
    {
      return _appContext.Usuarios.Where( r => r.NombreUsuario == nombreUsuario ).ToList();
    }

    int IUsuarioRepositorio.ActualizarUsuario(Usuario usuario)
    {
      _appContext.Usuarios.Update(usuario);
      return _appContext.SaveChanges();
    }

    int IUsuarioRepositorio.EliminarUsuario(Usuario usuario)
    {
      _appContext.Usuarios.Remove(usuario);
      return _appContext.SaveChanges();
    }

  }

}