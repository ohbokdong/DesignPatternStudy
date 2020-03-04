package week1.strategy;

public class FlyRocketPowered implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("("+this.getClass().getSimpleName()+") ÇÇ¿ì¿ì¿õ");
	}

}
