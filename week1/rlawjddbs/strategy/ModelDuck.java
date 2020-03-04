package week1.strategy;

public class ModelDuck extends Duck {

	public ModelDuck() {
		setQuackBehavior(new MuteQuack());
		setFlyBehavior(new FlyNoWay());
	}

	@Override
	public void display() {
		System.out.println("���� ���� �����Դϴ�.");
	}



}
