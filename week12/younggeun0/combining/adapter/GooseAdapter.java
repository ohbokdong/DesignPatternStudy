package week12.younggeun0.combining.adapter;

public class GooseAdapter implements Quackable {
	// 어댑터 패턴을 써서 덕처럼 거위가 사용될 수 있음
	Goose goose;
 
	public GooseAdapter(Goose goose) {
		this.goose = goose;
	}
 
	public void quack() {
		goose.honk();
	}

	public String toString() {
		return "Goose pretending to be a Duck";
	}
}
