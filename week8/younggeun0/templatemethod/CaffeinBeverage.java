package week8.younggeun0.templatemethod;

public abstract class CaffeinBeverage {
	
	final void prepareRecipe() { 
		// 아무렇게나 음료를 만들지 못하도록(오버라이드를 막기 위해) 공통 로직은 final로 선언
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}
	
	// 서브클래스에서 알아서 각자 구현
	abstract void brew();
	abstract void addCondiments();
	
	void boilWater() {
		System.out.println("물 끓이는 중");
	}
	void pourInCup() {
		System.out.println("컵에 따르는 중");
	}
}
