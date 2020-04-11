package week5.sgmsgood;

public class SingletonChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	
	private static SingletonChocolateBoiler uniqueInstance;
	
	private SingletonChocolateBoiler() {
		empty = true;
		boiled = false;
	}
	
	public static SingletonChocolateBoiler getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new SingletonChocolateBoiler();
		}
		return uniqueInstance;
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
