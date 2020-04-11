package week4.rlawjddbs.factory;

public class NYStyleVeggiePizza extends Pizza {

	public NYStyleVeggiePizza() {
		name = "Chicago Style Sauce and veggie Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
		
		toppings.add("vegetables");
	} // ChicagoStyleVeggiePizza
	
	@Override
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	} // cut
	
} // class
