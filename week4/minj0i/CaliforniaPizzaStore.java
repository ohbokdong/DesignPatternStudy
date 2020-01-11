package week4.minj0i;

public class CaliforniaPizzaStore extends PizzaStore {
	Pizza createPizza(String item) {
		if(item.equals("cheese")) {
			return new CFStyleCheesePizza();
		} else if (item.equals("pepperoni")) {
			return new CFStylePepperoniPizza();
		} else if (item.equals("clam")) {
			return new CFStyleClamPizza();
		} else if (item.equals("veggie")) {
			return new CFStyleVeggiePizza();
		} else return null;
	}
}
