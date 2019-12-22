package Roboto;

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
		System.out.println("모든 로봇은 전기에너지를 필요로 합니다.");
	}
	
}
