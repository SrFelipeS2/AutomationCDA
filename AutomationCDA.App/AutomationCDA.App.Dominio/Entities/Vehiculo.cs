using System;
using System.Collections.Generic;

#nullable disable

namespace AutomationCDA.App.Dominio
{
    public partial class Vehiculo
    {
        public Vehiculo()
        {
            Revisiones = new HashSet<Revision>();
        }

        public int Id { get; set; }
        public string Placa { get; set; }
        public string Modelo { get; set; }
        public string Marca { get; set; }
        public int CapacidadPasajeros { get; set; }
        public string CilindradaMotor { get; set; }
        public string TipoVehiculo { get; set; }
        public string Observaciones { get; set; }
        public string EstadoSoat { get; set; }

        public virtual ICollection<Revision> Revisiones { get; set; }
    }
}
