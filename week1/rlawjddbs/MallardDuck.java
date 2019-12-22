package week1;

public class MallardDuck extends Duck {

	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	} // 기본 생성자
	
	@Override
	public void display() {
		System.out.println("나는 물오리!");
	} // display
	
} // class
