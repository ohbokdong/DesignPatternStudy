package week1.sgmsgood.example;

public class CookingRoboto extends Roboto {
	
	public CookingRoboto() {
		talkBehavior = new PoliteTalk();
		cookingBehavior = new HighBloodPressureFood();
	}

	@Override
	public void display() {
		System.out.println("�����Ͻ� ������ �κ��� �ո����� �����ص帳�ϴ�.");
	}

}
