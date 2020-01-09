package week4.younggeun0;

import java.util.ArrayList;

public abstract class Pizza {
	String name;
	String dough;
	String sause;
	
	ArrayList<String> toppings = new ArrayList<String>();
	
	void prepare() {
		System.out.println("준비중..."+name);
		System.out.println("도우만들자 읏차...");
		System.out.println("소스 넣고...");
		System.out.println("토핑 넣고...");
		for(int i=0; i<toppings.size(); i++) {
			System.out.print("  "+toppings.get(i)+", ");
		}
		System.out.println();
	}
	
	void bake() {
		System.out.println("25분동안 350도에서 굽자...");
	}
	
	void cut() {
		System.out.println("피자를 조각조각 자르자...");
	}
	
	void box() {
		System.out.println("포장포장...");
	}
	
	public String getName() {
		return name;
	}

	public String getDough() {
		return dough;
	}

	public String getSause() {
		return sause;
	}

	public ArrayList<String> getToppings() {
		return toppings;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDough(String dough) {
		this.dough = dough;
	}

	public void setSause(String sause) {
		this.sause = sause;
	}

	public void setToppings(ArrayList<String> toppings) {
		this.toppings = toppings;
	}
}
