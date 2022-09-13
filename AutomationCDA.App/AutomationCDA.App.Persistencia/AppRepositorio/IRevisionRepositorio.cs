using System;
using AutomationCDA.App.Dominio;
using System.Collections.Generic;
using System.Linq;

namespace AutomationCDA.App.Persistencia
{
  public interface IRevisionRepositorio
  {
    int AgregarRevision(Revision revision);

  Revision BuscarRevision(int id);

  IEnumerable<Revision> BuscarListaRevisiones();

  List<Revision> BuscarRevisionesPorFecha(string fecha);

  int ActualizarRevision(Revision revision);

  int EliminarRevision(Revision revision);
  }
  

}