package ObserverPattern;

/* Observer 인터페이스는 모든 옵저버 클래스에서 구현해야 합니다. 
 * 따라서 모든 옵저버는 update() 메소드를 구현해야 합니다. 
 * 여기에서는 메리와 수가 얘기했던 대로 옵저버에게 측정한 값들을 전달합니다. */
public interface Observer {
	// 매개변수(temp, humidity, pressure): 기상 정보가 변경되었을 때, 옵저버한테 전달되는 상태 값들
	public void update(float temp, float humidity, float pressure);
}
