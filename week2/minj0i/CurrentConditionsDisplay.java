package week2.minj0i;

//Observer : WeatherData 객체로부터 변경사항을 받기 위해서
//DisplayElement : API 구조상 모든 디스플레이 하옥에서 DisplayElement를 구현하기로 했기 때문에
public class CurrentConditionsDisplay implements Observer, DisplayElement{
	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	//weatherData라는 주제 객체가 전달되며, 그 객체를 써서 디스플레이을 옵저버로 등록
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Current conditions: "+temperature + "F degrees and" + humidity + "% humidity");
	}

	
	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}
}
