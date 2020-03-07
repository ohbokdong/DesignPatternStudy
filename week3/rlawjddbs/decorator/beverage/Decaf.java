package week3.decorator.beverage;

public class Decaf extends Beverage {

	public Decaf() {
		description = "디카페인 커피";
	} // basic constructor

	@Override
	public double cost() {
		return 1.05;
	} // cost

} // class
