using Week4.Ingredient;

namespace Week4.IngredientFactory
{
    public interface PizzaIngredientFactory
    {
        Dough CreateDough();
        Cheese CreateCheese();
        Pepperoni CreatePepperoni();

    }
}
