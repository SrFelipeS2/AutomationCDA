
using System;
using AutomationCDA.App.Dominio;
using AutomationCDA.App.Persistencia;
using System.Collections.Generic;
using System.Linq;


namespace AutomationCDA.App.Consola
{
  public class Program
  {
    private static IRepuestoRepositorio _repuestoRepositorio = new RepuestoRepositorio( new AutomationCDA.App.Persistencia.AppContext());

    public static void Main(string[] args)
    {            
      // Console.WriteLine("Registrando un Repuesto");
      
      // var repuesto = new Repuesto{
      //   Descripcion = "Filtro de aceite",
      //   ValorRepuesto = 100300,
      //   CantidadRepuesto = 1
      // };

      // try
      // {
      //   var result = _repuestoRepositorio.AgregarRepuesto(repuesto);
      //   if( result > 0 )
      //   Console.WriteLine("Se inserto correctamente");
      //   else
      //   Console.WriteLine("No se pudo insertar");
      // }
      // catch (System.Exception e)
      // {
      //   Console.WriteLine("Ocurrio un error: " + e );
      //   throw;
      // }


      ////////////// BUSCAR REPUESTO POR ID //////////////////////

      // Console.WriteLine("Buscando un Repuesto");
      // var result = _repuestoRepositorio.BuscarRepuesto(1);
      // Console.WriteLine(result);

      ////////////// BUSCAR TODOS LOS REPUESTOS //////////////////////

      // Console.WriteLine("Buscando todos los Repuestos");
      // var listaRepuestos = _repuestoRepositorio.BuscarListaRepuestos();
      // foreach (var elemento in listaRepuestos)
      // {
      //   Console.WriteLine("Id: " + elemento.Id + ", Descripcion: " + elemento.Descripcion + ", Valor: " + elemento.ValorRepuesto  + ", Cantidad: " + elemento.CantidadRepuesto);
      // }

      ////////////// BUSCAR REPUESTOS POR VALOR ///////////////////////

      // Console.WriteLine("Buscando Repuestos por el Valor");
      // var listaRepuestosValor = _repuestoRepositorio.BuscarRepuestosPorValor(28);

      // foreach (var elemento in listaRepuestosValor)
      // {
      //   Console.WriteLine("Id: " + elemento.Id + ", Descripcion: " + elemento.Descripcion + ", Valor: " + elemento.ValorRepuesto  + ", Cantidad: " + elemento.CantidadRepuesto);
      // }  


      /////////// BUSCAR REPUESTOS POR DESCRIPCION ////////////////////

      // Console.WriteLine("Buscando Repuestos por la Descripcion");
      // var listaRepuestosDescripcion = _repuestoRepositorio.BuscarRepuestosPorDescripcion("Carburador");

      // foreach (var elemento in listaRepuestosDescripcion)
      // {
      //   Console.WriteLine("Id: " + elemento.Id + ", Descripcion: " + elemento.Descripcion + ", Valor: " + elemento.ValorRepuesto  + ", Cantidad: " + elemento.CantidadRepuesto);
      // }      

      //////////////////// ACTUALIZAR REPUESTO POR ID //////////////////
      
      // Console.WriteLine("Actualizando un Repuesto");
      // var result = _repuestoRepositorio.BuscarRepuesto(1);

      //   if( result != null){

      //     result.Descripcion = "Carburador";
      //     result.ValorRepuesto = 500543;
      //     result.CantidadRepuesto = 1;

      //     var res = _repuestoRepositorio.ActualizarRepuesto(result);

      //     if(res > 0){
      //         Console.WriteLine("Se actualizo con exito");
      //     }else{
      //         Console.WriteLine("No fue posible actualizar");
      //     }

      //   }else{
      //       Console.WriteLine("No existe el repuesto a actualizar");
      //   }

      ////////// ELIMINAR REPUESTO POR ID /////////////////////////
      
      // Console.WriteLine("Elimando un Repuesto");
      // var result = _repuestoRepositorio.BuscarRepuesto(4);

      // if( result != null){

      //   var res = _repuestoRepositorio.EliminarRepuesto(result);

      //   if(res > 0){
      //       Console.WriteLine("Se elimino con exito");
      //   }else{
      //       Console.WriteLine("No fue posible eliminar");
      //   }

      // }else{
      //     Console.WriteLine("No existe el repuesto a eliminar");
      // }

      

    }
  }
}
