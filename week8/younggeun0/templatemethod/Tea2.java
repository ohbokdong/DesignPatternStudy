package week8.younggeun0.templatemethod;

public class Tea2 extends CaffeinBeverage {

	@Override
	void brew() {
		System.out.println("차를 우리는 중");
	}

	@Override
	void addCondiments() {
		System.out.println("설탕과 커피를 추가하는 중");
	}

}
