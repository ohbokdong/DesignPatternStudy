package week4.rlawjddbs.factory;

import java.util.ArrayList;

public abstract class Pizza {
	
	String name;
	String dough;
	String sauce;
	ArrayList<String> toppings = new ArrayList<String>();
	
	void prepare() {
		System.out.println("Preparing " + name);
		System.out.println("Tossing dough...");
		System.out.println("Adding sauce...");
		System.out.println("Adding toppings : ");
		for(int i = 0; i < toppings.size(); i ++) {
			System.out.println("   " + toppings.get(i));
		} // end for
	} // prepare
	
	void bake() {
		System.out.println("Bake for 25 minutes at 350");
	} // bake
	
	void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	} // cut
	
	void box() {
		System.out.println("Place pizza in official PizzaStore box");
	} // box
	
	public String getName() {
		return name;
	} // getName
	
} // abstract class
