package week8.minj0i;

public abstract class CaffeinBeverageWithHook {
	void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		if (customerWantsCondiments()) {
			addCondiments();
		}
	}

	abstract void brew();

	abstract void addCondiments();

	void boilWater() {
		System.out.println("물 끓이는 중");
	}

	void pourInCup() {
		System.out.println("컵에 따르는 중");
	}

	boolean customerWantsCondiments() {
		return true;
	}
}
