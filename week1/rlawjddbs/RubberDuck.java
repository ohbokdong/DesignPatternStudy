package week1;

public class RubberDuck extends Duck {

	public RubberDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	} // 기본 생성자

	@Override
	public void display() {
		System.out.println("나는 고무오리 입니다.");
	} // display
	
} // class
