package week1.strategy;

public class RedheadDuck extends Duck {

	public RedheadDuck() {
		setQuackBehavior(new Quack());
		setFlyBehavior(new FlyWithWings());
	}

	@Override
	public void display() {
		System.out.println("저는 붉은머리 오리입니다.");
	}

}
