package week8.sgmsgood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TeaWithHook extends CaffeineBeverageWithHook{

	@Override
	void brew() {
		System.out.println("���� ������� ��.");
	}

	@Override
	void addCondiments() {
		System.out.println("������ �߰��ϴ� ��");
	}

	public boolean customerWantsCondiments() {
		String answer = getUserInput();
		
		if(answer.toLowerCase().startsWith("y")) {
			return true;
		} else {
			return false;
		}
	}
	
	private String getUserInput() {
		String answer = null;
		
		System.out.println("���� ������ �־�帱���? (y/n)");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			answer = in.readLine();
		} catch (IOException ioe){
			System.err.println("IO ����");
		}
		
		if (answer == null) {
			return "no";
		}
		
		return answer;
	}
}
