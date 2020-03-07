package week3.decorator.beverage;

public class SteamMilk extends CondimentDecorator {
	Beverage beverage;

	public SteamMilk(Beverage beverage) {
		this.beverage = beverage;
	} // basic constructor

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", ½ºÆÀ ¹ÐÅ©";
	}

	@Override
	public double cost() {
		return .10 + beverage.cost();
	}

}
