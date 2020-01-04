package week1.minj0i.example;

public abstract class People {
	
	SleepBehavior sleepBehavior;
	EatBehavior eatBehavior;
	
	public People() {	
	}
	
	public abstract void display();
	
	public void performSleep() {
		sleepBehavior.sleep();
	}
	
	public void performEat() {
		eatBehavior.eat();
	}
	
	public void smile() {
		System.out.println("모든 사람은 웃어요.");
	}
	
	public void setSleepBehavior(SleepBehavior sb) {
		sleepBehavior = sb;
	}
	
	public void setEatBehavior(EatBehavior eb) {
		eatBehavior = eb;
	}
	
}
