package week5.minj0i;

public class Singleton2 {
	private volatile static Singleton2 uniqueInstance = new Singleton2();

	private Singleton2() {
	}

	public static Singleton2 getInstance() {
		if (uniqueInstance == null) {
			synchronized (Singleton2.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Singleton2();
				}
			}
		}
		return uniqueInstance;
	}
}
