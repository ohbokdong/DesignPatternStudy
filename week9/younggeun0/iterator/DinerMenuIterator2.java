package week9.younggeun0.iterator;

import java.util.Iterator;

public class DinerMenuIterator2 implements Iterator { // 이터레이터를 구현
	MenuItem[] items;
	int position = 0; // 배열에 대한 반복작업을 위해 현재 위치를 저장
	
	public DinerMenuIterator2(MenuItem[] items) {
		this.items = items; // 생성자에서 반복작업을 수행할 메뉴 항목에 대한 배열을 인자로 받음
	}
	
	@Override
	public Object next() { // 배열의 다음 원소를 리턴, position변수의 값을 증가시킴
		MenuItem menuItem = items[position];
		position++;
		return menuItem;
	}

	@Override
	public boolean hasNext() { //배열의 있는 모든 원소를 돌았는지 확인
		if (position >= items.length || items[position] == null) {
			// 객체마을 메뉴는 최대 개수가 정해진 배열, 배열 끝에 있는지를 확인하는 것 외에도 다음 항목이 null인지도 확인해야 함
			return false;
		} else { // 아직 돌아야 할 원소가 있으면 true 리턴
			return true;
		}
	}
	
	@Override
	public void remove() {
		if (position <= 0) {
			throw new IllegalStateException("next()를 한 번도 호출하지 않은 상태에서는 삭제할 수 없음");
		}
		if (items[position-1] != null) {
			// 모든 항목들을 한 칸씩 왼쪽으로 밀어 줘야 함
			for (int i = position-1; i<(items.length-1); i++) {
				items[i] = items[i+1];
			}
			items[items.length-1] = null;
		}
	}
}
