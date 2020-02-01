package week5.minj0i;

public class Singleton {
	private static Singleton uniqueInstance;
	
	//기타 인스턴스 변수 
	
	private Singleton() {}
	
	public static synchronized Singleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
}
