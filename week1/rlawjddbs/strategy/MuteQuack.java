package week1.strategy;

public class MuteQuack implements QuackBehavior{
	@Override
	public void quack() {
		System.out.println("("+this.getClass().getSimpleName()+") 저는 소리를 못 냅니다.");
	} // quack
} // class
