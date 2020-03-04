package week1.strategy;

public class RubberDuck extends Duck {

	public RubberDuck() {
		setQuackBehavior(new Squeak());
		setFlyBehavior(new FlyNoWay());
	}

	@Override
	public void display() {
		System.out.println("���� �� �����Դϴ�.");
	}

}
