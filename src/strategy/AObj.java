package strategy;

public class AObj {
	
	Ainterface ainterface;
	
	public AObj() {
		ainterface = new AinterfaceImpl();
	}

	public void funcAA() {
		
		// � ����� ������ �� �� å����
		// �ٸ� ��ü���� ���ѱ�� ��
		// �ٸ� ��ü�� ����� ����ϴ� �� = �����Ѵ�.
		
		ainterface.funcA();
		ainterface.funcA();
		
//		System.out.println("AAA");
//		System.out.println("AAA");
		
		// ~����� �ʿ��մϴ�. �������ּ���.
		
	}
}
