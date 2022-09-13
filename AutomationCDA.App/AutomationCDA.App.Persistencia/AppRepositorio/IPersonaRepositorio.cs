using System;
using AutomationCDA.App.Dominio;
using System.Collections.Generic;
using System.Linq;

namespace AutomationCDA.App.Persistencia
{
  public interface IPersonaRepositorio
  {
    int AgregarPersona(Persona persona);

    Persona BuscarPersona(int id);

    IEnumerable<Persona> BuscarListaPersonas();

    List<Persona> BuscarPersonasPorCedula(string cedula);

    int ActualizarPersona(Persona persona);

    int EliminarPersona(Persona persona);
  }
}