package week3.rlawjddbs.decorator.beverage;

public class Mocha extends CondimentDecorator {
	Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	} // basic constructor

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", ��ī";
	}

	@Override
	public double cost() {
		return .20 + beverage.cost();
	}

}
