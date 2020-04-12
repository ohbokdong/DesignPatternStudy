package week1.rlawjddbs.strategy;

public class FlyRocketPowered implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("("+this.getClass().getSimpleName()+") �ǿ���");
	}

}
