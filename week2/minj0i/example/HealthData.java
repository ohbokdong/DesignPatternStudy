package week2.minj0i.example;

import java.util.ArrayList;
import week2.minj0i.example.Observer;

public class HealthData implements Subject{
	private ArrayList<Observer> observers;
	private int smoke;
	private double weight;
	
	public HealthData() {
		observers = new ArrayList();
	}
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	public void notifyObservers() {
		for (int i = 0; i<observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update(smoke, weight);
		}
	}
	public void measurementsChanged() {
		notifyObservers();
	}
	
	public void setMesurements(int smoke, double weight) {
		this.smoke = smoke;
		this.weight = weight;
		measurementsChanged();
	}
	
}
