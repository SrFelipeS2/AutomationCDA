using System;
using System.Collections.Generic;

#nullable disable

namespace AutomationCDA.App.Dominio
{
    public partial class Rol
    {
        public Rol()
        {
            Usuarios = new HashSet<Usuario>();
        }

        public int Id { get; set; }
        public string TipoUsuario { get; set; }

        public virtual ICollection<Usuario> Usuarios { get; set; }
    }
}
