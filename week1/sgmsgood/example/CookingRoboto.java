package Roboto;

public class CookingRoboto extends Roboto {
	
	public CookingRoboto() {
		talkBehavior = new PoliteTalk();
		cookingBehavior = new HighBloodPressureFood();
	}

	@Override
	public void display() {
		System.out.println("설정하신 음식을 로봇의 손맛으로 제공해드립니다.");
	}

}
