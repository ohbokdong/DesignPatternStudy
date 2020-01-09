package week4.younggeun0;

public class NYPizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(String type) {
		
		if (type.equals("cheese")) {
			return new NYStyleCheesePizza(); 
		} else {
			return null;
		}
	}
}
