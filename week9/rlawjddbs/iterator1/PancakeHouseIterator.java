package week9.iterator1;

import java.util.ArrayList;

public class PancakeHouseIterator implements Iterator {
	ArrayList items;
	int position = 0;
	
	public PancakeHouseIterator(ArrayList items) {
		this.items = items;
	} // basic constructor

	@Override
	public boolean hasNext() {
		if (position >= items.size() || items.get(position) == null) {
			return false;
		} else {
			return true;
		} // end else
	} // hasNext

	@Override
	public Object next() {
		MenuItem menuItem = (MenuItem)items.get(position);
		position = position + 1;
		return menuItem;
	} // next

} // class
