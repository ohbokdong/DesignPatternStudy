package Singleton;

public class Singleton {
	//Singleton 클래스의 유일한 인스턴스를 저장하기 위한 정적 변수
	private static Singleton uniqueInstance;
	
	//생성자를 private로 선언했기 때문에 Singleton에서만 클래스의 인스턴스를 만들 수 있습니다.
	private Singleton() {}
	
	//getInstance() 메소드에서는 클래스의 인스턴으를 만들어 리턴해줍니다.
	public static Singleton getInstance() {
		
		//인스턴스가 필요한 상황이 닥치기 전까지는 아예 인스턴스를 생성하지 않습니다.'lazy instantiation'이라고 부릅니다.
		if(uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
}
