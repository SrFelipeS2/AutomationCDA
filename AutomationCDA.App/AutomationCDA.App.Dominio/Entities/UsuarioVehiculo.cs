using System;
using System.Collections.Generic;

#nullable disable

namespace AutomationCDA.App.Dominio
{
    public partial class UsuarioVehiculo
    {
        public int IdUsuario { get; set; }
        public int IdVehiculo { get; set; }

        public virtual Usuario IdUsuarioNavigation { get; set; }
        public virtual Vehiculo IdVehiculoNavigation { get; set; }
    }
}
