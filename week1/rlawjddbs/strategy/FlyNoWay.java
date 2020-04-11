package week1.rlawjddbs.strategy;

public class FlyNoWay implements FlyBehavior{
	@Override
	public void fly() {
		System.out.println("("+this.getClass().getSimpleName()+") ���� �� �� �����");
	} // fly
} // class
