package week8.younggeun0.templatemethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeinBeverageWithHook {
	@Override
	void brew() {
		System.out.println("커피 우리는 중");
	}

	@Override
	void addCondiments() {
		System.out.println("설탕과 우유를 추가하는 중");
	}
	@Override
	boolean customerWantsCondiments() { // 후크를 오버라이드해서 새로운 기능 추가
		String answer  = getUserInput();
		
		if (answer.toLowerCase().startsWith("y")) {
			return true;
		} else {
			return false;
		}
	}
	
	private String getUserInput() {
		String answer = null;
		
		System.out.println("커피와 우유에 설탕 넣어드릴까요? (y/n)");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			answer = in.readLine();
		} catch (IOException e) {
			System.out.println("io error");
		}
		if (answer == null) {
			return "no";
		}
		return answer;
	}
}
