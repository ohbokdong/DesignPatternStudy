package week9.younggeun0.composite;

import java.util.Iterator;

public class Waitress {
	MenuComponent allMenus;
	
	public Waitress(MenuComponent allMenus) {
		this.allMenus = allMenus;
	}
	
	public void printMenu() {
		allMenus.print();
	}
	
	public void printVegetarianMenu() {
		Iterator<MenuComponent> iterator = allMenus.createIterator();
		System.out.println("\n채식주의자 메뉴\n----");
		while(iterator.hasNext()) {
			MenuComponent menuComp = (MenuComponent)iterator.next();
			try {
				if (menuComp.isVegetarian()) {
					menuComp.print();
				}
			} catch (UnsupportedOperationException e) {
			}
		}
	}
}
