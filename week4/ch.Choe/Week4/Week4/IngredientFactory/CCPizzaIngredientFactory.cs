using System;
using Week4.Ingredient;
using Week4.Ingredient.CC;

namespace Week4.IngredientFactory
{
    public class CCPizzaIngredientFactory : PizzaIngredientFactory
    {
        public Cheese CreateCheese()
        {
            return new CCCheese();
        }
        public Dough CreateDough()
        {
            return new CCDough();
        }
        public Pepperoni CreatePepperoni()
        {
            return new CCPepperoni();
        }

    }
}
