package template_method_main_review0527;

import template_method_review0527.AbstGameConnectHelper;
import template_method_review0527.DefaultGameConnectionHelper;

public class Main {
	
	public static void main(String[] args) {
		AbstGameConnectHelper helper = new DefaultGameConnectionHelper();
		
		// template method�� ȣ���ϸ� ����Ŭ�������� �ܰ躰�� ������ �˰����� �����
		helper.requestConnection("���̵� ��ȣ �� ���� ����");
	}
}
