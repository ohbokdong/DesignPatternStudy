using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Week3
{
    class Program
    {
        static void Main(string[] args)
        {
            Beverage espresso = new Espresso();
            Console.WriteLine(espresso.GetDescription() + ", Cost : " + espresso.Cost());


            Beverage coffee = new Espresso();
            coffee = new Mocha(coffee);
            coffee = new Mocha(coffee);
            coffee = new Whip(coffee);

            Console.WriteLine(coffee.GetType());
            Console.WriteLine(coffee.GetDescription() + ", Cost : " + coffee.Cost());

            Beverage blend = new HouseBlend();

            blend = new Soy(blend);
            blend = new Mocha(blend);
            blend = new Whip(blend);

            Console.WriteLine(blend.GetDescription() + ", Cost : " + blend.Cost());


        }
    }
}
