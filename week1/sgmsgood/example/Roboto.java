package week1.sgmsgood.example;

public abstract class Roboto {
	
	CookingBehavior cookingBehavior;
	TalkBehavior talkBehavior;

	public Roboto() {
		
	}
	
	public abstract void display();
	
	public void performCook() {
		cookingBehavior.cook();
	}
	
	public void performTalk() {
		talkBehavior.Talk();
	}
	
	public void charge() {
		System.out.println("��� �κ��� ���⿡������ �ʿ�� �մϴ�.");
	}
	
}
