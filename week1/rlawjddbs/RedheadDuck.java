package week1;

public class RedheadDuck extends Duck {

	public RedheadDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	} // 기본 생성자 
	
	@Override
	public void display() {
		System.out.println("빨간 머리의 오리");
	} // display
	
} // class
