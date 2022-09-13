using System;
using AutomationCDA.App.Dominio;
using System.Collections.Generic;
using System.Linq;

namespace AutomationCDA.App.Persistencia
{
  public class SeguroAdicionalRepositorio: ISeguroAdicionalRepositorio
  {
    private readonly AppContext _appContext;

    public SeguroAdicionalRepositorio( AppContext context )
    {
      _appContext = context;
    }

    int ISeguroAdicionalRepositorio.AgregarSeguroAdicional(SeguroAdicional seguro)
    {
      _appContext.SeguroAdicionales.Add(seguro);
      return _appContext.SaveChanges();
    }

    SeguroAdicional ISeguroAdicionalRepositorio.BuscarSeguroAdicional(int id)
    {
      return _appContext.SeguroAdicionales.Find(id);
    }

    IEnumerable<SeguroAdicional> ISeguroAdicionalRepositorio.BuscarListaSegurosAdicionales()
    {
      return _appContext.SeguroAdicionales;
    }

    List<SeguroAdicional> ISeguroAdicionalRepositorio.BuscarSegurosAdicionalesPorTipo(string tipo)
    {
      return _appContext.SeguroAdicionales.Where( r => r.TipoSeguro == tipo ).ToList();
    }

    int ISeguroAdicionalRepositorio.ActualizarSeguroAdicional(SeguroAdicional seguro)
    {
      _appContext.SeguroAdicionales.Update(seguro);
      return _appContext.SaveChanges();
    }

    int ISeguroAdicionalRepositorio.EliminarSeguroAdicional(SeguroAdicional seguro)
    {
      _appContext.SeguroAdicionales.Remove(seguro);
      return _appContext.SaveChanges();
    }
  }
}