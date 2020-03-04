package week1.strategy;

public class FlyNoWay implements FlyBehavior{
	@Override
	public void fly() {
		System.out.println("("+this.getClass().getSimpleName()+") 저는 날 수 없어요");
	} // fly
} // class
