package week4.minj0i;

import java.util.ArrayList;

public abstract class Pizza2 {
	String name;
	Dough dough;
	Sauce sauce;
	Veggies veggies[];
	Cheese cheese;
	Pepperoni pepperoni;
	Clams clam;
	
	abstract void prepare();
	
	void bake() {
		System.out.println("350도에서 25분동안 굽는다");
	}
	
	void cut() {
		System.out.println("피자를 자른다");
	}
	
	void box() {
		System.out.println("우리의 피자박스에 피자를 넣는다");
	}
	
	void setName(String name) {
		this.name = name;
	}
	String getName() {
		return name;
	}
	public String toString() {
		//피자 이름을 출력하는 부분
	}
	
}
