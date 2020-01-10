package week4.younggeun0;

public class NYPizzaStore2 extends PizzaStore2 {

	@Override
	public Pizza2 createPizza(String item) {
		Pizza2 pizza = null;
		PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
		
		if (item.equals("cheese")) {
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("NY Style Cheese Pizza");
		} else if (item.equals("clam")) {
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("NY Style Clam Pizza");
		}
		
		return pizza;
	}
}
