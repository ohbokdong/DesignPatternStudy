package week2.sgmsgood;

public interface Subject {
	// �Ʒ��� �� �޼ҵ忡�� ��� Observer�� ���ڷ� �޽��ϴ�. ���� �������� ����ϰ� �����ϴ� ������ �մϴ�. 
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	
	// ���� ��ü�� ���°� ����Ǿ��� �� ��� ������������ �˸��� ���� ȣ��Ǵ� �޼ҵ� �Դϴ�.
	public void notifyObservers();
}
