# Week 6 - Command Pattern

## 커맨드 패턴 예

![week6_01](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week6_01.png?raw=true)

* **어떤 작업을 요청한 쪽하고 그 작업을 처리하는 쪽을 분리시킬 수 있음**

* **객체 마을 식당**
  * 고객이 주문 - 웨이트리스가 주문서 받아 주방에 전달 - 주방장이 주방에서 요리
  * 고객 - 클라이언트 객체
  * 웨이트리스 - 인보커 객체
  * 주문 받기 - setCommand()
  * 주문서 - 커맨드 객체
  * 주방에 전달(orderUp) - execute()
  * 주방장 - 리시버 객체
  * **주방장과 웨이트리스는 완전히 분리되어 있음**
    * 웨이트리스는 주문취합 후 요청만 수행
    * 주방장은 요리만 수행

* **리모컨 개발**
  * 7개의 슬롯 존재, 각 슬롯에 대응하는 on/off 버튼이 있음, undo 버튼이 있음
  * 각 가전제품 제작사로부터 공급된 클래스 정보를 보고 리모컨 제어를 해야 함
  * **리모컨에서 작업을 요청하고 업체에서 공급한 클래스에서 그 작업을 처리하도록 함**
    * **커맨드 객체(Command ObjecT)를 추가**
      * 커맨드 객체는 특정 객체(거실 전등 등)에 대한 특정 작업(불을 켜기/끄기) 요청을 캡슐화 시켜줌
      * 버튼마다 커맨드 객체를 저장해 두면 사용자가 버튼을 눌렀을 때 커맨드 객체를 통해서 작업을 처리하도록 만들면 됨
      * 리모컨에서는 어떤 수행처리인지 몰라도 되고, 단지 리모컨은 어떤 객체에 어떤 일을 시켜야 할지 알고 있는 커맨드 객체만 있으면 됨

* **인보커 로딩**
  * 클라이언트에서 커맨드 객체 생성
  * 인보커 setCommand()를 호출하여 인보커에 커맨드 객체를 전달받아 저장
  * 나중에 클라이언트에서 인보커에게 그 커맨드를 실행시켜 달라는 요청을 함

* **예제 코드 요약**

```java
public interface Command { // 커맨드 인터페이스
  // 모든 커맨드 객체는 같은 인터페이스를 구현해야 함
  public void execute();
}
```

```java
public class Light { // 리시버
// 요구 사항을 수행하기 위해 어떤 일을 처리해야 하는 지 알고 있는 객체
  public void on() {
    System.out.println("Light is on");
  }
  public void off() {
    System.out.println("Light is off");
  }
}
```

```java
public class LightOnCommand implements Command { // Command를 구현한 ConcreteCommand
// 특정 행동과 리시버 사이를 연결해 주는 역할
// 인보커에서 execute()호출을 통해 요청하면 ConcreteCommand객체에서 리시버에 있는 메소드를 호출
  public Light light;
  
  public LightOnCommand(Light light) {
    this.light = light;
  }
  
  @Override
  public void execute() {
    light.on();
  }
}
```

```java
public class SimpleRemoteControl { // 인보커(리모컨)
// 명령이 있으며 execute() 메소드를 호출함으로써 커맨드 객체에게 특정 작업을 수행해 달라는 요구를 함
  Command slot;
  
  public SimpleRemoteControl() { }
  
  public void setCommand(Command command) { // 슬롯을 가지고 제어할 명령을 설정하기 위한 메소드
    slot = command;
  }
  
  public void buttonWasPressed() { // 버튼이 눌리면 슬롯에 연결된 커맨드 객체의 execute()메소드 호출
    slot.execute();
  }
}
```

```java
public class RemoteControlTest { // 커맨드 패턴 클라이언트에 해당하는 부분
  public static void main(String[] args) {
    SimpleRemoteControl remote = new SimpleRemoteControl(); //  remote변수가 인보커(Invoker)
    
    Light light = new Light(); // 요청을 받아서 처리할 리시버(Receiver)인 Light객체를 생성
    LightOnCommand lightOn = new LightOnCommand(light); // 리시버를 전달하여 커맨드 객체를 생성
    
    remote.setCommand(lightOn); // 커맨드 객체를 인보커한테 전달
    remote.buttonWasPressed(); // 인보커가 커맨드 객체의 execute메소드를 호출
  }
}
```

![week6_02](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week6_02.jpg?raw=true)

## 커맨드 패턴

* **커맨드 패턴을 쓰면 어떤 작업을 요청한 쪽하고 그 작업을 처리 쪽을 분리시킬 수 있음**
* **요청 내역을 커맨드 객체로 캡슐화하여 클라이언트를 서로 다른 요청 내역에 따라 매개변수화 할 수 있음**
* 요청을 큐에 저장하거나 로그로 기록할 수도 있고 작업 취소 기능을 지원할 수도 있다


![week6_01](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week6_01.png?raw=true)

* 클라이언트는 ConcreteCommand를 생성하고 Receiver를 설정
* 리시버는 요구사항을 수행하기 위해 어떤 일을 처리해야 하는지 알고 있는 객체
* Command는 모든 커맨드 객체에서 구현해야 하는 인터페이스
  * 모든 명령은 execute() 메소드 호출을 통해 수행하되, 이 메소드에서는 리시버에 특정 작업을 처리하라는 지시를 전달
* 인보커에는 명령(Command)이 들어 있으며 execute()메소드를 호출함으로써 커맨드 객체에게 특정 작업을 수행해 달라는 요구를 함
* ConcreteCommand는 특정 행동과 리시버 사이를 연결해 줌
  * 어떤 요청을 처리하기 될 리시버에 대한 정보는 그 요청이 캡슐화되어 들어가는 커맨드 객체에 저장됨
  * 인보커에서 execute() 호출을 통해 요청을 하면 ConcreteCommand 객체에서 리시버에 있는 메소드를 호출함으로써 그 작업을 처리

```java
public void execute() { // ConcreteCommand 클레스 execute메소드
    reciever.action(); // 리시버에 있는 메소드를 호출하여 요청된 작업을 수행
}
```

* **커맨드 객체를 execute()에서 한번에 여러 동작을 캡슐화 가능**

```java
public class StereoOnWithCDCommand implements Command {
  Stereo stereo;
  
  public StereoOnWithCDCommand(Stereo stereo) {
    this.stereo = stereo;
  }
  @Override
  public void execute() { // 키고, 시디넣고, 볼륨조절하고
    stereo.on();
    stereo.setCd();
    stereo.setVolume(11);
  }
}
```

* **null 대신 사용하는 null 객체(null Object)**
  * 딱히 리턴할 객체는 없지만 클라이언트 쪽에서 null을 처리하지 않아도 되도록 하고 싶을 때 사용

```java
public class NoCommand implements Command {
  @Override
  public void execute() { }
  @Override
  public void undo() { }
}
```

* **리모컨 예제 코드 (인보커)**

```java
public class RemoteControl { 
  // 7개의 리모콘 on/off명령 처리를 위한 커맨드객체  배열
  Command[] onCommands;
  Command[] offCommands;
  
  public RemoteControl() {
    onCommands = new Command[7];
    offCommands = new Command[7];
    
    // NoCommand로 null 객체로 초기화
    Command noCommand = new NoCommand();
    for (int i=0; i < 7; i++) {
      onCommands[i] = noCommand;
      offCommands[i] = noCommand;
    }
  }
  
  public void setCommand (int slot, Command onCommand,  Command offCommand) {
    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }
  
  public void onButtonWasPushed(int slot) {
    onCommands[slot].execute();
  }
  
  public void offButtonWasPushed(int slot) {
    offCommands[slot].execute();
  }
  
  @Override
  public String toString() {
    StringBuffer stringBuff = new StringBuffer();
    stringBuff.append("\n----- Remote Control  -----\n");
    for (int i=0; i<onCommands.length; i++) {
      stringBuff.append("[slot " + i + "] " +  onCommands[i].getClass().getName() + " : "
          +  offCommands[i].getClass().getName() + "\n");
    }
    
    return stringBuff.toString();
  }
}
```

* **리모컨 예제 코드 (클라이언트)**

```java
public class RemoteLoader {
  public static void main(String[] args) {
    RemoteControl rc = new RemoteControl();
    
    Light livingRoomLight = new Light("Living Room");
    Light kitchenLight = new Light("Kitchen");
    Stereo stereo = new Stereo("Living Room");
    
    LightOnCommand2 livingRoomLightOn = new  LightOnCommand2(livingRoomLight);
    LightOffCommand livingRoomLightOff = new  LightOffCommand(livingRoomLight);
    
    StereoOnWithCDCommand sdwcdc = new  StereoOnWithCDCommand(stereo);
    StereoOffCommand soc = new  StereoOffCommand(stereo);
    
    rc.setCommand(0, livingRoomLightOn,  livingRoomLightOff);
    rc.setCommand(1, sdwcdc, soc);
    
    System.out.println(rc);
    
    rc.onButtonWasPushed(0);
    rc.offButtonWasPushed(0);
    
    rc.onButtonWasPushed(1);
    rc.offButtonWasPushed(1);
    
    rc.onButtonWasPushed(2);
    rc.offButtonWasPushed(2);
  }
}
```

![week6_03](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week6_03.png?raw=true)

* **undo**
  * 이전 작업을 수행하는 기능
  * 여러 번 undo를 하기 위해선 이 전에 실행한 커맨드들을 스택에 추가하면 됨

```java
public interface Command {
  public void execute();
  public void undo(); // 이전 작업 취소 메소드 추가
}
```

```java
public class LightOffCommand implements Command {
  Light light;
    
  public LightOffCommand(Light light) {
    this.light = light;
    }
    
    @Override
    public void execute() {
      light.off();
    }
    
    @Override
    public void undo() { // execute와 반대되는 작업을 수행
      light.on();
    }
}
```

```java
public class RemoteControl {
  Command[] onCommands;
  Command[] offCommands;
  Command undoCommand; // undo용 커맨드 추가
  
  public RemoteControl() {
    onCommands = new Command[7];
    offCommands = new Command[7];
    
    // NoCommand로 초기화
    Command noCommand = new NoCommand();
    for (int i=0; i < 7; i++) {
      onCommands[i] = noCommand;
      offCommands[i] = noCommand;
    }
    undoCommand = noCommand;
  }
  
  public void setCommand (int slot, Command onCommand,  Command offCommand) {
    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }
  
  public void onButtonWasPushed(int slot) {
    onCommands[slot].execute();
    undoCommand = onCommands[slot]; // 눌린 버튼의 커맨드를 저장
  }
  
  public void offButtonWasPushed(int slot) {
    offCommands[slot].execute();
    undoCommand = offCommands[slot]; // 눌린 버튼의 커맨드를 저장
  }
  
  public void undoButtonWasPushed() {
    undoCommand.undo(); // undo버튼 눌리면 이전 커맨드 undo
  }
  
  @Override
  public String toString() {
    StringBuffer stringBuff = new StringBuffer();
    stringBuff.append("\n----- Remote Control  -----\n");
    for (int i=0; i<onCommands.length; i++) {
      stringBuff.append("[slot " + i + "] " +  onCommands[i].getClass().getName() + " : "
          +  offCommands[i].getClass().getName() + "\n");
    }
      
    return stringBuff.toString();
  }
}
```

```java
public class RemoteLoader {
  public static void main(String[] args) {
    RemoteControl rc = new RemoteControl();
    
    Light livingRoomLight = new Light("Living Room");
    Light kitchenLight = new Light("Kitchen");
    Stereo stereo = new Stereo("Living Room");
    
    LightOnCommand2 livingRoomLightOn = new  LightOnCommand2(livingRoomLight);
    LightOffCommand livingRoomLightOff = new  LightOffCommand(livingRoomLight);
    
    StereoOnWithCDCommand sdwcdc = new  StereoOnWithCDCommand(stereo);
    StereoOffCommand soc = new  StereoOffCommand(stereo);
    
    rc.setCommand(0, livingRoomLightOn,  livingRoomLightOff);
    rc.setCommand(1, sdwcdc, soc);
    
    System.out.println(rc);
    
    rc.onButtonWasPushed(0);
    rc.offButtonWasPushed(0);
    
    System.out.println("----undo!----");
    rc.undoCommand.undo();
    System.out.println("-------------");
    
    rc.onButtonWasPushed(1);
    rc.offButtonWasPushed(1);
    
    rc.onButtonWasPushed(2);
    rc.offButtonWasPushed(2);
    
    rc.undoCommand.undo();
  }
}
```

![week6_04](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week6_04.png?raw=true)

* **작업취소 기능을 구현할 때 상태를 사용하는 방법**
  * CeilingFan 클래스 예제

```java
public class CeilingFan {
  public static final int HIGH = 3;
  public static final int MEDIUM = 2;
  public static final int LOW = 1;
  public static final int OFF = 0;
  
  String location;
  int speed;
  
  public CeilingFan(String location) {
    this.location = location;
    speed = OFF;
  }
  
  public void high() {
    speed = HIGH;
  }
  
  public void medium() {
    speed = MEDIUM;
  }
  
  public void low() {
    speed = LOW;
  }
  
  public void off() {
    speed = OFF;
  }
  
  public int getSpeed() {
    return speed;
  }
}
```

```java
public class CeilingFanHighCommand implements Command {
  CeilingFan ceilingFan;
  int prevSpeed; // 이전 속도를 저장하는 멤버 변수
  
  public CeilingFanHighCommand(CeilingFan ceilingFan) {
    this.ceilingFan = ceilingFan;
  }
  
  @Override
  public void execute() {
    prevSpeed = ceilingFan.getSpeed(); // 실행 시 이전 속도를 저장
    ceilingFan.high();
  }
  
  @Override
  public void undo() { // 이전 속도 멤버변수를 사용하여 undo
    switch (prevSpeed) {
    case CeilingFan.HIGH:
      ceilingFan.high();
      break;
    case CeilingFan.MEDIUM:
      ceilingFan.medium();
      break;
    case CeilingFan.LOW:
      ceilingFan.low();
      break;
    case CeilingFan.OFF:
      ceilingFan.off();
      break;
    }
  }
}
```

```java
public class RemoteLoader2 {
  public static void main(String[] args) {
    RemoteControl rc = new RemoteControl();
    
    CeilingFan ceilingFan = new CeilingFan("Living  Room ");
    
    CeilingFanHighCommand cfhc = new  CeilingFanHighCommand(ceilingFan);
    CeilingFanMediumCommand cfmc = new  CeilingFanMediumCommand(ceilingFan);
    CeilingFanOffCommand cfoc = new  CeilingFanOffCommand(ceilingFan);
    
    rc.setCommand(0, cfhc, cfoc);
    rc.setCommand(1, cfmc, cfoc);
    
    rc.onButtonWasPushed(0); // hight버튼
    rc.offButtonWasPushed(0); // 끔
    
    System.out.println(rc);
    rc.undoButtonWasPushed(); // off전 이전 속도인 high로 복원
    
    rc.onButtonWasPushed(1); // medium으로 변경
    
    System.out.println(rc);
    
    rc.undoButtonWasPushed(); // medium 이전 속도인 high로 undo
  }
}
```

![week6_05](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week6_05.png?raw=true)

* **여러 커맨드를 한 번에 수행하는 매크로 커맨드**
  * 우선 커맨드에 집어넣을 일련의 커맨드 객체들을 생성
  * on커맨드와 off커맨드를 위한 배열을 하나씩 만들고 객체들 전달
  * MacroCommand 객체를 버튼에 할당

```java
public class MacroCommand implements Command {
  Command[] commands;
  public MacroCommand(Command[] commands) {
    this.commands = commands;
  }
  @Override
  public void execute() {
    for(int i=0; i<commands.length; i++) {
      commands[i].execute();
    }
  }
  @Override
  public void undo() {
    for(int i=0; i<commands.length; i++) {
      commands[i].undo();
    }
  }
}
```

```java
public class RemoteLoader3 {
  public static void main(String[] args) {
    Light light = new Light("Living Room ");
    Stereo stereo = new Stereo("Living Room ");
    
    LightOnCommand2 lightOn = new  LightOnCommand2(light);
    LightOffCommand lightOff = new  LightOffCommand(light);
    StereoOnWithCDCommand stereoOn = new  StereoOnWithCDCommand(stereo);
    StereoOffCommand stereoOff = new  StereoOffCommand(stereo);
    
    // 일괄 처리할 커맨드 객체 배열을 생성
    Command[] partyOn = { lightOn, stereoOn };
    Command[] partyOff = { lightOff, stereoOff };
    
    MacroCommand partyOnMacro = new  MacroCommand(partyOn);
    MacroCommand partyOffCommand = new  MacroCommand(partyOff);
    
    RemoteControl rc = new RemoteControl();
    
    rc.setCommand(0, partyOnMacro, partyOffCommand);
    
    System.out.println("--- Pushing Macro On ---");
    rc.onButtonWasPushed(0); // Light, Stereo On을  한번에
    
    System.out.println("--- Pushing Macro Off ---");
    rc.offButtonWasPushed(0); // Light, Stereo Off를  한번에
  }
}
```

![week6_06](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week6_06.png?raw=true)

* **커맨드 패턴의 활용1 - 요청을 큐에 저장하기**
	* 커맨드를 이용하면 컴퓨테이션(Computation)의 한 부분(리시버와 일련의 행동)을 패키지로 묶어서 일급 객체 형태로 전달하는 것도 가능
		* 이러면 어떤 클라이언트 앱에서 커맨드 객체를 생성하고 나서 한참 후에도 그 컴퓨테이션을 호출할 수 있음
		* 다른 스레드에서 호출하는 것도 가능
	* **스케줄러나 스레드 풀, 작업 큐와 같은 다양한 용도에서 적용가능**
		* 작업큐를 예로 들면  큐 한쪽 끝은 커맨드를 추가할 수 있도록 되어 있고 그 큐의 다른 쪽 끝에는 커맨드를 처리하기 위한 스레드들이 대기하고 있음
  	* 각 스레드에서는 우선 execute()메소드를 호출하고 그호출이 완료되고 나면 커맨드 객체를 보내 버리고 새로운 커맨드 객체를 가져옴
  	* 이렇게 하면 컴퓨테이션을 효율적으로 고정된 개수의 스레드에 제한할 수 있음
  	* 작업 큐 클래스는 컴퓨팅 작업을 하는 객체들과 완전히 분리되어 있음

* **커맨드 패턴의 활용2 - 요청을 로그에 기록하기**
	* 어떤 앱에서는 모든 행동을 기록해놨다가 그 앱이 다운된 경우 나중에 그 행동들을 다시 호출해서 복구할 수 있도록 해야 함
	* 커맨드패턴을 사용하면 Command 인터페이스에 store()나 load()라는 메소드를 추가하여 이런 기능을 지원할 수 있음
		* 매번 데이터가 변경될 때마다 디스크에 저장하지 않고, 특정 체크 포인트 이후의 모든 행동을 로그에 기록하는 식으로 복구 시스템을 구축 가능
		* 일정 체크포인트마다 store()
		* 중간에 다운되면 load()를 불러 다시 복구하는 방식


## 6장 요약

* **커맨드 패턴**
	* **요청 내역을 커맨드 객체로 캡슐화하여 클라이언트를 서로 다른 요청 내역에 따라 매개변수화 할 수 있음**
	* 요청을 큐에 저장하거나 로그로 기록할 수도 있고 작업 취소 기능을 지원할 수도 있음
* **핵심 정리**
	* **커맨드 패턴을 이용하면 요청을 하는 객체와 그 요청을 수행하는 객체를 분리시킬 수 있음**
	* 이렇게 분리시키는 과정의 중심에는 커맨드 객체가 있으며, 이 객체가 행동이 들어있는 리시버를 캡슐화 함
		* 인보커에서는 요청을 할 때는 커맨드 객체의 execute()메소드를 호출하면 됨
		* execute() 메소드에서는 리시버에 있는 행동을 호출함
	* 인보커는 커맨드를 통해서 매개변수화될 수 있음
		* 이런 실행중에 동적으로 설정할 수도 있음
	* execute()메소드가 마지막으로 호출되기 전의 기존 상태로 되돌리기 위한 작업 취소 메소드를 구현하면 커맨드 패턴을 통해서 작업 취소 기능을 지원할 수도 있음
	* 매크로 커맨드는 커맨드를 확장해서 여러 개의 커맨드를 한꺼번에 호출할 수 있게 해 주는 간단한 방법
		* 매크로 커맨드에서도 어렵지 않게 작업 취소 기능을 지원할 수 있음
	* 프로그래밍을 하다 보면 요청자체를 리시버한테 넘기지 않고 자기가 처리하는 **"스마트" 커맨드 객체**를 사용하는 경우도 종종 있음
	* 커맨드 패턴을 활용하여 로그 및 트랜잭션 시스템을 구현하는 것도 가능




