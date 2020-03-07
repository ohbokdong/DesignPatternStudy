package week3.decorator.beverage;

public class Soy extends CondimentDecorator {
	Beverage beverage;

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	} // basic constructor

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", µÎÀ¯";
	}

	@Override
	public double cost() {
		return .15 + beverage.cost();
	}

}
