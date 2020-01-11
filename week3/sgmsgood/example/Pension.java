package PensionReserve;

public abstract class Pension {
	String description;
	
	public String getDescription() {
		return description;
	}
	
	public abstract int cost();	
}
