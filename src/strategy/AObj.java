package strategy;

public class AObj {
	
	Ainterface ainterface;
	
	public AObj() {
		ainterface = new AinterfaceImpl();
	}

	public void funcAA() {
		
		// 어떤 기능을 구현할 때 그 책임을
		// 다른 객체에게 떠넘기는 것
		// 다른 객체의 기능을 사용하는 것 = 위임한다.
		
		ainterface.funcA();
		ainterface.funcA();
		
//		System.out.println("AAA");
//		System.out.println("AAA");
		
		// ~기능이 필요합니다. 개발해주세요.
		
	}
}
