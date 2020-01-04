package ObserverPattern;

import java.util.ArrayList;

// Subject 인터페이스 구현
public class WeatherData implements Subject{
	/* Observer 객체들을 저장하기 위해 ArrayList를 추가합니다. 
	 * 그리고 생성자에서 그 객체를 생성합니다.*/
	private ArrayList observers;
	
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList();
	}
	
	//옵저버가 등록을 하면 목록 맨 뒤에 추가하기만 하면 됩니다. 
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	//옵저버가 탈퇴를 신청하면 목록에서 빼기만 하면 됩니다.
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i >= 0) {
			observers.remove(i);
		}
	}
	
	//***중요***//
	/* 상태에 대해서 모든 옵저버들한테 알려주는 부분.
	 * 모두 Observer인터페이스를 구현하는, 
	 * 즉, update() 메소드가 있는 객체들이므로 손쉽게 알려줄 수 있습니다. */
	public void notifyObservers(){
		for(int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	// 기상스테이션으부터 갱신된 측정치를 받으면 옵저버들한테 알립니다.
	public void measurementsChanged() {
		notifyObservers();
	}
	
	// 디스플레이 항목 테스트
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
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
