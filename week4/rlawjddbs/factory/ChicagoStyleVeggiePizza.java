package week4;

public class ChicagoStyleVeggiePizza extends Pizza {

	public ChicagoStyleVeggiePizza() {
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
