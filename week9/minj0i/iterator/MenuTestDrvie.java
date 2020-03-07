package week9.minj0i.iterator;

import week9.minj0i.iterator.DinerMenu2;
import week9.minj0i.iterator.PancakeHouseMenu2;
import week9.minj0i.iterator.Waitress;

public class MenuTestDrvie {
	public static void main(String[] args) {
		PancakeHouseMenu2 pancakeHousMenu = new PancakeHouseMenu2();
		DinerMenu2 dinerMenu = new DinerMenu2();
		
		Waitress waitress = new Waitress(pancakeHousMenu, dinerMenu);
		
		waitress.printMenu();
	}
}
