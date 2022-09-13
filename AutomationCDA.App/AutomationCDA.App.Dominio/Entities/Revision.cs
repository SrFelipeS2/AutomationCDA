using System;
using System.Collections.Generic;

#nullable disable

namespace AutomationCDA.App.Dominio
{
    public partial class Revision
    {
        public int Id { get; set; }
        public string FechaRevision { get; set; }
        public string NivelAceite { get; set; }
        public string NivelFrenos { get; set; }
        public string NivelRefrigerante { get; set; }
        public string NivelDireccion { get; set; }
        public int IdVehiculo { get; set; }

        public virtual Vehiculo IdVehiculoNavigation { get; set; }
    }
}
