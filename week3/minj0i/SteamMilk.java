package week3.minj0i;

public class SteamMilk extends CondimentDecorator {
	Beverage beverage;
	
	public SteamMilk(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		return beverage.getDescription() + ", 스팀밀크";
	}
	
	public double cost() {
		return .10 + beverage.cost();
	}
}
