package week3.decorator.beverage;

public class Mocha extends CondimentDecorator {
	Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	} // basic constructor

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", ¸ğÄ«";
	}

	@Override
	public double cost() {
		return .20 + beverage.cost();
	}

}
