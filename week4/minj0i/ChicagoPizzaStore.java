package week4.minj0i;

public class ChicagoPizzaStore extends PizzaStore {
	Pizza createPizza(String item) {
		if(item.equals("cheese")) {
			return new CGStyleCheesePizza();
		}
//		else if (item.equals("pepperoni")) {
//			return new CGStylePepperoniPizza();
//		} else if (item.equals("clam")) {
//			return new CGStyleClamPizza();
//		} else if (item.equals("veggie")) {
//			return new CGStyleVeggiePizza();
//		}
		else return null;
	}
}
