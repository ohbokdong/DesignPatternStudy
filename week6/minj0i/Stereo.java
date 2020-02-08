package week6.minj0i;

public class Stereo {
	public String sight;
	
	public Stereo(String sight) {
		this.sight = sight;
	}
	
	public void on() {
		System.out.println(sight + " Stereo is on");
	}
	
	public void off() {
		System.out.println(sight + " Stereo is off");
	}
	
	public void setCD() {
		System.out.println("Cd is set");
	}
	
	public void setDVD() {
		System.out.println("Dvd is set");
	}
	
	public void setRadio() {
		System.out.println("Radio is set");
	}
	
	public void setVolume(int level) {
		System.out.println("Volume is set by "+level);
	}
}
