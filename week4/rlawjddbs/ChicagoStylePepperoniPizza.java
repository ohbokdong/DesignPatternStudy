package week4;

public class ChicagoStylePepperoniPizza extends Pizza {

	public ChicagoStylePepperoniPizza() {
		name = "Chicago Style Sauce and Pepperoni Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
		
		toppings.add("Pepperoni");
	}
	
	@Override
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	} // cut
	
} // class
