using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week10
{
    class SoldState : State
    {
        GumballMachine m_GumballMachine;

        public SoldState(GumballMachine machine)
        {
            m_GumballMachine = machine;
        }
        public void Dispense()
        {
            Console.WriteLine("알맹이가 나가고 있습니다.");
            m_GumballMachine.ReleaseBall();
            if(m_GumballMachine.Getcount() > 0)
            {
                m_GumballMachine.SetState(GumballMachine.StateType.NoQuarter);
            }
            else
            {
                m_GumballMachine.SetState(GumballMachine.StateType.Soldout);
            }
        }

        public void EjectQuarter()
        {
            Console.WriteLine("이미 뽑았습니다.");
        }

        public void InsertQuarter()
        {
            Console.WriteLine("잠깐 기다려 주세요.");
        }

        public void TurnCrack()
        {
            Console.WriteLine("손잡이는 한번만.");
        }
    }
}
