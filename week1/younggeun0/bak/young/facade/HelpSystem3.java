package facade;

class HelpSystem3 { // default, package�������� ���� ����
	
	public HelpSystem3() {
		System.out.println("Call Constructor : " + getClass().getSimpleName());
	}
	
	public void process() {
		System.out.println("Call Process" + getClass().getSimpleName());
	}

	
}
