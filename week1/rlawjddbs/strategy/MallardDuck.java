package week1.strategy;

public class MallardDuck extends Duck {

	public MallardDuck() {
		setQuackBehavior(new Quack());
		setFlyBehavior(new FlyWithWings());
	} // basic constructor

	@Override
	public void display() {
		System.out.println("저는 물 오리 입니다.");
	} // display

} // class
