package template_method_main_review0527;

import template_method_review0527.AbstGameConnectHelper;
import template_method_review0527.DefaultGameConnectionHelper;

public class Main {
	
	public static void main(String[] args) {
		AbstGameConnectHelper helper = new DefaultGameConnectionHelper();
		
		// template method만 호출하면 하위클래스에서 단계별로 구현된 알고리즘이 수행됨
		helper.requestConnection("아이디 암호 등 접속 정보");
	}
}
