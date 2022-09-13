using System;
using AutomationCDA.App.Dominio;
using System.Collections.Generic;
using System.Linq;

namespace AutomationCDA.App.Persistencia
{
  public class VehiculoRepositorio: IVehiculoRepositorio
  {
    private readonly AppContext _appContext;

    public VehiculoRepositorio( AppContext context )
    {
      _appContext = context;
    }

    int IVehiculoRepositorio.AgregarVehiculo(Vehiculo vehiculo)
    {
      _appContext.Vehiculos.Add(vehiculo);
      return _appContext.SaveChanges();
    }

    Vehiculo IVehiculoRepositorio.BuscarVehiculo(int id)
    {
      return _appContext.Vehiculos.Find(id);
    }

    IEnumerable<Vehiculo> IVehiculoRepositorio.BuscarListaVehiculos()
    {
      return _appContext.Vehiculos;
    }

    List<Vehiculo> IVehiculoRepositorio.BuscarVehiculoPorPlaca(string placa)
    {
      return _appContext.Vehiculos.Where( v => v.Placa == placa).ToList();
    }

    int IVehiculoRepositorio.ActualizarVehiculo(Vehiculo vehiculo)
    {
      _appContext.Vehiculos.Update(vehiculo);
      return _appContext.SaveChanges();
    }

    int IVehiculoRepositorio.EliminarVehiculo(Vehiculo vehiculo)
    {
      _appContext.Vehiculos.Remove(vehiculo);
      return _appContext.SaveChanges();
    }
  }
}