package facade;

class HelpSystem2 { // default, package�������� ���� ����
	
	public HelpSystem2() {
		System.out.println("Call Constructor : " + getClass().getSimpleName());
	}
	
	public void process() {
		System.out.println("Call Process" + getClass().getSimpleName());
	}

	
}
