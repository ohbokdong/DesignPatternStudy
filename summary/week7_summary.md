# Week 7 - Adapter Pattern & Facade Pattern

- 다른 목적으로 객체를 감싸고 실제와 다른 인터페이스를 가진 것처럼 보이도록 함
- 특정 인터페이스를 필요로 하는 디자인을 다른 인터페이스를 구현하는 클래스에 적응시킬 수 있기 때문
- 객체를 감싸서 인터페이스를 단순화 시킬 수 있는 패턴


## 어댑터(Adapter)
어떤 인터페이스를 클라이언트에서 요구하는 형태의 인터페이스에 적응시켜주는 역할

- 만약 Duck 객체가 모자라서 Turkey객체를 대신 사용해야 하는 상황이라면
```JAVA
//Duck Interface
  public interface Duck {
    public void quack();
    public void fly();
  }
```
```JAVA
//Turkey Interface
  public interface Turkey {
    public void gobble();
    public void fly();
  }
```
- TurkeyAdapter
```JAVA
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
```
- Test
```JAVA
public class DuckTestDrive {
	
	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck(); //duck 생성
		
		WildTurkey turkey = new WildTurkey(); //turkey 생성
		Duck turkeyAdapter = new TurkeyAdapter(turkey); //turkey를 TurkeyAdapter로 감싸서 duck으로 보이게 함
		
		//turkey 자체 테스트
		System.out.println("The turkey says...");
		turkey.gobble();
		turkey.fly();
		
		//duck객체 테스트
		System.out.println("\nThe Duck says...");
		testDuck(duck);
		
		//가장 중요한 부분! duck대신 turkey를 전달
		System.out.println("\nThe TurkeyAdapter says...");
		testDuck(turkeyAdapter);
	}
	
	//오리 객체를 받아서 아래 메소드들을 호출
	static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
}
```
## 어댑터 패턴(Adpater Pattern)
![어댑터이미지](https://byulmuri.files.wordpress.com/2010/07/ec96b4eb8c91ed84b0ed8ca8ed84b41.png)
#### 클라이언트에서 어댑터를 사용하는 방법
1. 클라이언트에서 타겟 인터페이스를 사용하여 메소드를 호출함으로써 어댑터에 요청을 함
2. 어댑터에서는 어댑티 인터페이스를 사용하여 그 요청을 어댑티에 대한 (하나 이상의) 메소드 호출로 변환
3. 클라이언트에서는 호출 결과를 받긴 하지만 중간에 어댑터가 껴 있는지는 전혀 알지 못함

### 어댑터 패턴 
- 정의 : **한 클래스의 인터페이스를 클라이언트에서 사용하고자 하는 다른 인터페이스로 변환합니다. 어댑터를 이용하면 인터페이스 호환성 문제 때문에 같이 쓸 수 없는 클래스들을 연결해서 쓸 수 있습니다.**

![어댑티다이어그램](https://byulmuri.files.wordpress.com/2010/07/ec96b4eb8c91ed84b0ed8ca8ed84b42.png?w=584)
- 인터페이스를 기준으로 코딩했기 때문에 타겟 인터페이스만 제대로 지킨다면 나중에 다른 구현을 추가하는 것도 가능!

### 클래스 어댑터
위 내용까지는 객체 어댑터였으며, 클래스 어댑터 패턴은 다중 상속이 필요하다(자바는 다중 상속이 불가능함)<br/>
클래스 어댑터 : <u>어댑티를 적응시키는 데 있어서 구성을 사용하는 대신, 어댑터를 어댑티와 타겟 클래스 모두의 서브 클래스로 만든다</u>
<table>
<thead>
  <tr>
    <th style="border-right: 1px solid #e5e5e5; width: 50%">객체 어댑터</th>
    <th >클래스 어댑터</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td style="border-right: 1px solid #e5e5e5;"><strong>구성</strong>을 통해서 어댑티에 요청을 전달</td>
    <td>어댑터를 만들 때 타겟과 어댑티 모두의 서브클래스를 만듦</td>
  </tr>
  <tr>
    <td style="border-right: 1px solid #e5e5e5; white-space:pre-line;">어댑터 코드에 어떤 행동을 추가하면,
    그 어댑터 코드는 모든 서브클래스에 대해서도 그대로 적용.
    유연성 최대한 확보 가능</td>
    <td>어댑티 전체를 다시 구현하지 않아도 됨. 어댑티의 행동을 오버라이드</td>
  </tr>
  <tr>
    <td style="border-right: 1px solid #e5e5e5;">어댑티가 필요</td>
    <td>특정 어댑티 클래스에만 적용된다는 단점</td>
  </tr>
</tbody>
</table>

![클래스어댑터](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile22.uf.tistory.com%2Fimage%2F231220425403D8F7012DAD)

### JAVA Enumeration vs Iterator
![JAVAEXample](https://javajazzle.files.wordpress.com/2011/03/adapter.jpg?w=447&h=215)

- 신식 Iterator
  - 일련의 항목들에 쉽게 접근도 하고. 제거도 하는 인터페이스
  - hasNext() : Enumeration 인터페이스의 hasMoreElements()와 유사함
- EnumerationIterator : 어댑터
- Enumerator 인터페이스를 구현하는 클래스는 어댑티가 됨

```JAVA
//겉에서 보기에 Iterotor처럼 생겨야 하므로 상속
public class EnumerationIterator implements Iterator
{
  Enumeration enum;

  //적응시켜야 하는 Enumeration 객체. 구성을 활용하고 있기 때문에 인스턴스로 저장
  public EnumerationIterator(Enumeration enum) {
    this.enum = enum;
  }

  public boolean hasNext() {
    return enum.hasMoreElements();
  }

  public Object next() {
    return enum.nextElement();
  }

  //remove는 없기 때문에 예외처리로 던짐
  public void remove() {
    throw new UnsupportedOperationException();
  }
}
```

## 파사드 패턴(Facade Pattern)
Facade는 '외관'이란 단어의 의미로 사용됨
<div style="border: 1px solid #000; background-color: lightgray; color:#000; margin-bottom: 20px;">
<strong>퍼사드패턴</strong>: 어떤 서브시스템의 일련의 인터페이스에 대한 통합된 인터페이스를 제공합니다.<br/>
퍼사드에서 고수준 인터페이스를 정의하기 때문에 서브시스템을 더 쉽게 사용할 수 있습니다.
</div>

<div sytle="white-space:pre-wrap;">"HomeTeatherFacade"는 가정용 극장의 "외관"역활을 한다.

'영화를 재생, 혹은 종료' 시킬 수 있고 '음악듣기, 끄기' '라디오 켜기, 끄기'의 기능을 가지고 있고,

Facade class(HomeTeatherFacade)를 서브클래싱한 Projector, TheatherLights 등이 존재한다.

이렇게 된 패턴을 사용하면 외부에서 리모콘으로 '영화보기()'를 클릭하면, watchMovie()가 호출되게 되고, 불이켜지고, DVDPlayer, 프로젝터, 스크린이 켜지고, 팝콘을 만들게 된다.

파사드는 직접적으로 서브클래스들을 제어한다.
</div>

![파사드패턴](https://t1.daumcdn.net/cfile/tistory/254789485403E07D31?download)

```JAVA
public class HomeTheaterFacade {
  // 구성 부분.
  // 사용하고자 하는 서브시스템의 모든 구성요소들이 인스턴스 변수 형태로 저장됨
	Amplifier amp;
	Tuner tuner;
	DvdPlayer dvd;
	CdPlayer cd;
	Projector projector;
	TheaterLights lights;
	Screen screen;
	PopcornPopper popper;
	
	//각 구성요소의 레퍼런스가 전달됨.
	public HomeTheaterFacade(Amplifier amp, Tuner tuner,
			DvdPlayer dvd, CdPlayer cd, Projector projector, TheaterLights lights,
			Screen screen, PopcornPopper popper) {
		this.amp = amp;
		this.tuner = tuner;
		this.dvd = dvd;
		this.cd = cd;
		this.projector = projector;
		this.lights = lights;
		this.screen = screen;
		this.popper = popper;
	}
	
	// 기타 메소드
	// 일련의 작업들을 하나의 메소드로 간단하게 처리
	// 각 작업은 서브시스템에 들어있는 구성요소들에게 위임됨
	public void watchMovie(String movie) {
		System.out.println("Get ready to watch a movie");
		popper.on();
		popper.pop();
		lights.dim(10);
		screen.down();
		projector.on();
		projector.setInput(dvd);
		projector.wideScreenMode();
		amp.on();
		amp.setDvd(dvd);
		amp.setSurrondSound();
		amp.setVolume(5);
		dvd.on();
		dvd.play(movie);
	}
	
	public void endMovie() {
		System.out.println("Shutting movie theater down...");
		popper.off();
		lights.on();
		screen.up();
		projector.off();
		amp.off();
		dvd.stop();
		dvd.eject();
		dvd.off();
	}
}
```
- Tester
```JAVA
public class HomeTheaterTestDrive {
	
	public static void main(String[] args) {
	     Amplifier amp = new Amplifier();
	     Tuner tuner = new Tuner();
	     DvdPlayer dvd = new DvdPlayer();
	     CdPlayer cd = new CdPlayer();
	     Projector projector = new Projector();
	     TheaterLights lights = new TheaterLights();
	     Screen screen = new Screen();
	     PopcornPopper popper = new PopcornPopper();
	     

	     HomeTheaterFacade htf = new HomeTheaterFacade(amp, tuner,
	                dvd, cd, projector,  lights,
	                screen, popper);
	     
	     htf.watchMovie("Raiders of the Lost ark");
	     htf.endMovie();
	}
}
```
<table>
<tr>
  <th></th>
  <th>어댑터</th>
  <th>데코레이터</th>
  <th>퍼사드</th>
</tr>
<tr>
  <th style="width:10%">용도</th>
  <td>객체를 감싸서 인터페이스를 바꾸기 위한 용도</td>
  <td>객체를 감싸서 새로운 행동을 추가하기 위한 용도</td>
  <td>일련의 객체들을 감싸서 단순화시키기 위한 용도</td>
</tr>
</table>


### 최소 지식 원칙 = 데메테르의 법칙(Law of Demeter) - 상호작용하는 클래스의 개수에 주의해야 하며, 어떤 식으로 상호작용하는지에도 주의를 기울여야 함
어떤 메소드에서든지 다음 네 종류의 객체의 메소드만 호출할 것
- 객체 자체
- 메소드에 매개변수로 전달된 객체
- 그 메소드에서 생성하거나 인스턴스를 만든 객체
- 그 객체에 속하는 구성요소

* 장점 : 객체들 사이의 의존성을 줄일 수 있고, 소프트웨어 관리가 더 용이해짐
* 단점 : 다른 구성요소에 대한 메소드 호출을 처리하기 위해 '래퍼'클래스를 더 만들어야 할 수도 있고, 시스템이 더 복잡해지고, 개발 시간도 늘어나고, 성능이 떨어질 수도 있음

## 정리
- 기존 클래스를 사용하려고 하는데 인터페이스가 맞지 않으면 어댑터를 쓰면 됨
- 큰 인터페이스, 또는 여러 인터페이스를 단순화시키거나 통합시켜야 되는 경우에는 퍼사드를 쓰면 됨
- 어댑터는 인터페이스를 클라이언트에서 원하는 인터페이스로 바꾸어 주는 역할
- 퍼사드는 클라이언트를 복잡한 서브시스템과 분리시켜주는 역할
- 어댑터를 구현할 때는 타겟 인터페이스의 크기와 구조에 따라 코딩 분량이 결정
- 퍼사드 패턴에서는 서브시스템을 가지고 퍼사드를 만들고, 실제 작업은 서브 클래스에 맡김
- 어댑터 패턴에는 객체 어댑터 패턴과 클래스 어댑터 패턴이 있으나, 클래스 어댑터 패턴은 다중 상속 기능이 필요함
- 한 서브시스템에 퍼사드를 여러개 만들어도 됨