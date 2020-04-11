package week8.sgmsgood;

public class Duck implements Comparable {
	String name;
	int weight;
	
	public Duck(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public String toString() {
		return name + ", ü��" + weight;
	}

	//sort() �޼ҵ忡�� �ʿ�� �ϴ� ��
	//compareTo() �޼ҵ忡���� �ٸ� Duck ��ü�� ���ڷ� �޾Ƽ� �� ��ü�� ���մϴ�.
	@Override
	public int compareTo(Object object) {
		Duck otherDuck = (Duck) object;
		
		//Duck ��ü���� ���ϴ� ����� ����ִ� �κ�.
		// �� ������ ���԰� otherDuck �������� ������� -1, ���ſ�� 1, ������ 0 ��ȯ
		if(this.weight < otherDuck.weight) {
			return -1;
		} else if (this.weight == otherDuck.weight) {
			return 0;
		} else {
			return 1;
		}
	}

}
