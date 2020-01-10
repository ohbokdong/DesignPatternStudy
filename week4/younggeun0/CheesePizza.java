package week4.younggeun0;

public class CheesePizza extends Pizza2 {
	PizzaIngredientFactory ingredientFactory;
	
	// 피자 원재료를 생산하는 팩토리를 생성자로 전달받아 인스턴스 변수로 저장
	public CheesePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
	
	@Override
	void prepare() {
		System.out.println("준비중 " + name);
		// 필요한 재료를 팩토리 메소드를 호출해서 만들어 옴
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
	}
}
