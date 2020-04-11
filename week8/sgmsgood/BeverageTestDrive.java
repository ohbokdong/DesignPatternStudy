package week8.sgmsgood;

public class BeverageTestDrive {
	public static void main(String[] args) {
		TeaWithHook teaHook = new TeaWithHook();
		CoffeeWithHook coffeeHook = new CoffeeWithHook();
		
		System.out.println("\n�� �غ���...");
		teaHook.prepareRecipe();
		
		System.out.println("\nĿ�� �غ���...");
		coffeeHook.prepareRecipe();
	}
}
