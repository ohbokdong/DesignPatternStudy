package proxy;

public class RealSubject implements Subject {

	@Override
	public void action1() {
		System.out.println("������ ���� by ����");
	}
	
	@Override
	public void action2() {
		System.out.println("������ ���� by ����");
	}
}
