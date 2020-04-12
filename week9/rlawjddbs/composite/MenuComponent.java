package week9.rlawjddbs.composite;

import java.util.Iterator;

public abstract class MenuComponent {
	
	public void add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	} // add
	
	public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	} // remove
	
	public MenuComponent getChild(int i) {
		throw new UnsupportedOperationException();
	} // remove
	
	public String getName() {
		throw new UnsupportedOperationException();
	} // remove
	
	public String getDescription() {
		throw new UnsupportedOperationException();
	} // remove
	
	public double getPrice() {
		throw new UnsupportedOperationException();
	} // remove
	
	public boolean isVegetarian() {
		throw new UnsupportedOperationException();
	} // remove
	
	public void print() {
		throw new UnsupportedOperationException();
	} // print
	
	public abstract Iterator createIterator();
	
} // class
