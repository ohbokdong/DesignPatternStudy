package week4.factory;

public class SimplePizzaFactory {

	public PizzaStore createPizza(String type) {
		PizzaStore pizza = null;

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
