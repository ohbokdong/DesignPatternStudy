package teplate_method_main;

import template_method.AbstGameConnectHelper;
import template_method.DefaultGameConnectionHelper;

public class Main {
	
	public static void main(String[] args) {
		AbstGameConnectHelper helper = new DefaultGameConnectionHelper();
		
		helper.requestConnection("���̵� ��ȣ �� ���� ����");
	}
}
