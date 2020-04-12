package week3.rlawjddbs.decorator.beverage;

public class SteamMilk extends CondimentDecorator {
	Beverage beverage;

	public SteamMilk(Beverage beverage) {
		this.beverage = beverage;
	} // basic constructor

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", ���� ��ũ";
	}

	@Override
	public double cost() {
		return .10 + beverage.cost();
	}

}
