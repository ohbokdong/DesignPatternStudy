package week2.rlawjddbs.observer.weatherobservable;

public class CurrentConditionsDisplay2 implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private Subject weatherData;

	public CurrentConditionsDisplay2(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	} // basic constructor

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	} // update

	@Override
	public void display() {
		System.out.println("Current conditions : " + temperature + "F degrees and " + humidity + "% humidity");
	} // display

} // interface
