package week1.rlawjddbs.strategy;

public class RedheadDuck extends Duck {

	public RedheadDuck() {
		setQuackBehavior(new Quack());
		setFlyBehavior(new FlyWithWings());
	}

	@Override
	public void display() {
		System.out.println("���� �����Ӹ� �����Դϴ�.");
	}

}
