package week2.minj0i;

import java.util.Observable;

public class WeatherData2 extends Observable {
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData2() { }
	
	public void measuremnetsChanged() {
		setChanged();
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity=humidity;
		this.pressure = pressure;
		measuremnetsChanged();
	}
	
	public float getTemperature() {
		return temperature;
	}
	public float getHumidity() {
		return humidity;
	}
	public float getPressure() {
		return pressure;
	}
}
