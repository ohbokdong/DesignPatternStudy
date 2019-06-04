package abstfac.concrete;

import abstfac.abst2.Button;
import abstfac.abst2.GuiFac;
import abstfac.abst2.TextArea;

public class FactoryInstance {

	public static GuiFac getGuiFac() {
		
		// switch���� �ٲ㼭 �ٸ� GuiFac�� ����
		switch (getOsCode()) {
		case 0:
			return new MacGuiFac();
		case 1:
			return new LinuxGuiFac();
		case 2:
			return new WinGuiFac();
		}
		
		return null;
	}

	private static int getOsCode() {
		if (System.getProperty("os.name").equals("Windows 10")) {
			return 2;
		}
		return 1;
	}
	
	
}

class LinuxGuiFac implements GuiFac {

	@Override
	public Button createButton() {
		return new LinuxButton();
	}
	
	@Override
	public TextArea createTextArea() {
		// TODO Auto-generated method stub
		return new LinuxTextArea();
	}
}

class LinuxButton implements Button {

	@Override
	public void click() {
		System.out.println("������ ��ư");
	}
}

class LinuxTextArea implements TextArea {

	@Override
	public String getText() {
		return "������ �ؽ�Ʈ�����";
	}
}

class WinGuiFac implements GuiFac {

	@Override
	public Button createButton() {
		return new WinButton();
	}
	
	@Override
	public TextArea createTextArea() {
		// TODO Auto-generated method stub
		return new WinTextArea();
	}
}

class WinButton implements Button {

	@Override
	public void click() {
		System.out.println("������ ��ư");
	}
}

class WinTextArea implements TextArea {

	@Override
	public String getText() {
		return "������ �ؽ�Ʈ�����";
	}
}

class MacGuiFac implements GuiFac {

	@Override
	public Button createButton() {
		return new MacButton();
	}
	
	@Override
	public TextArea createTextArea() {
		// TODO Auto-generated method stub
		return new MacTextArea();
	}
}

class MacButton implements Button {

	@Override
	public void click() {
		System.out.println("�� ��ư");
	}
}

class MacTextArea implements TextArea {

	@Override
	public String getText() {
		return "�� �ؽ�Ʈ�����";
	}
}


