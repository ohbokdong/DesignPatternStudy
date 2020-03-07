package week9.iterator2;

import java.util.Iterator;

public class Waitress {
	Menu pancakeHouseMenu;
	Menu dinerMenu;
	
	public Waitress(Menu pancakeHouseMenu, Menu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	} // basic constructor
	
	public void printMenu() {
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();
		System.out.println("메뉴\n----\n아침메뉴");
		printMenu(pancakeIterator);
		System.out.println("\n점심메뉴");
		printMenu(dinerIterator);
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
