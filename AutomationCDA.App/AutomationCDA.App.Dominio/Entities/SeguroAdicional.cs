using System;
using System.Collections.Generic;

#nullable disable

namespace AutomationCDA.App.Dominio
{
    public partial class SeguroAdicional
    {
        public int Id { get; set; }
        public string TipoSeguro { get; set; }
        public string FechaVencimiento { get; set; }
    }
}
