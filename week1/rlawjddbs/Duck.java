package week1;

public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	public Duck() {
		
	} // 기본 생성자

	public abstract void display(); // display(abstract)
	
	public void swim() {
		System.out.println("둥실둥실");
	} // swim
	
	public void performFly() {
		flyBehavior.fly();
	} // performFly
	public void performQuack() {
		quackBehavior.quack();
	} // performQuack
	
	public void setFlyBehavior(FlyBehavior flyBehavior){
		this.flyBehavior = flyBehavior;
	} // setFlyBehavior
	
	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	} // setQuackBehavior
	
} // class
