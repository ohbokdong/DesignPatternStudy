package week9.rlawjddbs.iterator2;
import java.util.Iterator;

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


	@Override
	public void remove() {
		if (position <= 0) {
			throw new IllegalStateException("next()를 한 번도 호출하지 않은 상태에서는 삭제할 수 없습니다.");
		} // end if
		
		if (list[position-1] != null) {
			for(int i = position - 1; i < (list.length-1); i++) {
				// 배열의 현재 index에 할당 된 값을 다음 index에 할당 된 값으로 변경 (현재 index에 할당 된 값은 없어짐)
				list[i] = list[i+1];
			} // end for
			// 배열의 마지막 index에 할당 된 값은 null 처리
			list[list.length - 1] = null;
		} // end if
	} // remove
	
} // class
