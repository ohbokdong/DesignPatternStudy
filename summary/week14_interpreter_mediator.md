# 인터프리터 패턴
1. 정의 </br>
: 행동 패턴의 유형 중 하나 </br>
: 문법 규칙을 클래스화 한 구조</br>
: 일련의 규칙으로 정의된 언어를 해석하는 패턴</br>
: 특정 컨텍스트를 해석하도록 지시하는 표현 및 인터페이스를 구현하는 것 포함 </br>
: 예) SQL 구문, 통신 프로토콜

2. 인터프리터의 장점과 단점 </br>
- 장점 </br>
    - 각 문법 규칙을 클래스로 표현하기 때문에 언어를 쉽게 구현할 수 있다. </br>
    - 문법이 클래스에 의해 표현되기 때문에 언어를 쉽게 변경하거나 확장할 수 있다.</br>
    - 클래스 구조에 메소드만 추가하면 프로그램을 해석하는 기본 기능 외에 예쁘게 출력하는 기능이라든가, 더 나은 프로그램 확인 기능 같은 새로운 기능을 추가할 수 있다.</br>
    
-  활용법 및 단점 </br>
    - 간단한 언어를 구현할 때 인터프리터 패턴이 유용하게 쓰인다. </br>
    - 문법이 간단하고 효율보다는 단순하게 만드는 것이 더 중요한 경우에 유용합니다 </br>
    - 스크립트 언어 및 프로그래밍 언어에서 모두 쓸 수 있습니다. </br>
    - 문법 규칙의 개수가 많아지면 아주 복잡해진다는 단점이 있다. </br>
    (그런 경우 파서/컴파일러 생성기를 쓰는 것이 나음) 

3. 구현 방법 </br>
![interpreter](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week14/sgmsgood/interpreter.jpg)

Expression.java
```java
public interface Expression {
    public boolean interpret(String context);
}
```

TerminalExpresson.jaa
```java
public class TerminalExpression (String data) {
    private this.data = data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if(context.contains(data)) {
            return true;
        }
        return false;
    }
}
```

OrExpression.java
```java
public class OrExpression implements Expression {
	 
   private Expression expr1 = null;
   private Expression expr2 = null;

   public OrExpression(Expression expr1, Expression expr2) { 
      this.expr1 = expr1;
      this.expr2 = expr2;
   }

   @Override
   public boolean interpret(String context) {		
      return expr1.interpret(context) || expr2.interpret(context);
   }
}
```

AndExpression.java
```java
public class AndExpression implements Expression {
	 
   private Expression expr1 = null;
   private Expression expr2 = null;

   public AndExpression(Expression expr1, Expression expr2) { 
      this.expr1 = expr1;
      this.expr2 = expr2;
   }

   @Override
   public boolean interpret(String context) {		
      return expr1.interpret(context) && expr2.interpret(context);
   }
}
```
InterpreterPatternDemo.java
```java
public class Run {
    public static void main(String[] args) {
        Expression person1 = new TerminalExpression("Kushagra");
        Expression person2 = new TerminalExpression("Lokesh");
        Expression isSingle = new OrExpression(person1, person2);

        Expression vikram = new TerminalExpression("Vikram");
        Expression committed = new TerminalExpression("Committed");
        Expression isCommitted = new AndExpression(vikram, committed);

        System.out.println(isSingle.interpreter("Kushagra"));
        System.out.println(isSingle.interpreter("Lokesh"));
        System.out.println(isSingle.interpreter("Achint"));

        System.out.println(isCommitted.interpreter("Committed, Vikram"));
        System.out.println(isCommitted.interpreter("Single, Vikram"));
    }
}
```
result
```java
true
true
false
true
false
```

# Mediator 패턴
1. 정의 </br>
: 서로 관련된 객체 사이의 복잡한 통신과 제어를 한 곳으로 집중시키고자 하는 경우 사용

2. 미디에이터의 장점과 단점</br>
- 장점
    - 시스템하고 각 객체를 분리 -> 재사용성을 향상
    - 제어 로직을 한 군데로 모아놔서 관리하기가 쉬움
    - 시스템에 들어있는 객체 사이에서 오가는 메시지의 종류를 줄이고 단순화 시킬 수 있음

- 활용법 및 단점
    - 서로 연관된 GUI 구성요소들을 관리하기 위한 용도로 많이 쓰임
    - 디자인을 잘 하지 못하면 미디에이터 객체 자체가 너무 복잡해질 수 있음

3. 미디에이터 추가 전</br>
: 모든 객체들이 다른 객체들과 알고 있어야 함
![before_mediator](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week14/sgmsgood/BeforeMediator.jpg)

4. 미디에티어 추가 후</br>
: 미디에이터에는 모든 시스템을 제어할 수 있는 로직이 있음. 
: 새로운 가전제품을 가정 자동화 시스템에 추가해도, 미디에이터만 수정하면 됨.

![after_mediator](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week14/sgmsgood/AfterMediator.jpg)



ChatRoom.java
```java
public class ChatRoom {
   public static void showMessage(User user, String message){
      System.out.println(new Date().toString()
         + " [" + user.getName() +"] : " + message);
   }
}
```

User.java
```java
public class User {
  private String name;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public User(String name){
      this.name  = name;
   }

   public void sendMessage(String message){
      ChatRoom.showMessage(this,message);
   }
}
```

MediatorPatternDemo.java
```java
public class MediatorPatternDemo {
   public static void main(String[] args) {
      User robert = new User("Robert");
      User john = new User("John");

      robert.sendMessage("Hi! John!");
      john.sendMessage("Hello! Robert!");
   }
}
```
result
```java
Thu Jan 31 16:05:46 IST 2013 [Robert] : Hi! John! 
Thu Jan 31 16:05:46 IST 2013 [John] : Hello! Robert!
```
