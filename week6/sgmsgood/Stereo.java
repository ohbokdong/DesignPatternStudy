package week6.sgmsgood;

public class Stereo {
	String space;
	
	public Stereo (String space) {
		this.space = space;
	}
	public void on() {
		System.out.println(space + " ����� ����");
	}
	
	public void off() {
		System.out.println(space + " ����� ����");
	}
	
	public void setCD() {
		System.out.println(space + " CD ����");
	}
	
	public void setDVD() {
		System.out.println(space + " DVD ����");
	}
	
	public void setRadio() {
		System.out.println(space + " ���� ��");
	}
	
	public void setVolume(int Value) {
		System.out.println(space + " ���� ����");
	}
}
