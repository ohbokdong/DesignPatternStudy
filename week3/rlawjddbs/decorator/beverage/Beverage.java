package week3.decorator.beverage;

public abstract class Beverage {
	String description = "���� ����";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
} // class
