package week4.rlawjddbs.factory;

public class NYPizzaStore extends PizzaStore {
	
	@Override
	protected Pizza createPizza(String item) {
		if(item.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if(item.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else if(item.equals("clam")) {
			return new NYStyleClamPizza();
		} else if(item.equals("veggie")) {
			return new NYStyleVeggiePizza();
		} else return null;
	} 

}
