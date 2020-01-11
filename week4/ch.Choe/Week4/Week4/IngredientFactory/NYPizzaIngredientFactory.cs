using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Week4.Ingredient;
using Week4.Ingredient.NY;

namespace Week4.IngredientFactory
{
    public class NYPizzaIngredientFactory : PizzaIngredientFactory
    {
        public Cheese CreateCheese()
        {
            return new NYCheese();
        }

        public Dough CreateDough()
        {
            return new NYDough();
        }

        public Pepperoni CreatePepperoni()
        {
            return new NYPepperoni();
        }

    }
}
