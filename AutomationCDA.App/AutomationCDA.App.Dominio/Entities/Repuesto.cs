using System;
using System.Collections.Generic;
using System.Linq;


#nullable disable

namespace AutomationCDA.App.Dominio
{
    public partial class Repuesto
    {
        public int Id { get; set; }
        public string Descripcion { get; set; }
        public int ValorRepuesto { get; set; }
        public int CantidadRepuesto { get; set; }
    }
}
