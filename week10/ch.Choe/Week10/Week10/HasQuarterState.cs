using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week10
{
    class HasQuarterState : State
    {
        Random ran = new Random();

        GumballMachine m_GumballMachine;

        public HasQuarterState(GumballMachine machine)
        {
            m_GumballMachine = machine;
        }
        public void Dispense()
        {
            Console.WriteLine("동전을 넣으셨습니다.");
        }

        public void EjectQuarter()
        {
            Console.WriteLine("동전이 반환됩니다.");
            m_GumballMachine.SetState(GumballMachine.StateType.NoQuarter);
        }

        public void InsertQuarter()
        {
            Console.WriteLine("동전을 한 개만 넣어주세요.");
        }

        public void TurnCrack()
        {
            Console.WriteLine("손잡이를 돌리셨습니다.");
            int num = ran.Next(0, 10);

            if(num == 0 && m_GumballMachine.Getcount() > 1)
            {
                m_GumballMachine.SetState(GumballMachine.StateType.Winner);
            }
            else
            {
                m_GumballMachine.SetState(GumballMachine.StateType.Sold);
            }
        }
    }
}
