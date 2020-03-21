using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week10
{
    class Program
    {
        static void Main(string[] args)
        {
            GumballMachine machine = new GumballMachine(5);

            machine.InsertQuarter();
            machine.TurnCrank();

            machine.InsertQuarter();
            machine.TurnCrank();
            machine.InsertQuarter();
            machine.TurnCrank();
        }
    }
}
