# Week 14

## Fly Weight Pattern(플라이웨이트 패턴)
- 어떤 클래스의 인스턴스 한 개만 가지고 여러개의 "가상 인스턴스"를 제공하고 싶을 때 사용하는 패턴

### 시나리오
- 조경 설계 어플리케이션에서 나무를 객체 형태로 추가해야 함.
- 나무 객체는 X, Y 좌표를 가지고 있고, 나무의 좌표, 수령에 따라 알맞은 위치와 적당한 크기로 화면에 표시 됨

[scenario](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week14/rlawjddbs/tree_scenario.png?raw=true)
대강 모양을 보면 위 이미지와 같음  

### 패턴 적용없이 구현
#### Tree 클래스 다이어그램
[scenario](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week14/rlawjddbs/tree1.png?raw=true)

#### Tree 클래스와 클라이언트 코드
```java
// Tree
public class Tree {
    private String treeName;
    private int age, xCoord, yCoord;
    
    private Tree() {
    }
    
    public Tree(String treeName, int age, int xCoord, int yCoord) {
        this.treeName = treeName;
        this.age = age;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public void display() {
        System.out.println("[" + treeName + " - 수령:" 
        + age + "년 / x:" + xCoord + " / y:" + yCoord + "]");
    }
}

// Client
public class Client {
    public static void main(String[] args) {
        Tree pineTree1 = new Tree("소나무", 5, 2, 2);
        Tree pineTree2 = new Tree("소나무", 12, 6, 3);
        Tree pineTree3 = new Tree("소나무", 7, 8, 6);
        Tree pineTree4 = new Tree("소나무", 5, 2, 8);
        Tree baobabTree1 = new Tree("바오밥나무", 30, 7, 5);
        Tree baobabTree2 = new Tree("바오밥나무", 15, 1, 6);
        Tree baobabTree3 = new Tree("바오밥나무", 8, 9, 8);
        
        pineTree1.display();
        pineTree2.display();
        pineTree3.display();
        pineTree4.display();
        baobabTree1.display();
        baobabTree2.display();
        baobabTree3.display();
    }
}
```
복잡하지 않지만 본 애플리케이션의 문제는 나무를 많이 만들수록 눈에 띄게 느려짐

### 플라이웨이트 패턴으로 구현


### 왜 플라이웨이트 패턴을 사용해야 하나?
- 위와 같이 동일하거나 비슷한 객체를 많이 사용해야 할 때 매번 새로운 객체를 생성하는 대신 하나의 객체를 공유하여 효율적으로 자원을 활용할 수 있음

#### 장점
- 객체의 수를 줄인다.
- 객체가 지속되는 경우에 필요한 메모리 및 저장 장치의 양을 줄인다.

#### 단점
- 플라이 웨이트 패턴은 객체들을 공유하므로, 만약 객체들간 동일성 여부 테스트가 프로그램 내에서 사용될 경우에는 개념적으로 서로 다른 객체라 하더라도 동일한 것으로 판단할 수 있기 때문에 문제의 소지가 된다.  따라서 플라이 웨이트 패턴을 사용하는 프로그램은 객체들간 동일성 여부 테스트를 사용하지 않아야 한다. 

#### 사용시기
- 응용프로그램이 많은 수의 객체를 사용하는 경우
- 물체의 수량으로 인해 저장비용이 높은 경우
- 응용프로그램이 객체 ID에 의존하지 않는 경우

-------------------------------

## Memento(메멘토 패턴)

- 상태를 저장하는 구조
- 객체를 이전 상태에 되돌리는 기능(rollback)을 제공하는 디자인 패턴
- originator와 caretaker
- originator: 내부 상태를 가지는 객체
- caretaker: originator의 변경을 되돌리는 능력을 가지는 객체

메맨토 패턴은 객체의 상태 정보를 가지는 클래스를 따로 생성하여, 객체의 상태를 저장하거나 이전 상태로 복원할 수 있게 해주는 패턴이다. 메멘토 패턴은 바둑, 오목, 체스 등의 보드게임 등에서 '무르기' 기능을 구현할 때 사용되기도 한다.  
  
단, 이전 상태의 객체를 저장하기 위한 Originator가 클 경우 많은 메모리가 필요하다.  
