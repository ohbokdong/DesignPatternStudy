package Command;

public class Light {
	String message;
	
	public Light(String message) {
		this.message = message;
	}
	
	public void on() {
		System.out.println(message + " ºÒ ÄÑÁü");
	}
	
	public void off() {
		System.out.println(message + " ºÒ ²¨Áü");
	}

}
