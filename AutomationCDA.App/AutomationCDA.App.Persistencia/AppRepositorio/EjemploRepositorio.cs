// using System;
// using AutomationCDA.App.Dominio;
// using System.Collections.Generic;
// using System.Linq;

// namespace AutomationCDA.App.Persistencia
// {
//   public class RepuestoRepositorio: IRepuestoRepositorio
//   {
//     private readonly AppContext _appContext;

//     public RepuestoRepositorio( AppContext context )
//     {
//       _appContext = context;
//     }
    
//     // METODOS CRUD PARA LOS REPUESTOS
//     int IRepuestoRepositorio.AgregarRepuesto(Repuesto repuesto)
//     {
//       _appContext.Repuestos.Add(repuesto);
//       return _appContext.SaveChanges();
//     }

//     bool IRepuestoRepositorio.AgregarRepuestoBool(Repuesto repuesto)
//     {
//       _appContext.Repuestos.Add(repuesto);
//       return (_appContext.SaveChanges() > 0) ? true : false;
//     }

//     Repuesto IRepuestoRepositorio.BuscarRepuesto(int id)
//     {
//       return _appContext.Repuestos.Find(id);
//     }

//     IEnumerable<Repuesto> IRepuestoRepositorio.BuscarListaRepuestos()
//     {
//       return _appContext.Repuestos;
//     }

//     IEnumerable<Repuesto> IRepuestoRepositorio.BuscarRepuestosPorValor(int valor)
//     {
//       return _appContext.Repuestos.Where( r => r.ValorRepuesto == valor);
//     }

//     List<Repuesto> IRepuestoRepositorio.BuscarRepuestosPorDescripcion(string descripcion)
//     {
//       return _appContext.Repuestos.Where( r => r.Descripcion.Contains(descripcion) ).ToList();
//     }

//     int IRepuestoRepositorio.ActualizarRepuesto(Repuesto repuesto)
//     {
//       _appContext.Repuestos.Update(repuesto);
//       return _appContext.SaveChanges();
//     }

//     int IRepuestoRepositorio.EliminarRepuesto(Repuesto repuesto)
//     {
//       _appContext.Repuestos.Remove(repuesto);
//       return _appContext.SaveChanges();
//     }

//   }

// }