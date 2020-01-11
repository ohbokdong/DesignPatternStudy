using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Week4.IngredientFactory;

namespace Week4
{
    public class NYStore : PizzaStore
    {

        public NYStore(PizzaIngredientFactory fac)
        {
            this.IngredientFactory = fac;
        }

        protected override Pizza CreatePizza(string type, StaticSimpleCuttingFactory.SliceType slicetype)
        {
            IPizzaCutting cutting = StaticSimpleCuttingFactory.CreateCutting(slicetype);
            Pizza result = null;
            switch (type)
            {
                case "NYCheese":
                    result = new NYCheesePizza(IngredientFactory, cutting);
                    break;
                case "NYClamPizzap":
                    result = new NYClamPizzap(IngredientFactory, cutting);
                    break;
                case "NYPepperoniPizza":
                    result = new NYPepperoniPizza(IngredientFactory, cutting);
                    break;
            }
            return result;
        }
    }
}
