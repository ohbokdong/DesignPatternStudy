package week8.younggeun0.templatemethod;

public class Coffee2 extends CaffeinBeverage {

	@Override
	void brew() {
		System.out.println("커피 우리는 중");
	}

	@Override
	void addCondiments() {
		System.out.println("설탕과 우유를 추가하는 중");
	}

}
