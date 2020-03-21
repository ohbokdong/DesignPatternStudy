using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week10
{
    class NoQuarterState : State
    {
        GumballMachine m_GumballMachine;

        public NoQuarterState(GumballMachine machine)
        {
            m_GumballMachine = machine;
        }
        public void Dispense()
        {
            Console.WriteLine("동전을 넣어주세요.");
        }

        public void EjectQuarter()
        {
            Console.WriteLine("동전을 넣어주세요.");
        }

        public void InsertQuarter()
        {
            Console.WriteLine("동전을 넣으셨습니다.");
            m_GumballMachine.SetState(GumballMachine.StateType.HasQuarter);
        }

        public void TurnCrack()
        {
            Console.WriteLine("동전을 넣어주세요.");
        }
    }
}
