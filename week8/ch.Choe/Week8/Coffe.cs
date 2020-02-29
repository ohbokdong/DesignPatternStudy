using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week8
{
    class Coffe : CaffeBeverage

    {
        protected override void Add()
        {
            Console.WriteLine("Coffe Add");    
        }



        protected override void Brew()
        {
            Console.WriteLine("Coffe Brew");
        }


    }
}
