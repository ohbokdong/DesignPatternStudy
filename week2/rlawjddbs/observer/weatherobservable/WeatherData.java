package week2.observer.weatherobservable;

import java.util.ArrayList;
import java.util.Observable;

public class WeatherData extends Observable {
	// instance variable
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {

	} // basic constructor

	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	} // measurementsChanged

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	} // setMeasurements

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

	// Other Methods..

} // class
