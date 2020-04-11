package week1.rlawjddbs.strategy;

public abstract class Duck {
	private QuackBehavior qb;
	private FlyBehavior fb;

	public abstract void display();

	public void performQuack() {
		System.out.print(this.getClass().getSimpleName()+" : ");
		qb.quack();
	} // performQuack

	public void performFly() {
		System.out.print(this.getClass().getSimpleName()+" : ");
		fb.fly();
	} // performFly

	public void swim() {
		System.out.println(this.getClass().getSimpleName()+" : ��� ������ ���� ��ϴ�.");
	} // swim

	public void setQuackBehavior(QuackBehavior qb) {
		this.qb = qb;
	} // setQuack

	public void setFlyBehavior(FlyBehavior fb) {
		this.fb = fb;
	} // setFly

} // class
