package week4.factory;

public class PizzaTestDrive {

	public static void main(String[] args) {
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();
		PizzaStore californiaStore = new CaliforniaPizzaStore();

		Pizza pizza = nyStore.createPizza("pepperoni");
		System.out.println("Jungyun ordered a "+pizza.getName());

		pizza = chicagoStore.createPizza("cheese");
		System.out.println("Jungyun ordered a "+pizza.getName());

		pizza = californiaStore.createPizza("apple");
		System.out.println("Jungyun ordered a "+pizza.getName());
		for(Object topping : pizza.toppings) {
			System.out.println(topping);
		} // end for
	} // main

} // class
