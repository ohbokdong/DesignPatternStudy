package singleton_review0527;

public class Main {

	public static void main(String[] args) {
		
		// 货肺 积己, 捞固 积己
		SystemSpeaker sp1 = SystemSpeaker.getInstance();
		SystemSpeaker sp2 = SystemSpeaker.getInstance();
		
		// 5, 5
		System.out.println(sp1.getVolume());
		System.out.println(sp2.getVolume());
		
		sp1.setVolume(10);
		
		System.out.println(sp1.getVolume());
		System.out.println(sp2.getVolume());
	}
}
