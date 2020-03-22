using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week10
{
    class SoldState : State
    {
        //GumballMachine m_GumballMachine;

        public static SoldState(GumballMachine machine)
        {
            //m_GumballMachine = machine;
        }
        public static void Dispense(machine m)
        {
            Console.WriteLine("알맹이가 나가고 있습니다.");
            m.ReleaseBall();
            if(m_GumballMachine.Getcount() > 0)
            {
                m.SetState(GumballMachine.StateType.NoQuarter);
            }
            else
            {
                m.SetState(GumballMachine.StateType.Soldout);
            }
        }

        public static void EjectQuarter()
        {
            Console.WriteLine("이미 뽑았습니다.");
        }

        public static void InsertQuarter()
        {
            Console.WriteLine("잠깐 기다려 주세요.");
        }

        public static void TurnCrack()
        {
            Console.WriteLine("손잡이는 한번만.");
        }
    }
}
