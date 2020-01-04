package week1.minj0i.example;

public class YoungGeun extends People {
	public YoungGeun() {
		eatBehavior = new EatVegi();
		sleepBehavior = new SleepAtNight();
	}

	public void display( ) {
		System.out.println("저는 안경없이 살 수 있어요.");
	}
}
