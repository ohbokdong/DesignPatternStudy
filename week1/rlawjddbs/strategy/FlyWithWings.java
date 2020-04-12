package week1.rlawjddbs.strategy;

public class FlyWithWings implements FlyBehavior{
	@Override
	public void fly() {
		System.out.println("("+this.getClass().getSimpleName()+") �Ĵ��Ĵ�");
	} // fly
} // class
