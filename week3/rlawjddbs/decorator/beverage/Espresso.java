package week3.decorator.beverage;

public class Espresso extends Beverage {

	public Espresso() {
		description = "����������";
	} // basic constructor

	@Override
	public double cost() {
		return 1.99;
	} // cost

} // class
