package week2.minj0i;

public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	//주제 객체의 상태가 변경되었을 때 모든 옵저버들에게 알리기 위해 호출되는 메소드
	public void notifyObservers();
}
