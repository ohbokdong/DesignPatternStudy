package week4.younggeun0;

public class PizzaTestDrive {

	public static void main(String[] args) {
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();
		
		Pizza pizza = nyStore.orderPizza("cheese");
		System.out.println("철수가 주문한 피자는 "+pizza.getName()+"\n");
		
		pizza = chicagoStore.orderPizza("cheese");
		System.out.println("영희가 주문한 피자는 "+pizza.getName()+"\n");
		
	}
}
