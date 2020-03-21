using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week10
{
    class SoldOutsState : State
    {
        GumballMachine m_GumballMachine;

        public SoldOutsState(GumballMachine machine)
        {
            m_GumballMachine = machine;
        }
        public void Dispense()
        {
            Console.WriteLine("매진입니다.");
        }

        public void EjectQuarter()
        {
            Console.WriteLine("동전을넣지 않으셨습니다. 동전 반환 X");
        }

        public void InsertQuarter()
        {
            Console.WriteLine("매진되었습니다.");
        }

        public void TurnCrack()
        {
            Console.WriteLine("매진되었습니다.");
        }
    }
}
