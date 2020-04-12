package week4.rlawjddbs.factory;

public abstract class PizzaStore2 {
	
	public Pizza2 orderPizza(String type) {
		Pizza2 pizza;
		
		pizza = createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	} // orderPizza
	
	protected abstract Pizza2 createPizza(String type);
	
} // class
