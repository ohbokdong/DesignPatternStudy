package Templete;

public class Tea extends CaffeineBeverage {
	@Override
	void brew() {
		System.out.println("���� ������� ��");
	}

	@Override
	void addCondiments() {
		System.out.println("������ �߰��ϴ� ��");
	}
}
