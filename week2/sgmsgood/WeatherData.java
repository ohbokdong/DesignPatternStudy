package week2.sgmsgood;

import java.util.ArrayList;

// Subject �������̽� ����
public class WeatherData implements Subject{
	/* Observer ��ü���� �����ϱ� ���� ArrayList�� �߰��մϴ�. 
	 * �׸��� �����ڿ��� �� ��ü�� �����մϴ�.*/
	private ArrayList observers;
	
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList();
	}
	
	//�������� ����� �ϸ� ��� �� �ڿ� �߰��ϱ⸸ �ϸ� �˴ϴ�. 
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	//�������� Ż�� ��û�ϸ� ��Ͽ��� ���⸸ �ϸ� �˴ϴ�.
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i >= 0) {
			observers.remove(i);
		}
	}
	
	//***�߿�***//
	/* ���¿� ���ؼ� ��� ������������ �˷��ִ� �κ�.
	 * ��� Observer�������̽��� �����ϴ�, 
	 * ��, update() �޼ҵ尡 �ִ� ��ü���̹Ƿ� �ս��� �˷��� �� �ֽ��ϴ�. */
	public void notifyObservers(){
		for(int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	// ������̼������� ���ŵ� ����ġ�� ������ ������������ �˸��ϴ�.
	public void measurementsChanged() {
		notifyObservers();
	}
	
	// ���÷��� �׸� �׽�Ʈ
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
