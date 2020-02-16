using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week7
{
    class Program
    {
        static void Main(string[] args)
        {
            Duck[] ducks;

            MallardDuck mduck = new MallardDuck();
            WildTurkey wturkey = new WildTurkey();
            ducks = new Duck[2];
            ducks[0] = mduck;
            ducks[1] = new TurkeyAdapter(wturkey);

            for (int i = 0; i < ducks.Length; i++)
            {
                ducks[i].Fly();
                ducks[i].Quack();
            }

            HomeTheaterFacade facade = new HomeTheaterFacade(new Tuner(), new Screen(), new Amplifier());
            facade.WatchMovie();

            facade.EndMovie();


        }
    }
}
