package week8.sgmsgood;

public abstract class CaffeineBeverageWithHook {
	void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		
		/*
		 * customerWantsCondiments()��� ���� �޼ҵ忡 ���� ���࿩�ΰ� �����Ǵ� ���ǹ� �߰�.
		 * �մ��� ÷������ �־�޶�� ���� ����, customerWantsCondiments()���� ���� ���ϵǸ�
		 * addCondiments()�� ȣ���մϴ�.*/
		if(customerWantsCondiments()) {
			addCondiments();
		}
	}
	
	abstract void brew();
	abstract void addCondiments();
	
	void boilWater() {
		System.out.println("�� ���� ��");
	}
	
	void pourInCup() { 
		System.out.println("�ſ� ������ ��");
	}
	
	boolean customerWantsCondiments() {
		return true;
	}
}
