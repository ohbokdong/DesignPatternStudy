package abstfac.concrete;

import abstfac.abst2.Button;
import abstfac.abst2.GuiFac;
import abstfac.abst2.TextArea;

public class FactoryInstance {

	public static GuiFac getGuiFac() {
		
		// switch값만 바꿔서 다른 GuiFac을 제공
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
		System.out.println("리눅스 버튼");
	}
}

class LinuxTextArea implements TextArea {

	@Override
	public String getText() {
		return "리눅스 텍스트에어리어";
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
		System.out.println("윈도우 버튼");
	}
}

class WinTextArea implements TextArea {

	@Override
	public String getText() {
		return "윈도우 텍스트에어리어";
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
		System.out.println("맥 버튼");
	}
}

class MacTextArea implements TextArea {

	@Override
	public String getText() {
		return "맥 텍스트에어리어";
	}
}


