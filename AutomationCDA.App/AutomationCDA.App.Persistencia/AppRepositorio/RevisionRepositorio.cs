using System;
using AutomationCDA.App.Dominio;
using System.Collections.Generic;
using System.Linq;

namespace AutomationCDA.App.Persistencia
{
  public class RevisionRepositorio: IRevisionRepositorio
  {
    private readonly AppContext _appContext;

    public RevisionRepositorio( AppContext context )
    {
      _appContext = context;
    }

    int IRevisionRepositorio.AgregarRevision(Revision revision)
    {
      _appContext.Revisiones.Add(revision);
      return _appContext.SaveChanges();
    }

    Revision IRevisionRepositorio.BuscarRevision(int id)
    {
      return _appContext.Revisiones.Find(id);
    }

    IEnumerable<Revision> IRevisionRepositorio.BuscarListaRevisiones()
    {
      return _appContext.Revisiones;
    }

    List<Revision> IRevisionRepositorio.BuscarRevisionesPorFecha(string fecha)
    {
      return _appContext.Revisiones.Where( r => r.FechaRevision == fecha).ToList();
    }

    int IRevisionRepositorio.ActualizarRevision(Revision revision)
    {
      _appContext.Revisiones.Update(revision);
      return _appContext.SaveChanges();
    }

    int IRevisionRepositorio.EliminarRevision(Revision revision)
    {
      _appContext.Revisiones.Remove(revision);
      return _appContext.SaveChanges();
    }
  }
}