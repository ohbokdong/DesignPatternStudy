package week3.minj0i;

public class Soy extends CondimentDecorator {
	Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		return beverage.getDescription() + ", 두유";
	}
	
	public double cost() {
		return .15 + beverage.cost();
	}
}
