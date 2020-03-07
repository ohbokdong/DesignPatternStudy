package week9.composite;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent {
	ArrayList menuComponents = new ArrayList();
	String name;
	String description;
	
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	} // basic constructor

	@Override
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	} // basic constructor
	
	@Override
	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	} // remove
	
	@Override
	public MenuComponent getChild(int i) {
		return (MenuComponent)menuComponents.get(i);
	} // getChild
	
	@Override
	public String getName() {
		return name;
	} // getName

	@Override
	public String getDescription() {
		return description;
	} // getDescription
	
	@Override
	public void print() {
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("-------------------------------");
		
		Iterator iterator = menuComponents.iterator();
		while(iterator.hasNext()) {
			MenuComponent menuComponent = (MenuComponent)iterator.next();
			menuComponent.print();
		} // end while
	} // print

	@Override
	public Iterator createIterator() {
		return new CompositeIterator(menuComponents.iterator());
	}
} // class
