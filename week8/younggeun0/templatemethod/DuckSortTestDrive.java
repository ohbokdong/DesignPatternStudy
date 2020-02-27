package week8.younggeun0.templatemethod;

import java.util.Arrays;

public class DuckSortTestDrive {
	
	public static void main(String[] args) {
		
		Duck[] ducks = {
				new Duck("a", 8),
				new Duck("c", 2),
				new Duck("g", 6),
				new Duck("l", 9),
				new Duck("k", 3)
		};
		System.out.println("before sort");
		display(ducks);
		
		Arrays.sort(ducks);
		
		System.out.println("After sort");
		display(ducks);
		
	}
	
	public static void display(Duck[] ducks) {
		for(Duck d : ducks) {
			System.out.println(d);
		}
	}

}
