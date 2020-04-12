package week5.sgmsgood;

public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	
	//�� �ڵ�� ���Ϸ��� ������� ���� ���ư��ϴ�.
	public ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
	
	public void fill() {
		// ���Ϸ��� ������� ���� ��Ḧ ���� �ֽ��ϴ�. 
		// ���Ḧ ���� ä��� ���� empty�� boiled �÷��׸� false�� �����մϴ�. 
		if(isEmpty()) {
			empty = false;
			boiled = false;
			//���Ϸ��� ����/���ݸ��� ȥ���� ��Ḧ �������
		}
	}
	
	public void drain() {
		// ���Ϸ��� ���� ���ְ�, �� ������ ���¿����� ���Ϸ��� ����ִ� ��Ḧ ���� �ܰ�� �ѱ�ϴ�.
		// ���Ϸ��� �� ���� ���� empty �÷��׸� �ٽ� true�� �����մϴ�.
		if(!isEmpty() && isBoiled()) {
			// ���� ��Ḧ ���� �ܰ�� �ѱ�
			empty = true;
		}
	}
	
	public void boil() {
		if(!isEmpty() && isBoiled()) {
			// ��Ḧ ����
			boiled = true;
		}
	}
	
	public boolean isEmpty() {
		return empty;
	}
	
	public boolean isBoiled() {
		return boiled;
	}
}