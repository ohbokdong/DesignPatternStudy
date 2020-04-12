package week1.sgmsgood.example;

public class FriendRoboto extends Roboto {
	
	public FriendRoboto() {
		talkBehavior = new FriendlyTalk();
		cookingBehavior = new HealthyFood();
	}

	@Override
	public void display() {
		System.out.println("�λ��� ȥ�ڶ����� ����� ������ ģ���� �Ǿ�帱�Կ�.");

	}

}
