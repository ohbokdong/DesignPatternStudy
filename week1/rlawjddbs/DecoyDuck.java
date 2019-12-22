package week1;

public class DecoyDuck extends Duck {

	public DecoyDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new MuteQuack();
	} // DecoyDuck

	@Override
	public void display() {
		System.out.println("나는 가짜오리 입니다.");
	} // display
	
} // class
