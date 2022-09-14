using System;
using AutomationCDA.App.Dominio;
using System.Collections.Generic;
using System.Linq;

namespace AutomationCDA.App.Persistencia
{
  public class PersonaRepositorio: IPersonaRepositorio
  {
    private readonly AppContext _appContext;

    public PersonaRepositorio( AppContext context )
    {
      _appContext = context;
    }
    
    
    int IPersonaRepositorio.AgregarPersona(Persona persona)
    {
      _appContext.Personas.Add(persona);
      return _appContext.SaveChanges();
    }

    List<Persona> IPersonaRepositorio.ObtenerTodo(){
          return _appContext.Personas.ToList();
    }

    Persona IPersonaRepositorio.BuscarPersona(int id)
    {
      return _appContext.Personas.Find(id);
    }

    IEnumerable<Persona> IPersonaRepositorio.BuscarListaPersonas()
    {
      return _appContext.Personas;
    }

    List<Persona> IPersonaRepositorio.BuscarPersonasPorCedula(string cedula)
    {
      return _appContext.Personas.Where( r => r.Cedula == cedula ).ToList();
    }

    int IPersonaRepositorio.ActualizarPersona(Persona persona)
    {
      _appContext.Personas.Update(persona);
      return _appContext.SaveChanges();
    }

    int IPersonaRepositorio.EliminarPersona(Persona persona)
    {
      _appContext.Personas.Remove(persona);
      return _appContext.SaveChanges();
    }

  }

}