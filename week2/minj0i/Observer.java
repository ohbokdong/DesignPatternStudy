package week2.minj0i;

// Observer인터페이스는 모든 옵저버클래스에서 구현해야 함
// 따라서 모든 옵저버 update method
// 옵저버에게 측정한 값들을 전달
public interface Observer {
	public void update(float temp, float humidity, float pressure);
}
