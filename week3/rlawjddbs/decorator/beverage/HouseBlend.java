package week3.decorator.beverage;

public class HouseBlend extends Beverage {

	public HouseBlend() {
		description = "�Ͽ콺 ���� Ŀ��";
	} // basic constructor

	@Override
	public double cost() {
		return .89;
	} // cost

} // class
