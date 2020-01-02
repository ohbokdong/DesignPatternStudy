package week3.minj0i;

public class Whip extends CondimentDecorator {
	Beverage beverage;
	
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		return beverage.getDescription() + ", 휘핑";
	}
	
	public double cost() {
		return .10 + beverage.cost();
	}
}
