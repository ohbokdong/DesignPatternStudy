package singletonn;

public class SystemSpeaker {

	static private SystemSpeaker instance;
	private int volume;
	
	private SystemSpeaker() {
		volume = 5;
	}
	
	public static SystemSpeaker getInstance() {
		if (instance == null) {
			instance = new SystemSpeaker();
			System.out.println("货肺 积己");
		} else {
			System.out.println("捞固 积己");
		}
		
		return instance;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
}
