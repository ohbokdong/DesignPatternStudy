package week1.strategy;

public class DecoyDuck extends Duck {

	public DecoyDuck() {
		setQuackBehavior(new MuteQuack());
		setFlyBehavior(new FlyNoWay());
	}

	@Override
	public void display() {
		System.out.println("저는 가짜 오리입니다.");
	}

}
