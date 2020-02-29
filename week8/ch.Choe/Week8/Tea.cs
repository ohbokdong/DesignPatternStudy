using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week8
{
    class Tea : CaffeBeverage
    {
        protected override void Add()
        {
            Console.WriteLine("Tea Add");
        }

        protected override void Brew()
        {
            Console.WriteLine("Tea Brew");
        }
    }
}
