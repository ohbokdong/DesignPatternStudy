# Week 12 - Compound Pattern
- 일련의 패턴을 함께 사용하여 다양한 디자인 문제를 해결 하는 것을 컴파운드 패턴(Compound Pattern)이라고 한다
- 패턴 몇 개를 결합해서 쓴다고 해서 무조건 컴파운드 패턴이 되는 것은 아니며,</br> <b>여러가지 문제를 해결하기 위한 용도로 쓰일 수 있는 일반적인 해결책</b>이어야 한다

## 여러가지 패턴 사용하기(pg.539~pg.557)
1. Quackable 인터페이스 만들기
    - quack(): 꿱 소리를 내는 메소드
2. Quackable을 구현한 오리 클래스 만들기
    - MallardDuck, RedheadDuck은 Quack 소리를 냄
    - DuckCall, RubberDuck은 Kwak, Squeak 소리를 냄
3. 제대로 작동하는지 확인하기 위한 시뮬레이터 생성
    - simulate()에서 각 오리들을 Quackable 객체로 생성
    - simulate(Quackable duck): 객체를 받아 테스트하는 오버로드된 메소드
        - <b>다형성</b>이 활용됨
4. 오리 말고 거위 추가
    - honk(): Honk라는 소리를 냄
5. 거위용 <b>어댑터</b> 만들기
    - GooseAdapter implements Quackable: 어댑터에서는 타겟 인터페이스를 구현해야 하므로 Quackable 구현
    - 생성자에서 Goose 객체를 인자로 받는다
    - quack()에서 goose.honk();
6. 거위객체도 시뮬레이터에 넣기
    - simulate(){ 에서 일반 오리는 Quackable mallardDuck = new MAllardDuck();이라면,
    - 거위는 Quackable gooseDuck = new GooseAdapter(new Goose());
7. 제대로 돌아가는지 확인
8. 꽥 소리를 낸 횟수 세는 기능 추가
    - <b>데코레이터 패턴</b> 활용
```JAVA
//QuackCounter가 데코레이터
//타겟 인터페이스 Quackable 구현
public class QuackCounter implements Quackable {
    //감싸고자 하는 객체의 레퍼런스를 저장하기 위한 인스턴스 변수 생성
    Quackable duck;
    //모든 객체에서 꽥소리를 낸 횟수를 세기 위해 정적 변수 생성
    static int numberOfQuacks;

    public QuackCounter (Quackable duck) {
        this.duck = duck;
    }
    public void quack() {
        duck.quack(); //호출을 데코레이터 안에 들어있는 Quackable에 위임
        numberOfQuacks++;
    }
    //모든 Quackable에서 꽥 소리를 낸 횟수 리턴
    public static int getQuacks() {
        return numberOfQuacks;
    }
}
```
9. 시뮬레이터를 고쳐 모든 오리들을 데코레이터로 감쌈
    - simulate() 안 오리들을 Quackable mallardDuck = new QuckCounter(new MallardDuck()); 처럼 고침
    - QuackCounter.getQuacks() 출력하는 것 추가
### >>>제대로 세지 못하는 문제 발생
-  <b>팩토리패턴</b> 사용: 오리 객체를 생성하는 작업을 한 군대로 몰아서 하고 데코레이터로 감싸는 부분을 따로 캡슐화 함

10. 오리를 생산하기 위한 팩토리 필요
    - 서브클래스에서는 이 추상 팩토리를 구현하여 다양한 종류의 객체 만들기 가능
```JAVA
public abstract class AbstractDuckFactory {
    public abstract Quackable createMallardDuck();
    ...
}
```
- 데코레이터가 없는 오리를 만드는 팩토리
     - 위에서 만든 추상 팩토리 확장
     - 각 메소드에서는 일종의 Quackable 객체를 만드는 것
```JAVA
public class DuckFactory extends AbstractDuckFactory {
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }
    ...
}
```
- CoutingDuckFactory 만들기
    - 횟수를 세기 위한 데코레이터로 감싼다
```JAVA
    public class CountingDuckFactory extends AbstractDuckFactory {
        public Quackable createMallardDuck(){
            return new QuackCounter(new MallardDuck());
        }
        ...
    }
```
11. 팩토리를 쓸 수 있도록 시뮬레이터 고치기
    - 추상팩토리는 팩토리를 받고 그 팩토리르 써서 객체를 생성하는, 다형성을 갖춘 메소드를 만들어야 함
```JAVA
public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        //simulate()메소드에 전달할 팩토리 생성
        AbstractDuckFactory duckFactory = new CountingDuckFactory();

        simulator.simulate(duckFactory);
    }

    //AbstractDuckFactory 인자를 받음
    //객체를 직접 생성하지 않고, 팩토리의 메소드를 통해서 생성
    void simulate(AbstractDuckFactory duckFactory) {
        Quckable mallardDuck = duckFactory.createMallardDuck();
        ...
    }
}
```
### >>>오리떼 관리하는 기능 추가
- 오리들로 구성된 컬렉션, 또는 그 컬렉션의 부분 컬렉션을 다룰 수 있는 방법 필요
12. 오리떼 만들기
    - <b>컴포지트 패턴</b> 활용: 객체들로 구성된 컬렉션을 개별 객체하고 똑같은 식으로 다룰 수 있게 해줌
    - <b>이터레이터 패턴</b>활용: 순환문
```JAVA
public class Flock implements Quackable {
    ArrayList quackers = new ArrayList();

    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    public void quack() {
        Iterator iterator = quackers.iterator();
        while (iterator.hasNext()) {
            //ArrayList에 대해 순환문 돌리며 각 원소의 quack()메소드 호출
            Quckable quacker = (Quackable)iterator.next();
            quacker.quack();
        }
    }
}
```
13. 시뮬레이터 고치기
    - simulate() { 안에 추가
```JAVA
//Flock을 생성한 다음 Quackable을 넣음
Flock flockOfDucks = new Flock();
flockOfDucks.add(redheadDuck);
...

//MallardDuck떼 만들기
Flock flockOfMallards = new Flock();
Quackable mallardOne = duckFactory.createMallardDuck();
...
flockOfMallards.add(mallardOne);
...
//MallardDuck떼를 오리떼에 넣는다
flockOfDucks.add(flockOfMallards);
```
### >>>안전성 vs 투명성
- add()는 Flock클래스에만 있음. 오리 객체에서는 아무 쓸모 없기 때문에. Flock에 대해서만 호출 => 안전성 높음
- 클라이언트에서 어떤 객체에 Quackable을 추가할때 Flock인지 아닌지 확실하게 알아야 함 => 투명성 떨어짐
- 장단점 따져서 알아서 하쇼!ㅎㅎ
### >>> 오리들을 각각 추적하기 기능 추가
- <b>옵저버 패턴</b> 활용: 객체의 행동을 관찰하기 위해 만들어진 것
14. Observer 인터페이스 필요
    - 관찰 대상이 되는 것: Observable
    - Observable은 옵저버 등록 메소드, 연락 돌리는 메소드 필요, + 옵저버 제거 메소드
```JAVA
    public interface QuackObservable {
        public void registerObserver(Observer observer);
        public void notifyObservers();
    }
```
```JAVA
    public interface Quackable extends QuackObserveable {
        public void quack();
    }
```
15. Quackable 구현하는 모든 구상 클래스에서 QuackObservable에 있는 메소드 구현하도록 만듬
    - 등록 및 연락용 코드를 Observable이라는 한 클래스에 캡슐화
    - 구성을 통해 QuackObservable에 포함시킴
    - 실제 코드는 한 군데에서만 작성하고, QuackObservable에서는 필요한 작업을 Observable이라는 보조 클래스에 전부 위임
```JAVA
public class Observable implements QuackObservable {
    ArrayList observers = new ArrayList();
    QuackObservable duck;

    //생성자의 인자로 객체를 써서 QuackObservable로써의 행동을 구현할 객체가 전달
    //밑에있는 notifyObservers()에서 연락을 돌릴때 duck을 인자로 전달해서
    //옵저버에 그 QuackObservable 객체가 연락을 돌린다는 것을 알려줌
    public Observable(QuackObservable duck) {
        this.duck = duck;
    }
    
    //옵저버 등록
    public void registerOBservers(Observer observer) {
        observers.add(observer);
    }

    //연락 돌리기
    public void notifyObservers() {
        Iterator iterator = observers.iterator();
        while (iterator.hasNext()) {
            Observer observer = (Observer)iterator.next();
            observer.update(duck);
        }
    }
}
```
16. Observer 보조 객체와 Quackable 클래스를 결합
```JAVA
public class MallardDuck implements Quackable {
    Observable observable;

    public MallardDuck() {
    //MallardDuck 객체에 대한 레퍼런스를 인자로 전달
        observable = new Observable(this);
    }

    public void quack() {
        syso("Quack");
        notifyObservers();
    }

//보조객체한테 떠넘겨 버리기~
    public void registerObserver(Observer observer){
        observable.registerObserver(observer);
    }
    public void notifyObservers(){
        observable.notifyObservers();
    }
}
```
17. 옵저버 패턴의 옵저버 쪽 완성
```JAVA
//꽥소리 낸에만 전달 받음
public interface Observer {
    public void update(QuackObservable duck);
}
```
```JAVA
//Observer 인터페이스를 구현해야 -vable 객체에 등록 할 수 있음
public class Quackologist implements Observer {
    public void update(QuackObservable duck) {
        syso("꽥학자" + duck + "방금 꽥");
    }
}
```
18. 시뮬레이터 고치기
    - Quackologoist를 만들어 오리떼의 옵저버로 설정
    - Quackologist quackologist = new Quackologist();
    - flockOfDucks.registerObserver(quackologist);

### >>> 충격 결말 : 위의 코드는 컴파운드 패턴은 아니다.
- 그냥 여러 패턴을 섞어서 써을 뿐
- 컴파운드 패턴이려면 몇 개의 패턴을 복합적으로 사용해서 일반적인 문제를 해결할 수 있어야 함

### 정리
1. 어댑터 패턴 : 거위를 Quackable로 만들어 줌
2. 데코레이터 패턴 : QuackCounter 데코레이터를 추가하여 횟수 셈
3. 팩토리 패턴 : QuackCounter로 장식되지 않은 Quackable 객체도 가능하도록
4. 컴포지트 패턴 : 오리들을 모아 오리떼 단위로 관리
5. 이터레이터 패턴 : java.util의 반복자 iterator
6. 옵저버 패턴 : Quackologist를 Quackable의 옵저버로 등록

![오리 클래스 다이어그램](http://wiki.gurubee.net/download/attachments/1507417/duck.jpg)


## 모델,뷰,컨트롤러 MVC
![모델뷰컨트롤러](https://thebook.io/img/007024/023.jpg)

![MVC1](https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F2125D03A50D3C4FE22)

![MVC2](https://t1.daumcdn.net/cfile/tistory/234B7C3C50D3CA4B29)

![3patterns](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week12/3patterns.jpg?raw=true)

![javaMVC](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week12/javaMVC.jpg?raw=true)

1. 모델 구현 - BeatModelInterface
```JAVA
public interface BeatModelInterface {
	//컨트롤러에서 모델한테 사용자 입력을 전달할때 사용할 메소드
    void initialize();
  
	void on();
  
	void off();
  
    void setBPM(int bpm);
  
	int getBPM();
  
  //뷰와 컨트롤러에서 상태를 알아내거나 옵저버를 등록할 때 사용하는 메소드
	void registerObserver(BeatObserver o);
  
	void removeObserver(BeatObserver o);
  
	void registerObserver(BPMObserver o);
  
	void removeObserver(BPMObserver o);
}
```

2. 모델 구현 - BeatModel
    - BeatModelInterface를 구현

3. 뷰 구현 - DJview
    - 모델과 컨트롤러에 대한 레퍼런스가 모두 들어감
    - Beat, BPM observer들을 구현
    - 인터페이스 상에 배치하고 컨트롤 할수 있는 것 구현

4. 컨트롤러 구현 - ControllerInterface
    - 뷰에서 컨트롤러에 대해 호출할 모든 인터페이스

5. 컨트롤러를 구현한 코드 - BeatController
    - ControllerInterface를 구현
    - 컨트롤러의 생성자에 모델이 인자로 전달, 생성자에서 뷰도 생성
    - 뷰와 모델 모두 맞닿아 있으므로 그 둘을 이어주는 기능을 함
    - ex) 뷰에서 사용자가 설정 -> 모델에 연락해 세팅

6. 테스트 - DJTestDrive
```JAVA
public class DJTestDrive {

    public static void main (String[] args) {
        //모델 생성
        BeatModelInterface model = new BeatModel();
        //컨트롤러에 모델을 인자로 전달
		ControllerInterface controller = new BeatController(model);
        //뷰는 컨트롤러에서 생성해 줌
    }
}
```
- View창을 음악이 아닌 심박수 용도로 쓴다면?
    - 스트래티지 패턴: BeatModelInterface를 타겟 인터페이스로 구현 
    - 어댑터 패턴: HeartModel을 BeatModel에 적응시킨다 (HeartAdapter implements BeatModelInterface)

## 모델2
- 서블릿과 JSP 기술을 사용하여 일반적인 GUI를 사용하는 경우와 마찬가지로 모델, 뷰, 컨트롤러를 분리해서 디자인

![모델2](https://lh3.googleusercontent.com/proxy/ljNZYSBzvnyWUNdqWsfJaptCYhkHUXsMKGyr_prXxboEHWyE4xU7q17B4zarIZMP71tSTXTZovSLdpGbZnAJ2Y03161MMc_Luyi96hdqR3iwIeUDoOnYvg)

1. 사용자가 HTTP요청을 하면 서블릿에서 요청 수신
    - ID, 비밀번호와 같은 폼 데이터가 함께 전달
    - 서블릿에서는 폼 데이터 받아서 파싱
2. 서블릿이 컨트롤러 역할을 함
    - 대부분의 경우에 모델(보통 데이터베이스)에 어떤 요청을 함
    - 결과는 일반적으로 자바빈 형태로 포장
3. 컨트롤러에서 컨트롤을 뷰에게 넘김
    - 뷰는 JSP에 의해 표현됨
    - 4를 통해 자바빈으로부터 얻은 모델의 뷰를 나타내는 페이지를 만듬
5. 뷰에서 HTTP를 통해 브라우저에게 페이지 전달
    - 그 웹페이지가 사용자의 화면에 표시

> 모델2를 통해 개발자들은 서블릿에, 웹 제작자들은 JSP만 다루는 환경으로 바뀜


### 휴대전화로 DJ세션 제어하기
1. 모델: 앞에서 썼던 것 그대로
2. 컨트롤러 서블릿
    - 서블릿이 컨트롤러 역할, HttpServlet 클래스 확장
```JAVA
public class DJViewServlet extends HttpServlet {

    //서블릿 생성 시 가장 먼저 호출되는 메소드
	public void init() throws ServletException {
        //Model 객체 생성
		BeatModel beatModel = new BeatModel();
		beatModel.initialize();
        //객체에 레퍼런스를 서블릿의 컨텍스트에 저장
		getServletContext().setAttribute("beatModel", beatModel);
	}

	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws IOException, ServletException
	{
        //서블릿 컨텍스트로부터 모델 가져오기
		BeatModel beatModel = 
				(BeatModel)getServletContext().getAttribute("beatModel");

        //HTTP 명령/매개변수 등 모두 가져온다
		String bpm = request.getParameter("bpm");
		if (bpm == null) {
			bpm = beatModel.getBPM() + "";
		}

        //set을 통해 설정할 값 알아내서 모델에 요청
		String set = request.getParameter("set");
		if (set != null) {
			int bpmNumber = 90;
			bpmNumber = Integer.parseInt(bpm);
			beatModel.setBPM(bpmNumber);
		}

        //요청 들어오면 모델로부터 값 받아서 처리
		String decrease = request.getParameter("decrease");
		if (decrease != null) {
			beatModel.setBPM(beatModel.getBPM() - 1);
		}
		String increase = request.getParameter("increase");
		if (increase != null) {
			beatModel.setBPM(beatModel.getBPM() + 1);
		}
		String on = request.getParameter("on");
		if (on != null) {
			beatModel.on();
		}
		String off = request.getParameter("off");
		if (off != null) {
			beatModel.off();
		}

        //뷰한테 HTML뷰 만들어달라고 요청
        //모델 자체가 빈이기 때문에 모델을 넘겨줌
		request.setAttribute("beatModel", beatModel);

		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/djview.jsp");
		dispatcher.forward(request, response);
	}
}
```
3. 뷰 만들기(JSP)
```html
<jsp:useBean id="beatModel" scope="request" class="headfirst.combined.djview.BeatModel" />

<html>
<head>
<title>DJ View</title>
</head>
<body>

<h1>DJ view</h1>
Beats per minutes = <jsp:getProperty name="beatModel" name="beatModel" property="BPM/">

<form method="get" actions="/djview/servlet/DJView">
BPM : <input type=text name="bpm" value="<jsp:getProperty name="beatModel" property="BPM" />">
...
```
<img src="https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week12/model2.jpg?raw=true" style="transform: rotate(270deg); width:70%; display:block; margin:auto">

- 스트래티지 패턴: 컨트롤러 서블릿이 뷰의 행동을 구현함, 다른 행동 원하면 다른 컨트롤러로 변경
- 컴포지트 패턴: 결국 복합 객체 형태

## 정리
- 두 개 이상의 패턴을 결합하여 일반적으로 자주 등장하는 문제들에 대한 해법을 제공
- MVC: 옵저버(모델)+스트래티지(컨트롤러)+컴포지트패턴(뷰)