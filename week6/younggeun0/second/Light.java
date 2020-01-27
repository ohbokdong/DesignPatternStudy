package week6.younggeun0.second;

public class Light {
	
	public String sight;
	
	public Light(String sight) {
		this.sight = sight;
	}
	
	public void on() {
		System.out.println(sight +" Light is on");
	}
	public void off() {
		System.out.println(sight + " Light is off");
	}
}
