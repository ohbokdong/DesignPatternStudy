package week9.rlawjddbs.composite;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator {
	Stack stack = new Stack();
	
	public CompositeIterator(Iterator iterator) {
		stack.push(iterator);
	} // basic constructor
	
	@Override
	public Object next() {
		if(hasNext()) {
			Iterator iterator = (Iterator)stack.peek();
			MenuComponent component = (MenuComponent)iterator.next();
			if(component instanceof Menu) {
				stack.push(component.createIterator());
			}
			return component;
		} else {
			return null;
		} // end else
	} // next
	
	public boolean hasNext() {
		if(stack.empty()) {
			return false;
		} else {
			Iterator iterator = (Iterator) stack.peek();
			// iterator가 node인지 leaf인지 확인
			if(!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			} else {
				return true;
			} // end else
		} // end else
	} // hasNext
	
	public void remove() {
		throw new UnsupportedOperationException();
	} // remove
} // abstract class
