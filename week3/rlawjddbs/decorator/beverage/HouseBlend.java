package week3.decorator.beverage;

public class HouseBlend extends Beverage {

	public HouseBlend() {
		description = "하우스 블렌드 커피";
	} // basic constructor

	@Override
	public double cost() {
		return .89;
	} // cost

} // class
