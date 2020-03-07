package week3.decorator.beverage;

public class DarkRoast extends Beverage {

	public DarkRoast() {
		description = "다크 로스트 커피";
	} // basic constructor

	@Override
	public double cost() {
		return .99;
	} // cost

} // class
