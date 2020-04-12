package week1.rlawjddbs.strategy;

public class MallardDuck extends Duck {

	public MallardDuck() {
		setQuackBehavior(new Quack());
		setFlyBehavior(new FlyWithWings());
	} // basic constructor

	@Override
	public void display() {
		System.out.println("���� �� ���� �Դϴ�.");
	} // display

} // class
