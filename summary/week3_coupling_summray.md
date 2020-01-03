# Week 2 추가 정리

## 강결합, 약결합(Tight Coupling, Loose Coupling)

* [강결합, 약결합 설명 출처](https://www.edureka.co/blog/coupling-in-java/)
* 결합(coupling)은 한 객체가 다른 객체에 의해 사용되는 상황을 나타내는 용어
  * 간단히 할당된 일을 위해 한 객체가 다른 객체를 요구한다는 의미
  * 때문에 모듈간 의존성(dependency)를 줄이는게 좋음
* **강결합(Tight Coupling)**
  * **한 클래스 그룹이 다른 클래스 그룹에 굉장히 의존적일 때 강결합이라고 함**

```java
// 강결합 예제 1
package tightcoupling;
 
class Volume {
      public static void main(String args[]) {
           // Volume클래스의 변화는 Box클래스에 영향을 줌, 상호의존적(interdependent)
           Box b = new Box(15, 15, 15);

           // Box클래스 멤버 volume을 직접 참조
           System.out.println(b.volume);

           b.volume = 10; // 이런식으로 Volume클래스에서 Box클래스 객체에 영향을 줄 수 있음
      }
}
 
class Box {
      public int volume;
      // 박스의 부피를 구하는 Box 클래스
      Box(int length, int width, int height) {
           this.volume = length * width * height;
      }
}
```

```java
// 강결합 예제2
package tightcoupling;
 
public class TCEx {
      public static void main(String args[]) {
           A a = new A();
           a.display();
      }
}
 
class A {
      B b;
      public A() {
            b = new B();
      }
      public void display() {
            System.out.println("A");

            // A클래스의 display메소드는 B클래스 display를 호출
            // B클래스 display내용이 변경되면 A클래스도 영향을 받음
            // ==> 강결합(Tight Coupling)
            b.display();
      }
}
 
class B {
       public B() {
       }
       public void display() {
             System.out.println("B");
        }
}
```

* **약결합(Loose Coupling)**
  * **한 객체가 다른 객체를 사용하기 위해 외부로부터 얻을 때 약결합이라고 함**
  * 객체들이 상호독립적(independent)
  * 약결합 코드는 유지보수를 쉽게 해줌
  

```java
// 약결합 예제1
package loosecoupling;
 
class Volume {
      public static void main(String args[]) {
           Box b = new Box(25, 25, 25);
           // getter를 사용해서 volume값을 얻어 옴
           // Box클래스 객체에 직접 참조가 불가능
           // 유지보수 쉬워짐 + 디버깅 쉬워짐
           System.out.println(b.getVolume());
      }
}
 
final class Box {
       private int volume;
       Box(int length, int width, int height) {
             this.volume = length * width * height;
       }
       public int getVolume() {
             return volume;
       }
}
```

```java
// 약결합 예제2
package loosecoupling;
 
import java.io.IOException;
 
public class LCEx {
      public static void main(String args[]) throws IOException {
           // A라는 클래스는 Show라는 인터페이스를 구현한 구상클래스 객체를 가질 뿐
           // 의존적이지 않음
           Show b = new B();
           Show c = new C();
           // b가 들어오면 B.display가 호출되고
           A a = new A(b);
           a.display();
           // c가 들어오면 C.display를 호출할 뿐
           A a1 = new A(c);
           a1.display();

           // 결과는 ABAC
      }
}
 
interface Show {
      public void display();
}
 
class A {
      Show s;
      public A(Show s) {
           this.s = s;
      }
      public void display() {
           System.out.println("A");
           s.display();
       }
}
 
class B implements Show {
       public B() {
       }
       public void display() {
            System.out.println("B");
       }
}
 
class C implements Show {
       public C() {
       }
       public void display() {
            System.out.println("C");
       }
}
```
