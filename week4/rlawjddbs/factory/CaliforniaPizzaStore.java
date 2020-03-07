package week4.factory;

public class CaliforniaPizzaStore extends PizzaStore {

	@Override
	protected Pizza createPizza(String item) {
		if (item.equals("pickle")) {
			return new CaliforniaStylePicklePizza();
		} else if (item.equals("apple")) {
			return new CaliforniaStyleApplePizza();
		} else if (item.equals("carrot")) {
			return new CaliforniaStyleCarrotPizza();
		} else if (item.equals("chocolate")) {
			return new CaliforniaStyleChocolatePizza();
		} else if (item.equals("sushi")) {
			return new CaliforniaStyleSushiPizza();
		} else {
			return null;
		} // end else
	} // createPizza

} // class
