package week5.younggeun0;

public class CBTest {

	public static void main(String[] args) {
		
		ChocolateBoiler cb1 = new ChocolateBoiler();
		ChocolateBoiler cb2 = new ChocolateBoiler();
		
		// 이 순서로 진행해야 함
		cb1.fill();
		cb2.fill();
		// 초콜릿을 한번만 채워야 하는데 인스턴스가 두개가 생성되어 두 번 채우는 문제가 발생
		
		cb1.boil();
		cb1.drain();
		
		
		
	}
}
