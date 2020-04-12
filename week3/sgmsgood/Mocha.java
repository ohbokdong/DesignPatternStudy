package week3.sgmsgood;

public class Mocha extends CondimentDecorator {
	
	Beverage beverage;
	
	public Mocha (Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + "��ī";
	}

	@Override
	public double cost() {
		return .20 +  beverage.cost();
	}

}
