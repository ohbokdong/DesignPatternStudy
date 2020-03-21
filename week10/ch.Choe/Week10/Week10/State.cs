using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week10
{
    interface State
    {
        void InsertQuarter();
        void EjectQuarter();
        void TurnCrack();
        void Dispense();
    }
}
