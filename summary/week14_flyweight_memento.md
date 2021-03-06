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
- 복잡하지 않지만 본 애플리케이션의 문제는 나무를 많이 만들수록 느려짐

### 플라이웨이트 패턴으로 구현
#### Tree 클래스 다이어그램
![class diagram](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week14/rlawjddbs/tree3.png)

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
#### 클라이언트 클래스
```java
public class Client {
    public static void main(String[] args) {
        int[][] pineTrees = {{5, 2, 2}, {12, 6, 3}, {7, 8, 6}, {5, 2, 8}};
        int[][] baobabTrees = {{30, 7, 5}, {15, 1, 6}, {8, 9, 8}};
        TreeFactory treeFactory = new TreeFactory(); // creates the two flyweights
        Tree pine, baobab;
        try {
            pine = treeFactory.getTree("pine");
            baobab = treeFactory.getTree("baobab");
            for (int[] pineTree : pineTrees) {
                pine.display(pineTree[0], pineTree[1], pineTree[2]);
            }
            for (int[] baobabTree : baobabTrees) {
                baobab.display(baobabTree[0], baobabTree[1], baobabTree[2]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
![test result](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week14/rlawjddbs/flyweight_result.png)

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

#### 팩토리 패턴과의 차이점
- 팩토리 패턴은 객체 생성을 캡슐화하는 것
- 플라이웨이트 패턴은 팩토리 메소드를 사용했지만 비슷한 객체를 반복 생성하지 않고 단일한 객체를 반환하여 공유함으로서 저장 공간의 낭비를 최소화 하는 패턴
-------------------------------

## Memento(메멘토 패턴)
- 시스템에서 핵심적인 기능을 담당하는 객체의 중요한 상태 저장
- 핵심적인 객체의 캡슐화 유지
  
메맨토 패턴은 객체의 상태 정보를 가지는 클래스를 따로 생성하여, 객체의 상태를 저장하거나 이전 상태로 복원할 수 있게 해주는 패턴이다. 메멘토 패턴은 바둑, 오목, 체스 등의 보드게임 등에서 '무르기' 기능을 구현할 때 사용되기도 한다.
  
단일 역할 원칙(single responsibility principle)을 떠올려 본다면, 저장하고자 하는 상태를 핵심 객체로부터 분리시키는 것이 좋음.
상태를 따로 저장하는 역할을 맡는 객체를 **메멘토 객체**라고 부름.
  
### 메멘토 패턴 적용
#### 클래스 다이어그램
![class diagram](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week14/rlawjddbs/memento.png)
  
메멘토 패턴은 3개의 액터 클래스를 사용한다.  
1. Originator : 실제 상태를 가진 객체. Caretaker(클라이언트)의 요청(save)에 따라 자신의 상태를 저장한 Memento 객체를 생성한 후 Caretaker에게 반환한다. 또한 Caretaker에게 자신의 상태를 복원 요청(restore)하여 Caretaker가 저장해둔 Memento 객체를 받기도 한다. MasterGameObject 클래스에 해당.
2. Caretaker : Originator의 내부 상태를 저장(save)하고 복구(load)하기 위해 Originator의 상태를 저장한 Memento를 관리하는 클라이언트 클래스.
3. Memento : Originator의 상태를 저장하는 객체. Caretaker가 변경할 수 없거나 변경해서는 안 되기 때문에 불투명 자료형이라고도 한다. 위 그림에서 GameMemento 클래스에 해당.
  
#### Memento 클래스
```java
public class GameMemento {
    private String savedGameState;
    
    public GameMemento(String savedGameState) {
        this.savedGameState = savedGameState;
    }
    
    public String getSavedGameState() {
        return savedGameState;
    }
}
```
#### Originator 클래스
```java
public class MasterGameObject {
    private String gameState;

    public String getCurrentState() {
        return gameState;
    }

    public void setState(String gameState) {
        this.gameState = gameState;
    }
    
    public GameMemento saveToMemento() {
        return new GameMemento(gameState);
    }
    
    public void restoreByMemento(GameMemento gameMemento) {
        gameState = gameMemento.getSavedGameState();
    }
}
```
#### Caretaker 클래스
```java
public class Caretaker {
    private List<GameMemento> savedStates;
    
    public Caretaker() {
        savedStates = new ArrayList<GameMemento>();
    }
    
    public void save(GameMemento gameMemento) {
        savedStates.add(gameMemento);
    }
    
    public GameMemento load(int index) {
        return savedStates.get(index);
    }
    
    public int getLastSavedIndex() {
        return savedStates.size() - 1;
    }
}
```
#### 테스트
```java
public class GameDemo {
    public static void main(String[] args) {
        MasterGameObject mgo = new MasterGameObject();
        Caretaker careTaker = new Caretaker();
        
        // 레벨업 하면서 가끔씩 중간 세이브를 하는 상태
        mgo.setState("레벨업 - 레벨 7");
        mgo.setState("레벨업 - 레벨 8");
        careTaker.save(mgo.saveToMemento());
        
        mgo.setState("레벨업 - 레벨 9");
        careTaker.save(mgo.saveToMemento());
        
        mgo.setState("레벨업 - 레벨 10");
        System.out.println("현재 게임 상태... " + mgo.getCurrentState());
        
        // 죽음
        mgo.setState("죽음 - 레벨 0");
        System.out.println("현재 게임 상태... " + mgo.getCurrentState());
        
        // 가장 마지막에 저장된 시점으로 복구
        mgo.restoreByMemento(careTaker.load(careTaker.getLastSavedIndex()));
        System.out.println("현재 게임 상태... " + mgo.getCurrentState());
    }
}
```
#### 테스트 결과
![test result](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week14/rlawjddbs/memento_result.png)


### 메멘토 패턴 정리
#### 장점  
- 저장된 상태를 핵심 객체와는 다른 별도의 객체에 보관하기 때문에 안전함
- 핵심 객체의 데이터를 계속해서 캡슐화된 상태로 유지할 수 있음
- 복구 기능을 구현하기 쉬움

#### 단점
- 메멘토 객체를 써서 상태를 저장함
- 상태를 저장하고 복구하는 데 시간이 오래 걸릴 수 있음
- 자바 시스템에서는 시스템의 상태를 저장할 때 직렬화를 사용하는 것이 좋음
