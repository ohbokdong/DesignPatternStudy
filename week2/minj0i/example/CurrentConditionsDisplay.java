package week2.minj0i.example;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private int smoke;
	private double weight;
	private Subject healthData;
	
	public CurrentConditionsDisplay(Subject healthData) {
		this.healthData = healthData;
		healthData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("현재 흡연 :" + smoke + "회, 체중:" + weight + "kg" );
	}

	@Override
	public void update(int smoke, double weight) {
		this.smoke = smoke;
		this.weight = weight;
		display();
	}
	
	
}
