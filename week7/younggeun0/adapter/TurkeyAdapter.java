package week7.younggeun0.adapter;

public class TurkeyAdapter implements Duck {

	// Duck 객체가 모자라서 Turkey 객체를 대신 사용해야 하는 상황
	Turkey turkey;
	
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}
	
	@Override
	public void quack() {
		turkey.gobble();
	}
	
	@Override
	public void fly() {
		// 오리만큼 멀리 못 나니까 5번 호출해서 좀 더 멀리 움직이게 함
		for(int i=0; i<5; i++)
			turkey.fly();
	}
}
