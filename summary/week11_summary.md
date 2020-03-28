# Week 11 - Proxy Pattern

## Proxy Pattern의 정의

* **어떤 객체에 대한 접근을 제어하기 위한 용도로 대리인이나 대변인에 해당하는 객체를 제공하는 패턴**
* **원격 프록시(Remote Proxy)는** 일반적인 프록시 패턴(Proxy Pattern)을 구현하는 방법 가운데 하나
* 프록시에서 접근 제어하는 방법에 따라 여러 변종 패턴들이 존재
	* **원격 프록시**를 써서 원격 객체에 대한 접근을 제어할 수 있음
	* **가상 프록시(Virtual Proxy)를** 써서 생성하기 힘든 자원에 대한 접근을 제어
	* **보호 프록시(Protection Proxy)를** 써서 접근 권한이 필요한 자원에 대한 접근을 제어
  * 등등

![week11/img1]()

* **Proxy와 RealSubject 모두 Subejct 인터페이스를 구현**
	* 이렇게 하면 어떤 클라이언트에서든 프록시를 구현하기 때문에 ReaulSubject가 들어가야 할 자리에 Proxy를 대신 집어넣을 수 있음
* **실제 작업은 RealSubject 객체에서 처리됨**
* **Proxy는 이 객체의 대변인 역할을 하면서 이 객체에 대한 접근을 제어**
  * Proxy에는 RealSubject에 대한 레퍼런스가 들어 있음
	* Proxy에서 RealSubject를 생성하거나 제거하는 역할을 책임지는 경우도 있음
* 클라이언트는 항상 Proxy를 통해서 RealSubject하고 데이터를 주고 받음
* **Proxy는 RealSubject에 대한 접근을 제어하는 역할도 맡게 됨**
* RealSubject가 원격 시스템에서 돌아가거나, 그 객체를 생성하는 데 비용이 많이 들거나, 어떤 방식으로든지 RealSubject에 대한 접근이 통제되어 있는 경우 접근을 제어해주는 객체가 필요할 수도 있음

## 프록시 패턴 예제 - GumballMachine 원격 프록시

* [원격 프록시 이해를 위한 사전 지식 (RMI)]()

```java
import java.rmi.*;
public interface GumballMachineRemote extends Remote { // 원격 인터페이스
  public int getCount() throws RemoteException;
  public String getLocation() throws RemoteException;
  public State getState() throws RemoteException;
}
```

```java
public interface State extends Serializable { // 직렬화를 위해 상속
// 직렬화를 해야 네트워크를 통해 전송할 수 있음
  public void insertQuarter();
  public void ejectQuarter();
  public void turnCrank();
  public void dispense();
}
```

* 모든 State 객체에는 뽑기 기계의 메소드를 호출하거나 상태를 변경할 때 사용하기 위한 뽑기 기계에 대한 레퍼런스가 들어가 있음
  * 하지만 State 객체가 전송될 때 뽑기 기계도 전부 직렬화시켜 같이 보내는 것은 바람직하지 않음
  * **transient 키워드**를 사용하여 직렬화 제외시킴

```java
public class NoQuarterState implements State {
  transient GumballMachine gumballMachine;
...     
public class SoldOutState implements State {
  transient GumballMachine gumballMachine;
...
```

```java
import java.rmi.*;
import java.rmi.server.*;
public class GumballMachine extends UnicastRemoteObject  implements GumballMachineRemote {
  ...
  public GumballMachine(int numberGumballs, String location)  throws RemoteException { 
        // 기타 생성자 코드


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class GumballMachineTestDrive {
  public static void main(String[] args) { // args로 seoul 112 를 넣음
    int count = 0;
    
    if (args.length < 2) {
      System.out.println("GumballMachine <name>  <inventory>");
      System.exit(1);
    }
    
    try {
      count = Integer.parseInt(args[1]);
      GumballMachine gumballMachine = new  GumballMachine(count, args[0]);
      Registry registry =  LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
      registry.rebind(args[0], gumballMachine);
    } catch (Exception e) { // 생성자에서 RemoteException 던지므로 try catch처리
      e.printStackTrace();
    }
    ...
```

```java
import java.rmi.*;
public class GumballMonitor { // Client
  GumballMachineRemote machine; // 이제 구상 클래스 대신 원격 인터페이스를 사용
  
  public GumballMonitor(GumballMachineRemote machine) {
    this.machine = machine;
  }
  
  public void report() {
    try {
      System.out.println("뽑기 기계 위치 : " +  machine.getLocation());
      System.out.println("현재 재고 : " +  machine.getCount()+"개");
      System.out.println("현재 상태 : " +  machine.getState());
    } catch(RemoteException e) {
      e.printStackTrace();
    }
  }
}
```

```java
import java.rmi.*;
public class GumballMonitorTestDrive { // CEO는 이것만 실행시키면 됨
  public static void main(String[] args) {
    String[] location = { "seoul" };// 모니터링할 위치
        
    GumballMonitor[] monitor = new  GumballMonitor[location.length];
    
    for(int i=0; i<location.length; i++) {
      try {
          GumballMachineRemote machine =  (GumballMachineRemote) Naming.lookup(location[i]); // 각 기계에 대한 프록시가 필요
          monitor[i] = new GumballMonitor(machine);
          System.out.println(monitor[i]);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    for(int i=0; i<monitor.length; i++) { // 반복문을 돌려 보고서를 받아옴
      monitor[i].report();
    }
  }
}
```

![week11/img4]()


## 기타 프록시

* **방화벽 프록시**
	* 일련의 네트워크 자원에 대한 접근을 제어함으로써 주 객체를 "나쁜" 클라이언트들로부터 보호해 줌
* **스마트 레퍼런스 프록시(Smart Reference Proxy)**
	* 주 객체가 참조될 때마다 추가 행동을 제공
	* 객체에 대한 레퍼런스 개수를 센다든가 하는 식
* **캐싱 프록시(Caching Proxy)**
	* 비용이 많이 드는 작업의 결과를 임시로 저장해 줌
	* 여러 클라이언트에서 결과를 공유하게 해 줌으로써 계산 시간 또는 네트워크 지연을 줄여주는 효과가 있음
	* 웹 서버 프록시 또는 컨텐츠 관리 및 퍼블리싱 시스템에서 종종볼 수 있음
* **동기화 프록시(Synchronization Proxy)**
	* 여러 스레드에서 주 객체에 접근하는 경우 안전하게 작업을 처리할 수 있게 해 줌
	* 분산 환경에서 일련의 객체에 대한 동기화된 접근을 제어해주는 자바 스페이스에서 사용됨
* **복잡도 숨김 프록시(Complexity Hiding Proxy)**
	* 복잡한 클래스들의 집합에 대한 접근을 제어하고, 그 복잡도를 숨겨 줌
	* 퍼사드 프록시(Facade Proxy)라고 부르기도 함
		* 퍼사드 패턴과 차이점은 프록시에서 접근을 제어하지만 퍼사드 패턴에서는 대체 인터페이스만 제공한다는 점
* **지연 복사 프록시(Copy-On-Write Proxy)**
	* 클라이언트에서 필요로 할 떄까지 객체가 복사되는 것을 지연시킴으로써 객체의 복사를 제어
	* 변형된 가상 프록시
	* 자바5 CopyOnWriteArrayList에서 사용됨

## 11장 요약

* **프록시 패턴을 이용하면 어떤 객체에 대한 대변인을 내세워서 클라이언트의 접근을 제어할 수 있음**
	* 접근을 관리하는 방법에는 여러 가지가 있음
* **원격 프록시는** 클라이언트와 원격 객체 사이의 데이터 전달을 관리해 줌
* **가상 프록시는** 인스턴스를 만드는데 많은 비용이 드는 객체에 대한 접근을 제어함
* **보호 프록시는** 호출하는 쪽의 권한에 따라서 객체에 있는 메소드에 대한 접근을 제어함
  * 그 외에도 캐싱 프록시, 동기화 프록시, 방화벽 프록시, 지연 복사 프록시와 같은 다양한 변현됭 프록시 패턴이 있음
* 프록시 패턴의 구조는 데코레이터 패턴의 구조하고 비슷하지만 그 용도가 다르다는 차이가 있음
  * 데코레이터 패턴에서는 객체에 행동을 추가하지만 프록시 패턴에서는 접근을 제어함
* 자바에 내장된 프록시 지원 기능을 이용하면 동적 프록시 클래스를 즉석에서 만들어서 원하는 핸들러에서 호출을 처리하도록 할 수 있음
* 다른 래퍼를 쓸 때와 마찬가지로 프록시를 쓰면 디자인에 포함되는 클래스의 객체의 수가 늘어남

* **패턴 한 줄 요약**
  * **데코레이터 패턴** - 다른 객체를 감싸서 새로운 행동을 추가
  * **퍼사드 패턴** - 여러 객체를 감싸서 인터페이스를 단순화시킴
  * **프록시 패턴** - 다른 객체를 감싸서 접근을 제어
  * **어댑터 패턴** - 다른 객체를 감싸서 다른 인터페이스를 제공
