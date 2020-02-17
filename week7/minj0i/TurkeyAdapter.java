package week7.minj0i;

// Duck이라는 클라이언트에서 원하는 인터페이스를 구현
public class TurkeyAdapter implements Duck {
	Turkey turkey;
	
	//생성자에서 원래 형식의 객체에 대한 레퍼런스를 받아옴
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}
	
	@Override
	public void quack() {
		 turkey.gobble();
	}

	@Override
	public void fly() {
		//칠면조는 오리만큼 날지 못하므로 5번 반복하여 좀 더 멀리 날도록 함
		for(int i=0; i<5; i++) {
			turkey.fly();
		}
	}

}
