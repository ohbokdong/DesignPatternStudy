package week3.decorator.beverage;

public class DarkRoast extends Beverage {

	public DarkRoast() {
		description = "��ũ �ν�Ʈ Ŀ��";
	} // basic constructor

	@Override
	public double cost() {
		return .99;
	} // cost

} // class
