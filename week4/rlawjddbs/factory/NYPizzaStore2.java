package week4;

public class NYPizzaStore2 extends PizzaStore2 {
	
	@Override
	protected Pizza2 createPizza(String item) {
		Pizza2 pizza = null;
		PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
		
		if(item.equals("cheese")) {
			
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");
			
		} else if(item.equals("veggie")) {
			
			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("New York Style Veggie Pizza");
			
		} else if(item.equals("clam")) {
			
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("New York Style Clam Pizza");
			
		} else if(item.equals("pepperoni")) {
			
			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("New York Style Pepperoni Pizza");
			
		} // end else if
		
		return pizza;
	} // createPizza

}
