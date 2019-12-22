package week1;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("저는 날 수 없습니다.");
	}

}
