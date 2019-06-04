package facade;

public class Application {

	public static void main(String[] args) {
		
		Facade facade = new Facade();
		
		// 서브 시스템들의 복잡한 과정을 생각하지 않고 바로 사용할 수 있는 패턴
		facade.process();
	}
}
