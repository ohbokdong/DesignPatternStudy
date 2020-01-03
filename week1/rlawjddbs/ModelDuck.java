package week1;

public class ModelDuck extends Duck {

	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	} // 기본 생성자
	
	@Override
	public void display() {
		System.out.println("저는 모형 오리입니다.");
	}// display

} // class
