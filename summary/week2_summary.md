# Week 2 / chap 2  / 옵저버 패턴(Observer Pattern)

## 옵저버 패턴(Observer Pattern)
- 옵저버 패턴에서는 <strong>한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들한테 연락이 가고 자동으로 내용이 갱신되는 방식으로 일대다(one-to-many) 의존성</strong>을 정의함

```JAVA
//인스턴스 변수 선언
	public void measurementsChanged() {
		float temp = getTemperature();
		float humidity = getHumidity();
		float pressure = getPressure();
		
		// 디스플레이 갱신 부분
// 문제 1. 구체적인 구현에 맞춰서 코딩했기 때문에 프로그램 고치지 않고는 다른 디스플레이 항목을 추가/삭제 할 수 없음
// 문제 2. 디스플레이 항목과 데이터를 주고 받는 데 있어 공통된 인터페이스를 사용하고 있음
// 문제 3. 바뀔 수 있는 부분으로 캡슐화 해야 함
		currentConditionsDisplay.update(temp, humidity, pressure);
		staticsticsDisplay.update(temp, humidity, pressure);
		forecastDisplay.update(temp, humidity, pressure);
	}
```

### 느슨한 결합(Loose Coupling)
- 느슨하게 결합되어 있다 = 둘이 상호작용을 하긴 하지만 서로 잘 모른다
- 옵저버 패턴에서는 주제와 옵저버가 느슨하게 결합되어 있는 객체 디자인을 제공
  - 주제는 Observer 인터페이스를 구현하는 객체의 목록에만 의존함(추가/변경/제거 가능)
  - 새 형식의 옵저버 추가 시 주제를 변경할 필요가 없음
  - 주제와 옵저버는 서로 독립적으로 재사용할 수 있음
  - 주제나 옵저버가 바뀌어도 서로 영향 없음

### 디자인 원칙
서로 상호작용을 하는 객체 사이에서는 가능하면 느슨하게 결합하는 디자인을 사용해야 한다
=> 상호의존성 최소화

![01](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week2_01.png)



## 자바 내장 옵저버(Observer) 패턴
- java.util.Observer (https://docs.oracle.com/javase/7/docs/api/java/util/Observer.html)
- java.util.Observable (https://docs.oracle.com/javase/7/docs/api/java/util/Observable.html)

### Observable에서 연락 돌리기
Observable 수퍼클래스 확장하여 Observable 클래스 만들기
1. setChanged() 메소드를 호출해서 객체의 상태 바뀜 알림
2. notifyObservers() 또는 notifyObservers(Object arg) 중 하나의 메소드 호출

### Obserer가 연락 받기
update(Observable o, Object arg)
- Observable o : 연락을 보내는 주제 객체가 이 인자로 전달
- Object arg : notifyObservers()메소드에서 인자로 전달된 데이터 객체, 지정 안됐을 경우 null

```JAVA
setChanged() {
	changed = true
}

notifyObservers(Object arg){
	if(changed) {
		//목록에 있는 모든 옵저버에 대해
		{
			update(this, arg)
		}
		changed = false
	}
}

notifyObservers() {
	notifyObservers(null)
}
```
- setChanged : 일정 조건에 따라 호출하게 하기

### java.util.observable의 단점
1. Observable은 클래스
	- 서브 클래스를 만들어야 한다. 이미 다른 수퍼 클래스를 확장하고 있는 클래스에 Observable의 기능을 추가할 수 없음
	- 재사용성에 제약이 생김
	- Observable 인터페이라는 것이 없기 때문에 Observer API하고 잘 맞는 클래스 직접 구현이 불가능(ex. 멀티스레드로 구현)
2. Observable 클래스의 핵심 메소드를 외부에서 호출할 수 없음
	- setChanged() 메소드가 protected로 선언되어 있음

### 객체지향 원칙
- 바뀌는 부분은 캡슐화한다.
- 상속보다는 구성을 활용한다.
- 구현이 아닌 인터페이스에 맞춰서 프로그래밍 한다.
- 서로 상호작용을 하는 객체 사이에서는 가능하면 느슨하게 결합하는 디자인을 사용해야 한다.

### 옵저버 핵심 정리
- 옵저버 패턴에서는 객체들 사이에 일대다 관계를 정의
- 주제, 또는 Observable 객체는 동일한 인터페이스를 써서 옵저버에 연락을 함
- Observable에서는 옵저버들이 Observer 인터페이스를 구현한다는 것을 제외하면 옵저버에 대해 전혀 모르기 때문에, 이들 사이의 결합은 느슨한 결합
- (푸시 방식)주제 객체에서 데이터를 보내거나 (풀 방식, 더 추천)옵저버가 데이터를 가져옴
- 스윙 및 여러 GUI 프레임워크에서 옵저버 패턴이 많이 쓰임


![02](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week2_02.png)
