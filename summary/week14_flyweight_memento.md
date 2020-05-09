# Week 14

## Fly Weight Pattern(플라이웨이트 패턴)
- 어떤 클래스의 인스턴스 한 개만 가지고 여러개의 "가상 인스턴스"를 제공하고 싶을 때 사용하는 패턴

### 시나리오
- 조경 설계 어플리케이션에서 나무를 객체 형태로 추가해야 함.
- 나무 객체는 X, Y 좌표를 가지고 있고, 나무의 좌표, 수령에 따라 알맞은 위치와 적당한 크기로 화면에 표시 됨

![scenario](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week14/rlawjddbs/tree_scenario.png)  
대강 모양을 보면 위 이미지와 같음  

### 패턴 적용없이 구현
#### Tree 클래스 다이어그램
![class diagram](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week14/rlawjddbs/tree1.png)

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
#### 문제점
- 복잡하지 않지만 본 애플리케이션의 문제는 나무를 많이 만들수록 눈에 띄게 느려짐


### 플라이웨이트 패턴으로 구현
#### Tree 클래스 다이어그램
![class diagram](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week14/rlawjddbs/tree2.png)

#### Tree 클래스를 인터페이스로 변경
```java
public interface Tree {
    public void display(int age, int x, int y);
}
```
#### Tree 인터페이스를 구현한 소나무, 바오밥나무 클래스
```java
// 소나무
public class PineTree implements Tree {
    @Override
    public void display(int age, int x, int y) {
        System.out.println("[소나무 수령 : " + age + "년 / x좌표 : " + x + "/ y좌표 : " + y + "]");
    } 
}

// 바오밥나무
public class BaobabTree implements Tree {
    @Override
    public void display(int age, int x, int y) {
        System.out.println("[바오밥나무 수령 : " + age + "년 / x좌표 : " + x + "/ y좌표 : " + y + "]");
    } 
} 
```
####  나무를 생성할 팩토리 메소드
```java
public class TreeFactory {
    private Tree pineTree, baobabTree = null;
    public TreeFactory() {
        this.pineTree = new PineTree();
        this.baobabTree = new BaobabTree();
    }
    public Tree getTree(String type) throws Exception {
        if (type.equals("pine")) {
            return this.pineTree;
        } else if (type.equals("baobab")) {
            return this.baobabTree;
        } else {
            throw new Exception("구할 수 없는 나무 종류 : " + type);
        }
    }
}
```
#### 클라이언트
```java
public class Client {
    public static void main(String[] args) {
        int[][] pineTrees = {{5, 2, 2}, {12, 6, 3}, {7, 8, 6}, {5, 2, 8}};
        int[][] baobabTrees = {{30, 7, 5}, {15, 1, 6}, {8, 9, 8}};
        TreeFactory treeFactory = new TreeFactory(); // creates the two flyweights
        Tree d, c;
        try {
            d = treeFactory.getTree("pine");
            c = treeFactory.getTree("baobab");
            for (int[] pineTree : pineTrees) {
                d.display(pineTree[0], pineTree[1], pineTree[2]);
            }
            for (int[] baobabTree : baobabTrees) {
                c.display(baobabTree[0], baobabTree[1], baobabTree[2]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
  
```
결과 콘솔 이미지
```


### 플라이웨이트 패턴 정리
#### 장점
- 위와 같이 동일하거나 비슷한 객체를 많이 사용해야 할 때 매번 새로운 객체를 생성하는 대신 하나의 객체를 공유하여 효율적으로 자원을 활용할 수 있음
- 객체의 수를 줄인다. 따라서 필요한 메모리의 크기를 줄인다.
- 객체가 지속되는 경우에 필요한 메모리 및 저장 장치의 양을 줄인다.

#### 단점
- 특정 인스턴스의 공유 컴포넌트를 개별적인 방식으로 행동하게 하는 것이 불가능하다.

#### 사용시기
- 응용프로그램이 많은 수의 객체를 사용하는 경우
- 물체의 수량으로 인해 저장비용이 높은 경우
- 응용프로그램이 객체 ID에 의존하지 않는 경우

#### 이거 팩토리 패턴 아닌가요?
- 팩토리 패턴은 객체 생성을 캡슐화하는 것
- 플라이웨이트 패턴은 팩토리 메소드를 사용했지만 비슷한 객체를 반복 생성하지 않고 단일한 객체를 반환하여 공유함으로서 저장 공간의 낭비를 최소화 하는 패턴
-------------------------------

## Memento(메멘토 패턴)

- 상태를 저장하는 구조
- 객체를 이전 상태에 되돌리는 기능(rollback)을 제공하는 디자인 패턴
- originator와 caretaker
- originator: 내부 상태를 가지는 객체
- caretaker: originator의 변경을 되돌리는 능력을 가지는 객체

메맨토 패턴은 객체의 상태 정보를 가지는 클래스를 따로 생성하여, 객체의 상태를 저장하거나 이전 상태로 복원할 수 있게 해주는 패턴이다. 메멘토 패턴은 바둑, 오목, 체스 등의 보드게임 등에서 '무르기' 기능을 구현할 때 사용되기도 한다.  
  
단, 이전 상태의 객체를 저장하기 위한 Originator가 클 경우 많은 메모리가 필요하다.  
