package week4.factory;

public class ChicagoStyleClamPizza extends Pizza {

	public ChicagoStyleClamPizza() {
		name = "Chicago Style Deep Dish Clam Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";

		toppings.add("Alaska Clams");
	} // NYStyleCheesePizza

	@Override
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	} // cut

} // class
