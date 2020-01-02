package week3.practice;

public class Decafe extends Beverage {
	
	public Decafe() {
		description = "디카페인";
	}
	
	@Override
	public double cost() {
		return 2.20;
	}
}
