package strategy_review0525;

public class AObj {

	Ainterface ainter;
	
	public AObj() {
		ainter = new AinterfaceImpl();
	}
	
	public void funcAA() {
		
		// 어떤 기능을 구현할 때 그 책임을
		// 다른 객체에게 떠 넘기는 것
		// 다른 객체의 기능을 사용 = 위임
		
		ainter.funcA();
		ainter.funcA();
		
	}
}
