package week2.younggeun0;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class WeatherData_Observable extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData_Observable() {}
    
    public void measurementChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }

    public float getHumidity() {
        return humidity;
    }
    public float getPressure() {
        return pressure;
    }
    public float getTemperature() {
        return temperature;
    }

}