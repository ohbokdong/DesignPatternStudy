package week14.flyweight;

import week14.flyweight.Tree;

public class PineTree implements Tree {

	@Override
	public void display(int age, int x, int y) {
		System.out.println("[소나무 수령 : " + age + "년 / x좌표 : " + x + "/ y좌표 : " + y + "]");
	} // display

} // class
