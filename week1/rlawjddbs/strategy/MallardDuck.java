package week1.strategy;

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
