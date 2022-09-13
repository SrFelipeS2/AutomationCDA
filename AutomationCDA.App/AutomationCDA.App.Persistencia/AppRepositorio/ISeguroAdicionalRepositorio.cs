using System;
using AutomationCDA.App.Dominio;
using System.Collections.Generic;
using System.Linq;

namespace AutomationCDA.App.Persistencia
{
  public interface ISeguroAdicionalRepositorio
  {
    int AgregarSeguroAdicional(SeguroAdicional Seguro);

  SeguroAdicional BuscarSeguroAdicional(int id);

  IEnumerable<SeguroAdicional> BuscarListaSegurosAdicionales();

  List<SeguroAdicional> BuscarSegurosAdicionalesPorTipo(string tipo);

  int ActualizarSeguroAdicional(SeguroAdicional seguro);

  int EliminarSeguroAdicional(SeguroAdicional seguro);
  }
  

}