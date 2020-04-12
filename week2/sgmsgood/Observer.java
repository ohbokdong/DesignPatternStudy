package week2.sgmsgood;

/* Observer �������̽��� ��� ������ Ŭ�������� �����ؾ� �մϴ�. 
 * ���� ��� �������� update() �޼ҵ带 �����ؾ� �մϴ�. 
 * ���⿡���� �޸��� ���� ����ߴ� ��� ���������� ������ ������ �����մϴ�. */
public interface Observer {
	// �Ű�����(temp, humidity, pressure): ��� ������ ����Ǿ��� ��, ���������� ���޵Ǵ� ���� ����
	public void update(float temp, float humidity, float pressure);
}
