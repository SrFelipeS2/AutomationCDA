using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using AutomationCDA.App.Dominio;
using AutomationCDA.App.Persistencia;

namespace AutomationCDA.App.Webapp
{
  public class ListaTodasLasPersonasModel : PageModel
  {
    private IPersonaRepositorio _personaRepositorio = new PersonaRepositorio( new AutomationCDA.App.Persistencia.AppContext());
    public List<Persona> listadoPersonas { get; set;} 
        
        public void OnGet()
        {
            listadoPersonas = new List<Persona>();  
            listadoPersonas = _personaRepositorio.ObtenerTodo();
        }

        public IActionResult OnPostActualizarJson([FromBody]Persona persona)
        {
            var personaResult = _personaRepositorio.BuscarPersona(persona.Id );
            var mensaje = "";
            

            if( personaResult != null){

                personaResult.Cedula = persona.Cedula;
                personaResult.Nombre = persona.Nombre;
                personaResult.Apellidos = persona.Apellidos;
                personaResult.Telefono = persona.Telefono;
                personaResult.CorreoElectronico = persona.CorreoElectronico;
                personaResult.Direccion = persona.Direccion;
                personaResult.NivelEstudios = persona.NivelEstudios;
            
                var result = _personaRepositorio.ActualizarPersona(personaResult);

                if( result > 0){
                    mensaje = "Se actualizo correctamente";
                }else{
                    mensaje = "No se pudo actualizar";
                }

            }else{
                mensaje = "La persona a actualizar no existe";
            }

            //return new JsonResult(persona);

            return Content(mensaje);

        }

        public IActionResult OnPostEliminarJson([FromBody]Persona persona)
        {
            var personaResult = _personaRepositorio.BuscarPersona(persona.Id );
            var mensaje = "";
        
            if( personaResult != null){
           
                var result = _personaRepositorio.EliminarPersona(personaResult);

                if( result > 0){
                    mensaje = "Se elimino correctamente";
                }else{
                    mensaje = "No se pudo eliminar";
                }

            }else{
                mensaje = "La persona a eliminar no existe";
            }

            //return new JsonResult(persona);

            return Content(mensaje);

        }

  }
}
