package week1.strategy;

public class MuteQuack implements QuackBehavior{
	@Override
	public void quack() {
		System.out.println("("+this.getClass().getSimpleName()+") ���� �Ҹ��� �� ���ϴ�.");
	} // quack
} // class
