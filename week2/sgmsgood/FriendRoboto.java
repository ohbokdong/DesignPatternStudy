package Roboto;

public class FriendRoboto extends Roboto {
	
	public FriendRoboto() {
		talkBehavior = new FriendlyTalk();
		cookingBehavior = new HealthyFood();
	}

	@Override
	public void display() {
		System.out.println("인생은 혼자라지만 당신의 영원한 친구가 되어드릴게요.");

	}

}
