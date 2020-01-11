package week4.minj0i;

public class CGStyleCheesePizza extends Pizza {
	public CGStyleCheesePizza() {
		name ="Chicago Style Deep Dish Cheese Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
		
		toppings.add("Shredded Mozzarella Cheese");
	}
	
	@Override
	//네모나게 잘라야 되서
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	}

}
