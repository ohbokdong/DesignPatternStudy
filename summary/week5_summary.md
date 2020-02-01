# Week 5 싱글턴 패턴 (Singleton Pattern) 

## 싱글턴 패턴 이란? 


특정 클래스에 대한 객체 인스턴스가 하나만 만들어 질 수 있도록 해주는 패턴

어디서든 인스턴스에 접근하도록 하기위한 패턴


**장점**

- 전역 변수 처럼 객체 인스턴스를 어디서든 액세스 할 수 있음.

- 필요 할때 객체 생성 가능


객체 인스턴스를 어떻게 하나만 생성하는가?


```java
public class Singleton
{
    private static Singleton uniqueInstance;

    private Singleton(){} //private 이라 내부에서만 생성 가능함.

    public static Singleton GetInstance()
    {
        if(uniqueInstance == null)
        {
            uniqueInstance = new uniqueInstance();
        }
        return uniqueInstance;
    }
}

```

**싱글턴의 인스턴트 생성 시기**

1. 인스턴스가 필요 할 때 생성.
```java
    if(uniqueInstance == null)
    {
        uniqueInstance = new uniqueInstance();
    }
```
인스턴스가 필요할 때 생성을 함. 이를 게으른 인스턴스 생성 이라 함.

2. 처음 부터 인스턴스 생성.
```java
    private static Singleton uniqueInstance = new Singleton();
```

---


## 멀티 스레드 상황에서의 싱글턴

멀티 스레드 환경에서 게으른 인스턴스 생성 방식으로 싱글턴을 사용할 경우 문제 발생 가능성이 있음.


![thread](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/Week5/thread.JPG?raw=true)


### 문제 해결방법 
1. 그냥 사용
2. 처음부터 인스턴스를 생성 하는 방법
3. 동기화 기법을 사용한 방법 (synchronized,DCL)


### synchronized를 이용한 방법.

```java
public static synchronized Singleton GetInstance()
{
    if(uniqueInstance == null)
    {
        uniqueInstance = new uniqueInstance();
    }
    return uniqueInstance;
}
```

인스턴스 생성 후 Thread 간 인스턴스를 받을 때 마다  불 필요 하게 Lock이 걸려 오버헤드가 생김

### DCL (Double-Checking Locking) 


```java
public class Singleton
{
    private volatile static Singleton uniqueInstance;

    private Singleton(){} //private 이라 내부에서만 생성 가능함.

    public static Singleton GetInstance()
    {
        if(uniqueInstance == null)
        {
            synchronized(Singleton.class)
            {
                if(uniqueInstance == null)
                {
                    uniqueInstance = new uniqueInstance();
                }
            }
        }
        return uniqueInstance;
    }
}
```

volatile와 synchronized를 이용하여 멀티스레드 환경에서 오버헤드에 대한 문제를 해결 할 수 있음.
위 문제를 파악 하기 위해선 쓰레드간 메모리 구조에 대한 이해가 필요함.
volatile 키워드를 통해 uniqueInstance는 메인 메모리에 생성 하고 사용함.

### LazyHolder Singleton

```java
public class Singleton {

     private Singleton(){} 

     public static Singleton getInstance() 
     {
        return LazyHolder.INSTANCE;
    } 
           
    private static class LazyHolder { 
        private static final Singleton INSTANCE = new Singleton(); 
    }             
}
```
Class의 초기화 과정은 Thread-safe를 보장 하기 때문에 별도의 동기화 기법 사용 없이 성능 및 단점을 보완함.

## 인스턴스란?

해당 클래스의 구조로 컴퓨터 저장공간에 할당 된 실체를 의미.

---

## 전역 변수란?

어느 지역 에서든 사용 할 수 있는 변수. 지역성 x

메모리 데이터영역에 저장됨.

사용하지 않을 경우 자원 낭비를 야기함.

### 메모리 구조

![Memory](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/Week5/Memory.JPG?raw=true)

![Memory](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/Week5/thread_memory.JPG?raw=true)

쓰레드 메모리 구조.
쓰레드가 생성 시 별도의 메모리를 할당 받음. volatile 키워드를 통해 공통의 메모리를 참조 하도록 함.



[JVM](https://jeong-pro.tistory.com/148)

---


