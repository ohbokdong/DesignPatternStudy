package week4;

import java.util.ArrayList;

public abstract class Pizza2 {
	
	String name;
	Dough dough;
	Sauce sauce;
	Veggies veggies[];
	Cheese cheese;
	Pepperoni pepperoni;
	Clams clam;
	
	abstract void prepare();
	
	ArrayList<String> toppings = new ArrayList<String>();
	
	void bake() {
		System.out.println("Bake for 25 minutes at 350");
	} // bake
	
	void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	} // cut
	
	void box() {
		System.out.println("Place pizza in official PizzaStore box");
	} // box
	
	void setName(String name) {
		this.name = name;
	} // setName
	
	public String getName() {
		return name;
	} // getName
	
	public String toString() {
		// 피자 이름을 출력하는 부분
		return null;
	} // toString
	
} // abstract class
