# Week 9

## 이터레이터 패턴 (Iterator Pattern) 
* 클라이언트에게 컬렉션 안의 내부 구조를 노출하지 않으면서 원소들에 접근할 수 있는 방법을 제공하는 패턴
* 클라이언트로 부터 각기 다른 컬렉션(집합체)을 일획화하여 다룰 수 있는 방법을 제공
* 컬렉션의 모든 원소들에게 접근하기 위한 반복적인 작업을 *캡슐화*하여 컬렉션에서 분리시킬 수 있음  
  

![01](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week9_01.png)  
PancakeHouseMenu와 DinerMenu는 동일한 메뉴 항목을 나타내는 MenuItem을 가지고 있으나 각각 ArrayList와 배열을 사용하기 때문에  MenuItem의 집합체를 다루는 방식이 다르다. Waitress 클라이언트 클래스는 PancakeHouseMenu, DinerMenu 객체가 가진 모든 MenuItem 항목을 출력하는 printMenu() 메소드가 있다.

```java
// Waitress 클래스의 printMenu() 메소드 소스
PancakeHouseMenu pancakeHouseMenu = new PancakHouseMenu();
ArryList breakfastItems = pancakeHouseMenu.getMenuItems();

DinerMenu dinerMenu = new DinerMenu();
MenuItem[] lunchItems = dinerMenu.getMenuItems();

for (int i = 0; i < breakfastItems.size(); i++){
    MenuItem menuItem = (MenuItem)breakfast.get(i);
    System.out.print(menuItem.getName() + " ");
    System.out.println(menuItem.getPrice() + " ");
    System.out.println(menuItem.getDescription() + " ");
}
for (int i = 0; i < lunchItems.length; i++){
    MenuItem menuItem = lunchItems[i];
    System.out.print(menuItem.getName() + " ");
    System.out.println(menuItem.getPrice() + " ");
    System.out.println(menuItem.getDescription() + " ");
}
```
Waitress 는 결국 위와 같은 방식으로 항상 두 식당의 메뉴를 이용할 때 각 아이템에 대해서 반복적인 작업을 수행하기 위해 두 개의 순환문을 써야 된다. 만약 MenuItem을 또 다른 방법으로 구현하는 레스토랑 클래스가 또 추가된다면 순환문이 세 개가 필요하게 된다.  

### 1. 반복작업의 캡슐화
서로 다른 자료형의 집합체를 가진 객체들일지라도 동일한 인터페이스에 의존하도록 수정한다면 반복작업을 캡슐화 할 수 있다.  
  
#### 1-1. Iterator 인터페이스 정의
```java
public interface Iterator {
    boolean hasNext();
    Object next();
}
```
#### 1-2. DinerMenu가 사용할 수 있는 구상 Iterator 클래스 정의 및 DinerMenu에서 사용하도록 코드 수정
```java
// DinerMenuIterator.java
public class DinerMenuIterator implements Iterator {
    MenuItem[] items;
    int position = 0;
    
    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    } // basic constructor
    
    public Object next() {
        MenuItem menuItem = items[position];
        position = position + 1;
        return menuItem;
    }
    
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }
} // class

// DinerMenu.java
public class DinerMenu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;
    
    ... // 생성자, addItem 메소드 생략
    
    // 제거된 getter 메소드. 내부 구조를 다 드러내는 단점이 있기 때문에 없앰.
//  public MenuItem[] getMenuItems() {
//      return menuItems;
//  }
    
    public Iterator createIterator() {
        return new DinerMenuIterator(menuItems);
    }    
    
    ... // 기타 메뉴 관련 메소드 생략
} // class
```
#### 1-3. PancakeHouseMenu가 사용할 수 있는 구상 Iterator 클래스 정의 및 PancakeHouseMenu에서 사용하도록 코드 수정
```java
    // TODO 코드 추가
```
  
#### 1-4. 웨이트리스 코드 고치기
```java
public class Waitress {
    ...
    public void printMenu(){
        Iterator pancakeHouseIterator = pancakeHouseMenu.createIterator();
        Iterator dinerIterator = dinerMenu.createIterator();
        
        printMenu(pancakeHouseIterator);
        printMenu(dinerIterator);
    }
    public void printMenu(Iterator iterator){
        while(iterator.hasNext()){
            MenuItem menuItem = (MenuItem)iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }
    ...
}
```
위와 같이 PancakeHouseMenu와 DinerMenu 클래스가 동일한 인터페이스인 Iterator를 구현하였다는 가정하에 코드를 작성한다면 클라이언트 클래스 Waitress는 각각의 자료형에 맞춰 순환문을 두 번 사용하지 않고도 두 식당의 메뉴 항목 집합체를 동일한 방법으로 사용할 수 있게 된다.
  
### 2. Iterator 인터페이스 개선하기  
java.util.Iterator 인터페이스를 사용하도록 코드를 수정
  
#### 2-1. PancakeHouseMenu 코드 수정  
ArrayList에 정의된 createIterator() 메소드 사용
```java
    // PancakeHouseMenu.java
    ...
    
    public Iterator createIterator() {
        return menuItem.iterator();
    }
    
    ...
```


## 컴포지트 패턴 (Composite Pattern)
* 클라이언트에게 개별 객체와 복합 객체를 동일한 방법으로 다룰 수 있는 방법을 제공하는 패턴
* 복합 객체와 개별 객체를 모두 담아둘 수 있는 구조를 제공
* 컴포지트 패턴을 적용할 때는 여러 가지 장단점을 고려해야 하며, 상황에 따라 투명성과 안정성 사이에서 적절한 평형점을 찾아야 함
