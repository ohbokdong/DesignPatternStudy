using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week9
{
    class Program
    {
        static void Main(string[] args)
        {

            Menu1 m1 = new Menu1();
            Menu2 m2 = new Menu2();
            Waitress wait = new Waitress(m1,m2);

            wait.PrintMenu();
            wait.PrintMenu2();
        }
    }
}
