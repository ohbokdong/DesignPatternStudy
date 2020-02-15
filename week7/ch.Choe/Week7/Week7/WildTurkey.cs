using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week7
{
    class WildTurkey : Turkey
    {
        public void Fly()
        {
            Console.WriteLine("WildTurkey Fly");
        }

        public void Gobble()
        {
            Console.WriteLine("WildTurkey Gobble");
        }
    }
}
