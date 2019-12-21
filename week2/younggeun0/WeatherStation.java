package week2.younggeun0;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
    
        // 옵저버에 주제 설정
        CurrentConditionsDisplay cd = new CurrentConditionsDisplay(weatherData);
        StatisticDisplay sd = new StatisticDisplay(weatherData);
        ForecastDisplay fd = new ForecastDisplay(weatherData);
    
        // 주제에서 설정하여 값이 변경 시 옵저버들 update함수가 자동 호출됨
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }

}