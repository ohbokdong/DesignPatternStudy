package FactoryPattern;

import java.util.ArrayList;

public class Pizza {
	String name;
	String dough;
	String sauce;
	ArrayList<String> toppings = new ArrayList<String>();

	public String getName() {
		return name;
	}

	void prepare() {
		System.out.println("Preparing " + name);
	}

	void bake() {
		System.out.println("Baking " + name);
	}

	void cut() {
		System.out.println("Cutting " + name);
	}

	void box() {
		System.out.println("Boxing " + name);
	}

	public String toString() {
		// code to display pizza name and ingredients
		StringBuffer display = new StringBuffer();
		display.append("---- " + name + " ----\n");
		display.append(dough + "\n");
		display.append(sauce + "\n");
		for (String topping : toppings) {
			display.append(topping + "\n");
		}
		return display.toString();
	}
}
