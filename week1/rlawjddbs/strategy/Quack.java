package week1.rlawjddbs.strategy;

public class Quack implements QuackBehavior{
	@Override
	public void quack() {
		System.out.println("("+this.getClass().getSimpleName()+")  �в�");
	} // quack
} // class
