package week4.rlawjddbs.factory;

public class NYStylePepperoniPizza extends Pizza {

	public NYStylePepperoniPizza() {
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
