package week4.rlawjddbs.factory;

public class NYStyleClamPizza extends Pizza {

	public NYStyleClamPizza() {
		name = "Chicago Style Sauce and Clam Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
		
		toppings.add("Clam");
	}
	
	@Override
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	} // cut
	
} // class
