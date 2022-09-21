using System;
using AutomationCDA.App.Dominio;
using System.Collections.Generic;
using System.Linq;

namespace AutomationCDA.App.Persistencia
{
  public interface IPersonaRepositorio
  {
    int AgregarPersona(Persona persona);
    List<Persona> ObtenerTodo();

    Persona BuscarPersona(int id);

    int EliminarPersona(Persona persona);

    IEnumerable<Persona> BuscarListaPersonas();

    List<Persona> BuscarPersonasPorCedula(string cedula);

    int ActualizarPersona(Persona persona);

    Persona BuscarPorNoDocumento(string NoDocumento);

    //int EliminarPersona(Persona persona);
  }
}