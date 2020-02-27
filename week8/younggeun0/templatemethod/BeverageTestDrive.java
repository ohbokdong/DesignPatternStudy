package week8.younggeun0.templatemethod;

public class BeverageTestDrive {
	
	public static void main(String[] args) {
		CoffeeWithHook cwh = new CoffeeWithHook();
		
		System.out.println("커피 준비중");
		cwh.prepareRecipe();
	}

}
