package ObserverPattern;

public interface Subject {
	// 아래의 두 메소드에서 모두 Observer를 인자로 받습니다. 각각 옵저버를 등록하고 제거하는 역할을 합니다. 
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	
	// 주제 객체의 상태가 변경되었을 떼 모든 옵저버들한테 알리기 위해 호출되는 메소드 입니다.
	public void notifyObservers();
}
