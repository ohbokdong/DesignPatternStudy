package week1.minj0i.example;

public class JungYun extends People {
	public JungYun() {
		eatBehavior = new EatMeat();
		sleepBehavior = new SleepAtMorning();
	}
	
	public void display() {
		System.out.println("저는 안경을 썼어요.");
	}
}
