package week9.iterator3;

import java.util.Iterator;

public class Waitress {
	Menu pancakeHouseMenu;
	Menu dinerMenu;
	Menu cafeMenu;
	
	public Waitress(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
		this.cafeMenu = cafeMenu;
	} // basic constructor
	
	public void printMenu() {
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();
		Iterator cafeIterator = cafeMenu.createIterator();
		System.out.println("메뉴\n----\n아침메뉴");
		printMenu(pancakeIterator);
		System.out.println("\n점심메뉴");
		printMenu(dinerIterator);
		System.out.println("\n저녁메뉴");
		printMenu(cafeIterator);
	} // printMenu
	
	// 외부 반복자 : 클라이언트(Waitress 객체)가 next()를 제어하는 경우
	private void printMenu(Iterator iterator) {
		while(iterator.hasNext()) {
			MenuItem menuItem = (MenuItem)iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		} // end while
	} // printMenu

	// other methods...
} // class
