package week3.rlawjddbs.decorator.beverage;

public class Decaf extends Beverage {

	public Decaf() {
		description = "��ī���� Ŀ��";
	} // basic constructor

	@Override
	public double cost() {
		return 1.05;
	} // cost

} // class
