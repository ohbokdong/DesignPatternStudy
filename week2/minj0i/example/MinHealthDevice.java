package week2.minj0i.example;

public class MinHealthDevice {

	public static void main(String[] args) {
		HealthData healthData = new HealthData();
		
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(healthData);
		
		healthData.setMesurements(3, 55.2);
		healthData.setMesurements(5, 56.3);
	}

}
