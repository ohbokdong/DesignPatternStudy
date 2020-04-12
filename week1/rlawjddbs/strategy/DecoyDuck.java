package week1.rlawjddbs.strategy;

public class DecoyDuck extends Duck {

	public DecoyDuck() {
		setQuackBehavior(new MuteQuack());
		setFlyBehavior(new FlyNoWay());
	}

	@Override
	public void display() {
		System.out.println("���� ��¥ �����Դϴ�.");
	}

}
