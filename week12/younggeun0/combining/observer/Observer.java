package week12.younggeun0.combining.observer;

public interface Observer {
	public void update(QuackObservable duck);
	// 옵저버 제거하는 메소드는 편의상 생략
}
