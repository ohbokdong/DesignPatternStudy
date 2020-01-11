package week4;

public class DependentPizzaStore {

	public Pizza createPizza(String style, String type) {
		Pizza pizza = null;
		
		if(style.equals("NY")) {
			if(type.equals("cheese")) {
				pizza = new NYStyleCheesePizza();
			} else if(type.equals("veggie")) {
				pizza = new NYStyleVeggiePizza();
			} else if(type.equals("clam")) {
				pizza = new NYStyleClamPizza();
			} else if(type.equals("pepperoni")) {
				pizza = new NYStylePepperoniPizza();
			} // end else if
		} else if (style.equals("Chicago")) {
			if(type.equals("cheese")) {
				pizza = new ChicagoStyleCheesePizza();
			} else if(type.equals("veggie")) {
				pizza = new ChicagoStyleVeggiePizza();
			} else if(type.equals("clam")) {
				pizza = new ChicagoStyleClamPizza();
			} else if(type.equals("pepperoni")) {
				pizza = new ChicagoStylePepperoniPizza();
			} // end else if
		} else {
			System.out.println("Error : invalid type of pizza");
			return null;
		} // end else
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	} // createPizza
	
} // class
