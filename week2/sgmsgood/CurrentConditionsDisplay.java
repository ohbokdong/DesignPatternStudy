package week2.sgmsgood;


/*
 * 1. Observer ����: WeatherData ��ü�κ��� ���� ������ �ޱ� ���ؼ� Observer�� �����մϴ�.
 * 2. DisplayElement ����: API ������ ��� ���÷��� �׸񿡼� DisplayElement�� �����ϱ�� �߱� ������ �� �������̽��� �����մϴ�.*/

public class CurrentConditionsDisplay implements Observer, DisplayElement{
	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	//�����ڿ� weatherData��� ���� ��ü�� ���޵Ǹ�, �� ��ü�� �Ἥ ���÷��̸� �������� ����մϴ�. 
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	//update()�� ȣ��Ǹ� ��°� ������ �����ϰ� display()�� ȣ���մϴ�.
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}
	
	//���� �ֱٿ� ���� ��°� ������ ����մϴ�.
	public void display() {
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
	}
}
