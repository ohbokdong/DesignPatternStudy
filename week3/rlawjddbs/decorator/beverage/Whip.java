package week3.decorator.beverage;

public class Whip extends CondimentDecorator {
	Beverage beverage;

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	} // basic constructor

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", ÈÖÇÎ Å©¸²";
	}

	@Override
	public double cost() {
		return .10 + beverage.cost();
	}

}
