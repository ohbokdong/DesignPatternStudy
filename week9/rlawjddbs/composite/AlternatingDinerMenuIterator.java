package week9.rlawjddbs.composite;

import java.util.Iterator;
import java.util.Calendar;

public class AlternatingDinerMenuIterator implements Iterator {
	MenuItem[] items;
	int position;

	public AlternatingDinerMenuIterator(MenuItem[] items) {
		this.items = items;
		Calendar rightNow = Calendar.getInstance();
		position = rightNow.DAY_OF_WEEK % 2; 
	} // basic constructor
	
	@Override
	public boolean hasNext() {
		if(position >= items.length || items[position] == null) {
			return false;
		} else {
			return true;
		}
	} // hasNext

	@Override
	public Object next() {
		MenuItem menuItem = items[position];
		position = position + 2;
		return menuItem;
	} // next
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException("remove()는 지원하지 않습니다.");
	} // remove
} // class
