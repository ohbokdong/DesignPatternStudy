package week2.rlawjddbs.observer.weatherobservable;

public interface Subject {

	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObserver();

} // interface
