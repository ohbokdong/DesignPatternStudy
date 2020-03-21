using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week10
{
    class GumballMachine
    {
        public enum StateType
        {
            Sold,
            Soldout,
            HasQuarter,
            NoQuarter,
            Winner
        }
   
        State soldOutState;
        State noQuarterState;
        State hasQuarterState;
        State soldState;
        State winnerState;

        State state;

        int count = 0;

        public int Getcount()
        {
            return count;
        }

        public GumballMachine(int num)
        {
            soldOutState = new SoldState(this);
            noQuarterState = new NoQuarterState(this);
            hasQuarterState = new HasQuarterState(this);
            soldOutState = new SoldOutsState(this);
            winnerState = new WinnerState(this);

            count = num;
            if(count > 0 )
            {
                state = noQuarterState;
            }
            else
            {
                state = soldState;
            }
        }

        public void SetState(StateType type)
        {
            SetState(GetState(type));
        }

        public void SetState(State state)
        {
            this.state = state;
        }
        public void InsertQuarter()
        {
            state.InsertQuarter();
        }

        public void EjectQuarter()
        {
            state.EjectQuarter();
        }

        public void TurnCrank()
        {
            state.TurnCrack();
            state.Dispense();
        }
        public void ReleaseBall()
        {
            Console.WriteLine("out the slot");
            if(count != 0)
            {
                count--;
            }
        }
        public State GetState(StateType type)
        {
            State result = null;
            switch (type)
            {
                case StateType.Sold:
                    result = soldState;
                    break;
                case StateType.Soldout:
                    result = soldOutState;
                    break;
                case StateType.HasQuarter:
                    result = hasQuarterState;
                    break;
                case StateType.NoQuarter:
                    result = noQuarterState;
                    break;
                case StateType.Winner:
                    result = winnerState;
                    break;
            }
            return result;
        }
    }
}
