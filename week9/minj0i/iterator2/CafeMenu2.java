package week9.minj0i.iterator2;

import java.util.Hashtable;
import java.util.Iterator;

import week9.minj0i.iterator.MenuItem;

public class CafeMenu2 implements Menu {
	Hashtable menuItems = new Hashtable();
	
	public CafeMenu2() {
		
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.put(menuItem.getName(), menuItem);
	}
	
	@Override
	public Iterator createIterator() {
		return menuItems.values().iterator();
	}
	
}
