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
  public class AgregarPersonasModel : PageModel
  {
    private IPersonaRepositorio _personaRepositorio = new PersonaRepositorio( new AutomationCDA.App.Persistencia.AppContext());
    public void OnGet()
    {
    }

    public void OnPost(){
           
            Console.WriteLine("Ingresa a OnPost");
            var cedula = Request.Form["cedula"];
            var nombre = Request.Form["nombre"];
            var apellidos = Request.Form["apellidos"];
            var telefono = Request.Form["telefono"];
            var correo = Request.Form["correo"];
            var direccion = Request.Form["direccion"];
            var nivelestudios = Request.Form["nivelestudios"];

            // Hay que validar aca y tambien en Fronend
            // Debe ser lo que sigue.

            var persona = new Persona{
                Cedula = cedula,
                Nombre = nombre,
                Apellidos = apellidos,
                Telefono = telefono,
                CorreoElectronico = correo,
                Direccion = direccion,
                NivelEstudios = nivelestudios
            };

            var result = _personaRepositorio.AgregarPersona(persona);
            if (result > 0){
                Console.WriteLine("Se Registro una Persona correctamente ");
            }else{
                Console.WriteLine("No se Persona correctamente ");
            }

        
    }

    public IActionResult OnPostConsultarPersona(string documento){

            var persona = _personaRepositorio.BuscarPorNoDocumento(documento);

            return new JsonResult( persona );
    }

  }
}
