package week4.minj0i;

public class PizzaTestDrive {

	public static void main(String[] args) {
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore cgStore = new ChicagoPizzaStore();
		
		Pizza pizza = nyStore.orderPizza("cheese");
		System.out.println("Ethan ordered a "+ pizza.getName());
		
		System.out.println("----------------------------");
		pizza = cgStore.orderPizza("cheese");
		System.out.println("Joel ordered a "+pizza.getName());
	}
}
