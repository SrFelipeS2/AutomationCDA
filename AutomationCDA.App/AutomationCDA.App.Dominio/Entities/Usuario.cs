using System;
using System.Collections.Generic;

#nullable disable

namespace AutomationCDA.App.Dominio
{
    public partial class Usuario
    {
        public int Id { get; set; }
        public string NombreUsuario { get; set; }
        public string Contraseña { get; set; }
        public int IdRol { get; set; }
        public int IdPersona { get; set; }

        public virtual Persona IdPersonaNavigation { get; set; }
        public virtual Rol IdRolNavigation { get; set; }
    }
}
