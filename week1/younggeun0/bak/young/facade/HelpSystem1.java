package facade;

class HelpSystem1 { // default, package�������� ���� ����

	// ������ ������ �ڵ�� ����
	public HelpSystem1() {
		System.out.println("Call Constructor : " + getClass().getSimpleName());
	}
	
	public void process() {
		System.out.println("Call Process" + getClass().getSimpleName());
	}
}
