package week4.minj0i;

import java.util.ArrayList;

public abstract class Pizza {
	String name;
	String dough;
	String sauce;
	ArrayList toppings = new ArrayList<>();
	
	void prepare() {
		System.out.println("준비중 " + name);
		System.out.println("Tossing 도우.");
		System.out.println("소스 추가......");
		System.out.println("토핑 추가: ");
		for (int i=0; i<toppings.size(); i++) {
			System.out.println(" " + toppings.get(i));
		}
	}
	
	void bake() {
		System.out.println("350도에서 25분동안 굽는다");
	}
	
	void cut() {
		System.out.println("피자를 자른다");
	}
	
	void box() {
		System.out.println("우리의 피자박스에 피자를 넣는다");
	}
	
	public String getName() {
		return name;
	}
}
