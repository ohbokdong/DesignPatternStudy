package week9.minj0i.iterator;

public class MenuTestDrvie {
	public static void main(String[] args) {
		PancakeHouseMenu2 pancakeHousMenu = new PancakeHouseMenu2();
		DinerMenu2 dinerMenu = new DinerMenu2();
		
		Waitress waitress = new Waitress(pancakeHousMenu, dinerMenu);
		
		waitress.printMenu();
	}
}
