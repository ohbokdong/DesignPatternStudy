package week5.sgmsgood;

public class Singleton {
	//Singleton Ŭ������ ������ �ν��Ͻ��� �����ϱ� ���� ���� ����
	private static Singleton uniqueInstance;
	
	//�����ڸ� private�� �����߱� ������ Singleton������ Ŭ������ �ν��Ͻ��� ���� �� �ֽ��ϴ�.
	private Singleton() {}
	
	//getInstance() �޼ҵ忡���� Ŭ������ �ν������� ����� �������ݴϴ�.
	public static Singleton getInstance() {
		
		//�ν��Ͻ��� �ʿ��� ��Ȳ�� ��ġ�� �������� �ƿ� �ν��Ͻ��� �������� �ʽ��ϴ�.'lazy instantiation'�̶�� �θ��ϴ�.
		if(uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
}
