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
 &nbsp; 인스턴스가 필요할 때 생성을 함. 이를 게으른 인스턴스 생성 이라 함.

2. 처음 부터 인스턴스 생성.
```java
    private static Singleton uniqueInstance = new Singleton();
```

---

## 인스턴스란?

해당 클래스의 구조로 컴퓨터 저장공간에 할당 된 실체를 의미.

---

## 전역 변수란?

어느 지역 에서든 사용 할 수 있는 변수. 지역성 x

메모리 데이터영역에 저장됨.

사용하지 않을 경우 자원 낭비를 야기함.

### 메모리 구조

![Memory](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/Week5/Memory.JPG?raw=true)


[JVM](https://jeong-pro.tistory.com/148)

---


