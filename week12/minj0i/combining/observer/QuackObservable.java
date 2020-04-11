package week12.minj0i.combining.observer;

public interface QuackObservable {
	public void registerObserver(Observer observer);
	public void notifyObservers();
}
