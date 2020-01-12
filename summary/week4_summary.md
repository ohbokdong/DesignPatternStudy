# Week 4

## 팩토리 패턴 (Factory Pattern) 

* **구상클래스**
  * 추상 클래스와 반대되는 개념으로 이해
  * 추상 클래스 <--> 구현을 제공하지 않는 operation(method)을 갖는 클래스
  * 구상클래스 <--> 모든 operation이 구현을 제공하는 클래스
  * **구상 객체**는 new를 사용하여 구상 클래스의 인스턴스를 만드는 것. 인터페이스가 아닌 특정 구현을 사용하는 것.

## 팩토리 메소드 패턴
* **객체 생성**을 캡슐화 하는 것.
* 어떤 클래스의 인스턴스를 만들어내는 일은 서브클래스에서 처리. 팩토리 메소드 패턴을 이용한다는 것은 클래스의 인스턴스 생성을 서브클래스에게 맡기는 것.
    
### 팩토리 메소드 패턴의 원칙 가이드라인
  * 어떤 변수에도 구상 클래스에 대한 레퍼런스를 저장하지 않는다.
  * 구상 클래스에서 유도된 클래스를 만들지 않는다.
  * 베이스 클래스에 이미 구현되어 있던 메소드를 오버라이드하지 않는다.

## 추상 팩토리 패턴
* 인터페이스를 이용하여 서로 연관된, 또는 의존하는 객체를 구상 클래스를 지정하지 않고도 생성.
  
new 연산자를 사용하는 것은 구상 클래스의 인스턴스를 만드는 것. 인터페이스가 아닌 특정 구현을 사용하게 되는 것.
일련의 구상 클래스들이 있을 때 어쩔 수 없이 다음과 같은 코드를 만들어야 하는 경우가 있음.  


```JAVA
Duck duck;
if( type == picnic ){
    duck = new MallardDuck();
} else if( type == hunting ){
    duck = new DecoyDuck();
} else if ( type == inBathTub ){
    duck = new RubberDuck();
}
```
이런 코드가 있다는 것은, 뭔가 변경하거나 확장해야 할 때 코드를 다시 확인하고 추가 또는 제거해야 한다는 것을 뜻함.
코드를 이런식으로 만들면 관리 및 갱신하기 어려워지고, 오류가 생길 가능성도 높아지게 됨.

인터페이스에 맞춰서 코딩을 하면 시스템에서 일어날 수 있는 여러 변화를 이겨낼 수 있음. 인터페이스를 바탕으로 코드를 만들면, 다형성 덕분에 어떤 클래스든 특정 인터페이스만 구현하면 사용할 수 있기 때문.  
  
반대로 코드에서 구상클래스를 많이 사용하면 새로운 구상 클래스가 추가될 때 마다 코드를 고쳐야 하기 때문에 수많은 문제가 생길 수 있음. 즉 "변화에 대해 닫혀있는" 코드가 되는 것.

피자 가게를 클래스화 한다고 가정하였을 때, 해당 클래스 내부에 피자를 주문하는 메소드가 있다면 이렇게 구성할 수도 있을 것이다.

```JAVA
Pizza orderPizza(String type){
    Pizza pizza;
    
    if( type.equals("cheese") ){
        duck = new CheesePizza();
    } else if( type.equals("greek") ){
        duck = new GreekPizza();
    } else if ( type.equals("pepperoni") ){
        duck = new PepperoniPizza();
    }
    
    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();
    return pizza;
}
```
위 코드에서 if문에 해당되는 부분이 매번 바뀔 수 있는 부분. 해당 객체 생성 부분을 캡슐화하기 위해 팩토리 클래스를 만들어본다.

```JAVA
public class SimplePizzaFactory{
    public Pizza createPizza(String type){
        Pizza pizza = null;

        if( type.equals("cheese") ){
            duck = new CheesePizza();
        } else if( type.equals("greek") ){
            duck = new GreekPizza();
        } else if ( type.equals("pepperoni") ){
            duck = new PepperoniPizza();
        }

    }
}
```

```JAVA
Pizza orderPizza(String type){
Pizza pizza;

// 본 메소드에서는 더 이상 피자 객체를 생성하지 않는다.
// if( type.equals("cheese") ){
//  duck = new CheesePizza();
// } else if( type.equals("greek") ){
//  duck = new GreekPizza();
// } else if ( type.equals("pepperoni") ){
//  duck = new PepperoniPizza();
// }

// 대신 팩토리를 사용하여 피자 객체를 만든다.
pizza = simplePizzaFactory.createPizza(type);

pizza.prepare();
pizza.bake();
pizza.cut();
pizza.box();
return pizza;
}
```
간단한 팩토리(Simple Factory)는 디자인 패턴이라고 할 수는 없다. 프로그래밍을 하는데 있어 자주 쓰이는 관용구에 가깝다.

### 간단한 팩토리 클래스 다이어그램
![01](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week4_01.png)


피자 가게가 프랜차이즈를 운영하게 되면서, 다른 지점에서도 지역별 차이를 반영하여 피자를 만들어내야 하는 문제가 생겼다.
뉴욕 스타일, 시카고 스타일 등의 다른 스타일의 피자를 만들게 되었을 때  SimplePizzaFactory를 빼고 지역별로 서로 다른 팩토리( NYPizzaFactory, ChicagoPizzaFactory )를 만들어 사용한다면 아래와 같을 것이다.

```JAVA
NYPizzaFactory nyFactory = new NYPizzaFactory();
PizzaSotre nyStore = new PizzaStore(nyFactory);
nyStore.order("veggie");

ChicagoPizzaFactory chicagoFactory = new ChicagoPizzaFactory();
PizzaStore chicagoStore = new PizzaStore(chicagoFactory);
chicagoStore.order("veggie");
```

위와 같은 방식으로 지점별로 각기 다른 팩토리 클래스를 사용할 경우, 분점별로 독자적인 방법들을 사용하기 시작한다는 문제점이 생긴다. 즉, 피자 가게와 피자 제작 과정 전체를 하나로 묶어주는 프레임워크를 만들어야 한다는 결론이 나온다. 그와 동시에 유연성을 잃어버리면 안 될 것이다.

## 피자 가게 프레임워크
```JAVA
public abstract class PizzaStore{
    public Pizza orderPizza(String type){
        Pizza pizza;
        
        pizza = createPizza(type);
        
        pizza.prepare();
        pizza.back();
        pizza.cut();
        pizza.box();
        
        return pizza;
    }
    
    // 지점별 팩토리 클래스 대신 추상메소드 사용
    abstract Pizza createPizza(String type);
}
```

위와같이 PizzaStore 클래스의 orderPizza() 메소드에 주문 시스템을 갖춰놓는다. 이는 모든 분점에서 주문 시스템이 똑같이 진행되어야 하기 때문이다. 

![02](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week4_02.png)

이제 각 분점마다 달라질 수 있는 것은 피자의 스타일 뿐이다. 
