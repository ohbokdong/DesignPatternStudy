package week4.factory;

public class ChicagoStyleVeggiePizza extends Pizza {

	public ChicagoStyleVeggiePizza() {
		name = "Chicago Style Deep Dish Veggie Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";

		toppings.add("Freshhh Vegetables");
	} // NYStyleCheesePizza

	@Override
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	} // cut

} // class
