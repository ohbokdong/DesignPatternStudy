package week9.younggeun0.iterator;

import java.util.ArrayList;

public class PancakeHouseIterator implements Iterator {
	
	ArrayList<MenuItem> menuItems;
	public PancakeHouseIterator(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
	@Override
	public Object next() {
		MenuItem menuItem = menuItems.get(0);
		menuItems.remove(menuItem);		
		return menuItem;
	}
	
	@Override
	public boolean hasNext() {
		if (menuItems.size() != 0) {
			return true;
		} else {
			return false;
		}
	}
}
