package week2.rlawjddbs.observer.weatherobservable;

import java.util.ArrayList;

public class WeatherData2 implements Subject {
	// instance variable
	private ArrayList observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData2() {
		observers = new ArrayList();
	} // basic constructor

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	} // registerObserver

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i >= 0) {
			observers.remove(i);
		} // end if
	} // removeObserver

	@Override
	public void notifyObserver() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update(temperature, humidity, pressure);
		} // end for
	}

	public void measurementsChanged() {
		notifyObserver();
	} // measurementsChanged

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	} // setMeasurements

	// Other Methods..

} // class
