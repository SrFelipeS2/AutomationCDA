using System;
using AutomationCDA.App.Dominio;
using System.Collections.Generic;
using System.Linq;

namespace AutomationCDA.App.Persistencia
{
  public interface IRepuestoRepositorio
  {
    int AgregarRepuesto(Repuesto repuesto);

    Repuesto BuscarRepuesto(int id);

    IEnumerable<Repuesto> BuscarListaRepuestos();

    List<Repuesto> BuscarRepuestosPorDescripcion(string descripcion);

    int ActualizarRepuesto(Repuesto repuesto);

    int EliminarRepuesto(Repuesto repuesto);
  }
}