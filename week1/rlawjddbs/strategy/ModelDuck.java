package week1.strategy;

public class ModelDuck extends Duck {

	public ModelDuck() {
		setQuackBehavior(new MuteQuack());
		setFlyBehavior(new FlyNoWay());
	}

	@Override
	public void display() {
		System.out.println("저는 모형 오리입니다.");
	}



}
