package Templete;

public class Duck implements Comparable {
	String name;
	int weight;
	
	public Duck(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public String toString() {
		return name + ", 체중" + weight;
	}

	//sort() 메소드에서 필요로 하는 것
	//compareTo() 메소드에서는 다른 Duck 객체를 인자로 받아서 이 객체와 비교합니다.
	@Override
	public int compareTo(Object object) {
		Duck otherDuck = (Duck) object;
		
		//Duck 객체들을 비교하는 방법이 들어있는 부분.
		// 이 오리의 무게가 otherDuck 오리보다 가벼우면 -1, 무거우면 1, 같으면 0 반환
		if(this.weight < otherDuck.weight) {
			return -1;
		} else if (this.weight == otherDuck.weight) {
			return 0;
		} else {
			return 1;
		}
	}

}
