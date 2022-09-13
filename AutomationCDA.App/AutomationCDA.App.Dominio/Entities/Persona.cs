using System;
using System.Collections.Generic;

#nullable disable

namespace AutomationCDA.App.Dominio
{
    public partial class Persona
    {
        public Persona()
        {
            Usuarios = new HashSet<Usuario>();
        }

        public int Id { get; set; }
        public string Cedula { get; set; }
        public string Nombre { get; set; }
        public string Apellidos { get; set; }
        public string Telefono { get; set; }
        public string CorreoElectronico { get; set; }
        public string Direccion { get; set; }
        public string NivelEstudios { get; set; }
        public virtual ICollection<Usuario> Usuarios { get; set; }
    }
}
