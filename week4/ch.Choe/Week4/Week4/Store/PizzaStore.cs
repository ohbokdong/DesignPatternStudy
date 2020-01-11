using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Week4.IngredientFactory;

namespace Week4
{
    public abstract class PizzaStore
    {
        public PizzaIngredientFactory IngredientFactory;
        public Pizza OrderPizza(string type, StaticSimpleCuttingFactory.SliceType slicetype)
        {
            Pizza pizza;
            pizza = CreatePizza(type, slicetype);
            pizza.Prepare();
            pizza.Bake();
            pizza.Cut();
            pizza.Box();

            return pizza;   
        }

        protected abstract Pizza CreatePizza(string type, StaticSimpleCuttingFactory.SliceType slicetype);
        
    }
}
