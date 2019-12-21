package week2.younggeun0;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay_Observer implements Observer, DisplayElement{
    private float temperature;
    private float humidity;
    private float pressure;
    private Observable observable;

    public CurrentConditionsDisplay_Observer(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData_Observable) {
            WeatherData_Observable wdo = (WeatherData_Observable)obs;
            this.temperature = wdo.getTemperature();
            this.humidity = wdo.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current conditions : "+temperature + "F degrees and "
            + humidity + "% humidity");
    }
}