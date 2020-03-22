using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week10
{
    interface State
    {
        void InsertQuarter(machine m);
        void EjectQuarter(machine m);
        void TurnCrack(machine m);
        void Dispense(machine m);
    }
}
