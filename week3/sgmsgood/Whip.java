package week3.sgmsgood;

public class Whip extends CondimentDecorator{
	
	Beverage beverage;
	
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + "����";
	}

	@Override
	public double cost() {
		return 0.5;
	}

}
