package week1.strategy;

public class Quack implements QuackBehavior{
	@Override
	public void quack() {
		System.out.println("("+this.getClass().getSimpleName()+")  ²Ð²Ð");
	} // quack
} // class
