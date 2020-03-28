# Week 11 - 프록시 보충 RMI

## RMI(Remote Method Invocation, 원격 함수 호출)

* **RMI는 자바 프로그램에서 각 객체간, 컴퓨터간 메서드를 호출할 수 있게 해주는 기술**
  * 서로 다른 JVM 상에 있는 객체의 메소드를 호출함
  * RMI는 전송 계층을 은폐하여 투명성 보장
  * 소켓상의 통신
* 자바는 java.rmi 패키지를 제공, 이는 자바 원격 함수 호출 API(Java RMI)로 자바 응용 프로그램을 짜는 인터페이스

## 원격 프록시

![week11/img3]()

* **원격 프록시는 원격 객체에 대한 로컬 대변자 역할**
* **원격 객체(Remote Object)란** 다른 자바 가상 머신의 힙에서 살고 있는 객체
  * 조금 더 일반적으로 얘기하자면 다른 주소 공간에서 돌아가고 있는 원격 객체
* **로컬 대변자(Local Representative)는** 어떤 메소드를 호출하면 다른 원격 객체한테 그 메소드를 호출을 전달해주는 역할을 맡고 있는 객체

![week11/img2]()

* 클라이언트 입장에서 대신 통신을 처리해 주는 **보조 객체(Client Helper/ Proxy/ RMI Stub)가 필요**
	* 클라이언트 보조 객체의 메소드를 호출하면 클라이언트 입장에서는 그 보조 객체가 실제 서비스를 제공한다고 생각하는 것
	* 클라이언트 객체는 원격 서비스에 있는 메소드를 호출한다고 생각하고 작업을 처리
* 클라이언트 보조 객체에서는 서버에 연락을 취하고 메소드 호출에 대한 정보(메소드 이름, 인자 등)를 전달하고 서버로부터 리턴되는 정보를 기다림
* 서버 쪽에서는 **서비스 보조 객체(Service Helper/ RMI Skeleton)가** 있어 (Socket 연결을 통해서) 클라이언트 보조 객체로 부터 요청을 받아오고, 호출에 대한 정보를 해석해서 진짜 서비스 객체에 있는 진짜 메소드를 호출함
	* 서비스 객체 입장에서는 메소드 호출이 원격 클라이언트가 아닌 로컬 객체로부터 들어오는 셈
	* 서비스 보조 객체는 서비스로부터 리턴값을 받아 (Socket 출력 스트림을 통해) 클라이언트 보조 객체한테 전송
	* 클라이언트 보조 객체에서는 그 정보를 해석해서 리턴값을 클라이언트 객체한테 리턴
* **클라이언트 객체는 진짜 서비스의 메소드를 호출한다고 생각**
	* 클라이언트 보조 객체에서 실제로 자신이 원하는 작업을 처리한다고 생각
	* 클라이언트 보조 객체는 서비스인 척 하고 있지만 실제로는 진짜 객체에 대한 프록시일 뿐
* **서비스 보조 객체에서는 클라이언트 보조 객체로부터 요청을 받아서 그 내용을 해석하여 진짜 서비스에 있는 메소드를 호출**
	* 서비스 객체가 진짜 서비스, 실제 작업을 처리하는 메소드가 들어있음

## 원격 서비스 만드는 5단계

1. 원격 인터페이스 만들기
2. 서비스 구현 클래스 만들기
3. rmic를 이용하여 스터브와 스켈레톤 만들기
4. RMI 레지스트리(rmiregistry)를 실행
5. 원격 서비스 시작

```java
// 1. 원격 인터페이스 만들기
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SampleRMI extends Remote { // java.rmi.Remote 상속
	public int doSomething() throws RemoteException; // 문제 시 RemoteException 던짐
}
```

```java
// 2. 서비스 구현 클래스 만들기
// doSomething이 호출되면 counter란 멤버변수를 ++시키는 메서드를 갖는 서비스 구현 클래스
// 원격으로 호출할 때마다 counter가 ++될 거
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SampleRMIObj extends UnicastRemoteObject implements SampleRMI, Serializable {
    // UnicastRemoteObject를 상속
    // 원격 인터페이스 구현, 직렬화 사용하므로 Serializable 구현
	private static final long serialVersionUID = 1L;

	private int counter;
	
	protected SampleRMIObj() throws RemoteException {
		super();
	}

	@Override
	public int doSomething() throws RemoteException {
		counter++;
		System.out.println("do something here. counter is " + counter);
		return counter;
	}
}
```

```java
// 3. rmic를 이용하여 스터브와 스켈레톤 만들기(생략)
// 4. RMI 레지스트리(rmiregistry)를 실행(생략)
// rmic 커맨드로 서비스 구현 클래스의 stub, skeleton을 만들고
// rmiregistry를 실행시킨 후 서비스 구현 클래스를 등록하나
// 이 예제에서는 rmic커맨드 생략하고 바로 서비스를 rmiregistry에 등록
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIRegister {
	
	public static void main(String[] args) throws RemoteException {
		
		SampleRMI rmi = new SampleRMIObj();
		
		int counter = rmi.doSomething();
		System.out.println("server counter is " + counter);
		
		Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		
		registry.rebind("sample", rmi);
		
		System.out.println("ok rmi object is registed");
	}
}
```

```java
// 5. 원격 서비스 시작
// rmiregistry에서 "sample"에 해당하는 객체를 가져와서 메소드를 호출
import java.rmi.Naming;
import java.rmi.Remote;

public class RMIClient {

	public static void main(String[] args) throws Exception {
        // 클라이언트는 Naming.lookup메소드를 이용하여 rmiregistry에서 스터브 객체를 요청
        // 캐스팅해서 사용
		Remote r = (Remote)Naming.lookup("sample");
		SampleRMI rmi = (SampleRMI)r;
		
		int counter = rmi.doSomething();
		System.out.println("client counter is " + counter);
	}
}
```

* **작동방식**
  
1. 클라이언트에서 RMI 레지스트리를 룩업
2. RMI레지스트리에서 스터브 객체를 리턴
3. 클라이언트에서 스터브에 대해 메소드를 호출, 스터브가 진짜 서비스 객체라고 생각해도 됨

* **클라이언트에서 스터브 클래스를 가져오는 방법?**
  * **클라이언트에서 룩업을 하려면 어떤 식으로던 (rmic를 써서 만들어낸) 스터브 클래스를 보유하고 있어야 함**
  * 클래스가 없이는 스터브를 가져와도 역직렬화를 할 수 없어 메소드도 호출할 수 없음
    * 그리고 원격 객체를 호출한 결과로 리턴되는 직렬화된 객체의 클래스도 있어야 함
  * **간단한 시스템에서는 그냥 클래스를 직접 클라이언트로 복사해도 됨**
  * **직접 클래스를 복사하지 않고 클래스를 받는 "동적 클래스 다운로딩(Dynamic Class Downloading)"이란 방법이 있음**
    * (스터브 같은) 직렬화된 객체에 그 객체의 클래스 파일이 있는 위치를 나타내는 URL을 내장
    * 역직렬화 과정에서 로컬 시스템에서 클래스 파일을 찾지 못하면 내장된 URL로부터 HTTP GET 요청을 통해 클래스 파일을 가져옴
      * 클래스 파일을 보내줄 수 있는 웹서버가 필요하고 클라이언트의 보안 매개변수를 변경해야 할 수도 있음

## 참고자료

* [RMI 정리](http://jo.centis1504.net/?p=1547)