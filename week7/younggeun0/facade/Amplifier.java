package week7.younggeun0.facade;

public class Amplifier {

	public void on() {
		System.out.println("amp on");
	}

	public void setDvd(DvdPlayer dvd) {
		System.out.println("amplifier for dvd set");
		
	}

	public void setSurrondSound() {
		System.out.println("amplifier surround sound set");
	}

	public void setVolume(int i) {
		System.out.println("amplifier volume is "+i);
	}

}
