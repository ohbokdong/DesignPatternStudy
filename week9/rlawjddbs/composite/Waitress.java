package week9.rlawjddbs.composite;

import java.util.Iterator;

public class Waitress {
	MenuComponent allMenus;
	
	public Waitress(MenuComponent allMenus) {
		this.allMenus = allMenus;
	} // basic constructor
	
	public void printMenu() {
		allMenus.print();
	} // printMenu
	
	public void printVegetarianMenu() {
		Iterator iterator = allMenus.createIterator();
		System.out.println("\nVEGETARIAN MENU\n----");
		while(iterator.hasNext()) {
			MenuComponent menuComponent = (MenuComponent)iterator.next();
			try {
				if(menuComponent.isVegetarian()) {
					menuComponent.print();
				} // end if
			} catch (UnsupportedOperationException noe) {}
		} // end while
	} // printVegetarianMenu
} // class
