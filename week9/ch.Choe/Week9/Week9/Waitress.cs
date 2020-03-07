using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week9
{
    class Waitress
    {
        Menu1 menu1;
        Menu2 menu2;


        public Waitress(Menu1 m1, Menu2 m2)
        {
            menu1 = m1;
            menu2 = m2;
        }
        public void PrintMenu()
        {
            System.Diagnostics.Stopwatch sw = new System.Diagnostics.Stopwatch();
            sw.Start();

            UserIterator intermenu1 = menu1.CreateIterator();
            PrintMenu(intermenu1);
            UserIterator intermenu2 = menu2.CreateIterator();
            PrintMenu(intermenu2);
            sw.Stop();

            Console.WriteLine(sw.Elapsed.ToString());
        }

        public void PrintMenu2()
        {
            System.Diagnostics.Stopwatch sw = new System.Diagnostics.Stopwatch();
            sw.Start();
            foreach (Item i in menu1.GetItems())
            {
                PrintMenu(i);
            }

            foreach (Item i in menu2.GetItems())
            {
                PrintMenu(i);
            }
            sw.Stop();

            Console.WriteLine(sw.Elapsed.ToString());
        }

        private void PrintMenu(Item item)
        {
            Console.WriteLine(item.GetName());
            Console.WriteLine(item.GetPrice());
        }

        private void PrintMenu(UserIterator inter)
        {
            while (inter.HasNext())
            {
                Item item = (Item)inter.Next();
                Console.WriteLine(item.GetName());
                Console.WriteLine(item.GetPrice());
            }
        }
    }
}
