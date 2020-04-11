package week9.rlawjddbs.iterator1;

public class DinerMenuIterator implements Iterator {
	MenuItem[] list;
	int position = 0;
	
	public DinerMenuIterator(MenuItem[] list) {
		this.list = list;
	} // basic constructor

	@Override
	public boolean hasNext() {
		if (position >= list.length || list[position] == null) {
			return false;
		} else {
			return true;
		}
	} // hasNext

	@Override
	public Object next() {
		MenuItem menuItem = list[position];
		position = position + 1;
		return menuItem;
	} // next
	
} // class
