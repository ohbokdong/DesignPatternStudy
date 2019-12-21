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

## 느슨한 결합(Loose Coupling)
- 느슨하게 결합되어 있다 = 둘이 상호작용을 하긴 하지만 서로 잘 모른다
- 옵저버 패턴에서는 주제와 옵저버가 느슨하게 결합되어 있는 객체 디자인을 제공
  - 주제는 Observer 인터페이스를 구현하는 객체의 목록에만 의존함(추가/변경/제거 가능)
  - 새 형식의 옵저버 추가 시 주제를 변경할 필요가 없음
  - 주제와 옵저버는 서로 독립적으로 재사용할 수 있음
  - 주제나 옵저버가 바뀌어도 서로 영향 없음

### 디자인 원칙
서로 상호작용을 하는 객체 사이에서는 가능하면 느슨하게 결합하는 디자인을 사용해야 한다
=> 상호의존성 최소화

