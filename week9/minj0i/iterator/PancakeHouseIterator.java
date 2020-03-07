package week9.minj0i.iterator;

import java.util.ArrayList;

public class PancakeHouseIterator implements Iterator {

	ArrayList<MenuItem> items;
	int position = 0;

	public PancakeHouseIterator(ArrayList<MenuItem> items) {
		this.items = items;
	}

	public MenuItem next() {
		MenuItem item = items.get(position);
		position = position + 1;
		return item;
	}

	public boolean hasNext() {
		if (position >= items.size()) {
			return false;
		} else {
			return true;
		}
	}
}
