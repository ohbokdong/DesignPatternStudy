package week9.younggeun0.iterator;

import java.util.Iterator;

public class Waitress2 {
	Menu pancakeHouseMenu;
	Menu dinerMenu;
	
	public Waitress2(Menu pancakeHouseMenu, Menu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}
	
	public void printMenu() {
		Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
		System.out.println("메뉴\n---\n아침 메뉴");
		
		// 각 반복자를 가지고 오버로드된 printMenu 메소드를 호출 
		printMenu(pancakeIterator);
		System.out.println("\n점심 메뉴");
		printMenu(dinerIterator);
	}
	
	public void printMenu(Iterator iterator) {
		while (iterator.hasNext()) { // 이제 반복문이 한번만 있으면 됨
			MenuItem menuItem = (MenuItem)iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}
}
