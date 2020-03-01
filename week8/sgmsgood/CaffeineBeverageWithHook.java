package Templete;

public abstract class CaffeineBeverageWithHook {
	void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		
		/*
		 * customerWantsCondiments()라는 구상 메소드에 의해 실행여부가 결정되는 조건문 추가.
		 * 손님이 첨가물을 넣어달라고 했을 때만, customerWantsCondiments()에서 참이 리턴되면
		 * addCondiments()를 호출합니다.*/
		if(customerWantsCondiments()) {
			addCondiments();
		}
	}
	
	abstract void brew();
	abstract void addCondiments();
	
	void boilWater() {
		System.out.println("물 끓는 중");
	}
	
	void pourInCup() { 
		System.out.println("컵에 따르는 중");
	}
	
	boolean customerWantsCondiments() {
		return true;
	}
}
