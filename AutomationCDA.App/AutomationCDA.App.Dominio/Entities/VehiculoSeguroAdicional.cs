using System;
using System.Collections.Generic;

#nullable disable

namespace AutomationCDA.App.Dominio
{
    public partial class VehiculoSeguroAdicional
    {
        public int IdVehiculo { get; set; }
        public int IdSeguro { get; set; }

        public virtual SeguroAdicional IdSeguroNavigation { get; set; }
        public virtual Vehiculo IdVehiculoNavigation { get; set; }
    }
}
