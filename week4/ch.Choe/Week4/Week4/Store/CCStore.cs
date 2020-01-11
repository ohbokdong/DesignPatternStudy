using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Week4.IngredientFactory;

namespace Week4
{
    public class CCStore : PizzaStore
    {
        public CCStore(PizzaIngredientFactory fac)
        {
            this.IngredientFactory = fac;
        }
        protected override Pizza CreatePizza(string type, StaticSimpleCuttingFactory.SliceType slicetype)
        {
            IPizzaCutting cutting = StaticSimpleCuttingFactory.CreateCutting(slicetype);
            Pizza result = null;
            switch (type)
            {
                case "CCCheesePizzz":
                    result = new CCCheesePizzz(IngredientFactory, cutting);
                    break;
                case "CCClamPizza":
                    result = new CCClamPizza(IngredientFactory, cutting);
                    break;
                case "CCPepperoniPizza":
                    result = new CCPepperoniPizza(IngredientFactory, cutting);
                    break;
            }
            return result;
        }
    }
}
