using System;
using AutomationCDA.App.Dominio;
using System.Collections.Generic;
using System.Linq;

namespace AutomationCDA.App.Persistencia
{
  public interface IVehiculoRepositorio
  {
    int AgregarVehiculo(Vehiculo vehiculo);

  Vehiculo BuscarVehiculo(int id);

  IEnumerable<Vehiculo> BuscarListaVehiculos();

  List<Vehiculo> BuscarVehiculoPorPlaca(string placa);

  int ActualizarVehiculo(Vehiculo vehiculo);

  int EliminarVehiculo(Vehiculo vehiculo);
  }
  

}