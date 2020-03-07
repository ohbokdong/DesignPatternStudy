package week9.minj0i.iterator2;

public class MenuTestDrvie {
	public static void main(String[] args) {
		PancakeHouseMenu3 pancakeHousMenu = new PancakeHouseMenu3();
		DinerMenu3 dinerMenu = new DinerMenu3();
		CafeMenu2 cafeMenu = new CafeMenu2();
		
		Waitress3 waitress = new Waitress3(pancakeHousMenu, dinerMenu, cafeMenu);
		
		waitress.printMenu();
	}
}
