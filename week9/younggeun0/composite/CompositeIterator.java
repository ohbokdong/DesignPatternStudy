package week9.younggeun0.composite;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<MenuComponent> {
	Stack<Iterator<MenuComponent>> stack = new Stack<Iterator<MenuComponent>>();
	
	public CompositeIterator(Iterator<MenuComponent> iterator) {
		// 최상위 복합객체의 반복자가 전달됨
		stack.push(iterator);
	}
	
	@Override
	public MenuComponent next() {
		if (hasNext()) {
			Iterator<MenuComponent> iterator = (Iterator<MenuComponent>) stack.peek();
			MenuComponent comp = (MenuComponent) iterator.next();
			if (comp instanceof Menu) {
				stack.push(comp.createIterator());
			}
			return comp;
		} else {
			return null;
		}
	}
	
	@Override
	public boolean hasNext() {
		if (stack.isEmpty()) {
			return false;
		} else {
			Iterator<MenuComponent> iterator = (Iterator<MenuComponent>) stack.peek();
			if (!iterator.hasNext()) { // 마지막이 없을 때 (리프일 때) 꺼냄
				stack.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
