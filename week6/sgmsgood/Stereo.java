package Command;

public class Stereo {
	String space;
	
	public Stereo (String space) {
		this.space = space;
	}
	public void on() {
		System.out.println(space + " ¿Àµð¿À ÄÑÁü");
	}
	
	public void off() {
		System.out.println(space + " ¿Àµð¿À ²¨Áü");
	}
	
	public void setCD() {
		System.out.println(space + " CD ³ÖÀ½");
	}
	
	public void setDVD() {
		System.out.println(space + " DVD ³ÖÀ½");
	}
	
	public void setRadio() {
		System.out.println(space + " ¶óµð¿À ÄÔ");
	}
	
	public void setVolume(int Value) {
		System.out.println(space + " º¼·ý Á¶Àý");
	}
}
