package week9.iterator3;

import java.util.ArrayList;
import java.util.Iterator;

public class Waitress2 {
	ArrayList menus;
	
	public Waitress2(ArrayList menus) {
		this.menus = menus;
	} // basic constructor

	public void printMenu() {
		Iterator menuIterator = menus.iterator();
		while(menuIterator.hasNext()) {
			Menu menu = (Menu)menuIterator.next();
			printMenu(menu.createIterator());
		} // end while
	} // printMenu
	
	// 외부 반복자 : 클라이언트(여기서는 Waitress 객체)가 next()를 제어하는 Iterator
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
