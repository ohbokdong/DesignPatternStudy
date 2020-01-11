package week4;

public class SimplePizzaFactory {

	public Pizza2 createPizza(String type) {
		Pizza2 pizza = null;
		
		if(type.equals("cheese")) {
			pizza = new CheesePizza();
		} else if(type.equals("pepperoni")) {
			pizza = new PepperoniPizza();
		} else if(type.equals("clam")) {
			pizza = new ClamPizza();
		} else if(type.equals("veggie")) {
			pizza = new VeggiePizza();
		} // end else if
		
		return pizza;
	} // createPizza
	
} // class
