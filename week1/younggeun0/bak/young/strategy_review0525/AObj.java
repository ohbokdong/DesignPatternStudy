package strategy_review0525;

public class AObj {

	Ainterface ainter;
	
	public AObj() {
		ainter = new AinterfaceImpl();
	}
	
	public void funcAA() {
		
		// � ����� ������ �� �� å����
		// �ٸ� ��ü���� �� �ѱ�� ��
		// �ٸ� ��ü�� ����� ��� = ����
		
		ainter.funcA();
		ainter.funcA();
		
	}
}
