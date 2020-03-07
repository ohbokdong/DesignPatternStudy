package week9.minj0i.iterator2;

import java.util.Iterator;

public class DinerMenuIterator2 implements Iterator {
	MenuItem[] items;
	int position = 0;
	
	public DinerMenuIterator2(MenuItem[] items) {
		this.items = items;
	}
	
	@Override
	public boolean hasNext() {
		if (position >= items.length || items[position] == null) {
			return false;
		} else return true;
	}

	@Override
	public Object next() {
		MenuItem menuItem = items[position];
		position = position + 1;
		return menuItem;
	}

	//util.Iterator로 쓰면서 추가되는 부분
	public void remove() {
		if(position <= 0) {
			throw new IllegalStateException("next()를 한 번도 호출하지 않은 상태에서는 삭제할 수 없습니다.");
		}
		if (items[position-1] != null) {
			for (int i = position-1; i < (items.length -1); i++) {
				items[i] = items[i+1];
			}
			items[items.length-1] = null;
		}
	}
}
