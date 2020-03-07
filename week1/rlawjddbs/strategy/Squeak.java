package week1.strategy;

public class Squeak implements QuackBehavior{
	@Override
	public void quack() {
		System.out.println("("+this.getClass().getSimpleName()+") »à»à");
	} // quack
} // class
