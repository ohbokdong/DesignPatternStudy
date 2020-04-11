package week1.rlawjddbs.strategy;

public class Squeak implements QuackBehavior{
	@Override
	public void quack() {
		System.out.println("("+this.getClass().getSimpleName()+") ���");
	} // quack
} // class
