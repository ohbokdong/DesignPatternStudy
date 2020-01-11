using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Week4.IngredientFactory;

namespace Week4
{/// <summary>
/// pizza store를 통한 팩토리 패턴 구현
/// 
/// </summary>
    class Program
    {
        static void Main(string[] args)
        {
            NYPizzaIngredientFactory nyfactory = new NYPizzaIngredientFactory();
            PizzaStore nystore = new NYStore(nyfactory);

            CCPizzaIngredientFactory ccfactory = new CCPizzaIngredientFactory();
            PizzaStore ccstore = new CCStore(ccfactory);

            Pizza nypizza = nystore.OrderPizza("NYCheese", StaticSimpleCuttingFactory.SliceType.Base);
            Console.WriteLine(nypizza.GetName());

            Pizza ccpizza = ccstore.OrderPizza("CCCheesePizzz", StaticSimpleCuttingFactory.SliceType.Square);
            Console.WriteLine(ccpizza.GetName());
        }
    }
}
