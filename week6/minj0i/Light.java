package week6.minj0i;

public class Light {
	public String sight;
	
	public Light(String sight) {
		this.sight = sight;
	}
	public void on() {
		System.out.println(sight + " Light is on");
	}
	public void off() {
		System.out.println(sight+ " Light is off");
	}
}
