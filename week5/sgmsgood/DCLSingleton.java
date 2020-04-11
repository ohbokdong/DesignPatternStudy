package week5.sgmsgood;

public class DCLSingleton {
	private volatile static DCLSingleton uniqueInstance;
	
	private DCLSingleton() {}
	
	public static DCLSingleton getInstance() {
		if(uniqueInstance == null) {
			synchronized(Singleton.class) {
				if(uniqueInstance == null) {
					uniqueInstance = new DCLSingleton();
				}
			}
		}
		return uniqueInstance;
	}
}
