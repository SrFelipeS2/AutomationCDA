using System;
using System.Collections.Generic;

#nullable disable

namespace AutomationCDA.App.Dominio
{
    public partial class RepuestoRevision
    {
        public int IdRevision { get; set; }
        public int IdRepuesto { get; set; }

        public virtual Repuesto IdRepuestoNavigation { get; set; }
        public virtual Revision IdRevisionNavigation { get; set; }
    }
}
