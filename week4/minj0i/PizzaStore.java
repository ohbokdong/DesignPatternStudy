package week4.minj0i;

public abstract class PizzaStore {
//	SimplePizzaFactory factory;
//	
//	public PizzaStore(SimplePizzaFactory factory) {
//		this.factory = factory;
//	}
	
	public Pizza orderPizza(String type) {
		Pizza pizza;
		
//		pizza = factory.createPizza(type);
		pizza = createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
	
	abstract Pizza createPizza(String type);
	//기타 메소드
}
