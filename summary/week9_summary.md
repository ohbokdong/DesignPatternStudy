# Week 9

## 이터레이터 패턴 (Iterator Pattern) 
* 클라이언트에게 컬렉션의 내부 구조를 노출하지 않으면서 원소들에 접근할 수 있는 방법을 제공하는 패턴
* 클라이언트로 부터 각기 다른 컬렉션(집합체)을 일획화하여 다룰 수 있는 방법을 제공
* 컬렉션의 모든 원소들에게 접근하기 위한 반복적인 작업을 **캡슐화**하여 컬렉션에서 분리시킬 수 있음  
  
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
    
    @Override
    public Object next() {
        MenuItem menuItem = items[position];
        position = position + 1;
        return menuItem;
    }
    
    @Override
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
// PancakeHouseIterator.java
public class PancakeHouseMenuIterator implements Iterator {
    ArrayList items;
    int position = 0;
	
    public PancakeHouseMenuIterator(ArrayList items) {
       this.items = items;
    } // basic constructor

    @Override
    public boolean hasNext() {
        if (position >= items.size() || items.get(position) == null) {
            return false;
        } else {
            return true;
        } // end else
    } 

    @Override
    public Object next() {
        MenuItem menuItem = (MenuItem)items.get(position);
        position = position + 1;
        return menuItem;
    }
} // class

// PancakeHouseMenu.java
public class PancakeHouseMenu {
    ArrayList menuItems;
	
    ... // 생성자, addItem 메소드 생략
	
//  public ArrayList getMenuItems() {
//      return menuItems;
//  }
	
    public Iterator createIterator() {
        return new PancakeHouseMenuIterator(menuItems);
    }
    
    ... // 기타 메뉴 관련 메소드 생략
} // class
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
  
![02](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week9_02.png)
  
위와 같이 PancakeHouseMenu와 DinerMenu 클래스가 Iterator 인터페이스의 구상 클래스를 사용한다는 가정하에 코드를 작성한다면 클라이언트 클래스 Waitress는 각각의 자료형에 맞춰 순환문을 두 번 사용하지 않고도 두 식당의 메뉴 항목 집합체를 동일한 방법으로 사용할 수 있게 된다.
  
### 2. Iterator 인터페이스 개선하기  
java.util.Iterator 인터페이스를 사용하도록 코드를 수정
  
#### 2-1. PancakeHouseMenu 코드 수정  
ArrayList의 createIterator() 메소드 사용(java.util.Iterator 형식의 객체를 반환해줌)
```java
    // PancakeHouseMenu.java
    ...
    
    public Iterator createIterator() {
    	// PancakeHouseMenu의 반복자 클래스는 더 이상 사용되지 않음.
        // return new PancakeHouseIterator(menuItems); 
        return menuItem.iterator();
    }
    
    ...
```
1-3 과정에서 만든 PancakeHouseMenuIterator 인터페이스의 구상 클래스는 더 이상 사용되지 않음.

#### 2-2. DinerMenuIterator 코드 수정
```java
// DinerMenuIterator.java

// java.util 패키지의 반복자 활용하기 
import java.util.Iterator;
public class DinerMenuIterator implements Iterator {
    MenuItem[] list;
    int position = 0;
	
    ... // 생성자, hasNext, next 메소드 생략 (1-2와 같음)
	
    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("next()를 한 번도 호출하지 않은 상태에서는 삭제할 수 없습니다.");
        } 
		
	if (list[position-1] != null) {
	    for(int i = position - 1; i < (list.length-1); i++) {
	    	// 배열의 값을 한칸씩 왼쪽으로 이동
                // 배열의 현재 index에 할당된 값을 다음 index에 할당 된 값으로 변경
                list[i] = list[i+1];
	    } 
	    // 배열의 마지막 index에 할당된 값은 null 처리
            list[list.length - 1] = null;
        } 
    } 
} // class
```
기존에 작성한 DinerMenuIterator 클래스와 크게 다른점은 없지만 직접 작성한 Iterator 인터페이스에서 import 를 사용하여 java.util.Iterator 를 사용하도록 한 부분과, remove 메소드를 구현해야한다는 점이 다르다.  
java.util.Iterator는 remove() 메소드가 포함되어 있기 때문에 해당 메소드의 구현을 생략할 순 없지만 메소드 실행중에   **java.lang.UnsupportedOperationException**을 던지도록 하는식으로 해당 기능을 제공하지 않는 방법을 사용할 수 있다.  

#### 2-3. 각 식당 메뉴를 캡슐화하기 위 Menu 인터페이스 작성, 웨이트리스 코드 수정
```java
// Menu.java
public interface Menu { 
    public Iterator createIterator();
}

// Waitress.java
import java.util.Iterator;
public class Waitress {
    Menu pancakeHouseMenu;
    Menu dinerMenu;
	
    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu) {
	this.pancakeHouseMenu = pancakeHouseMenu;
	this.dinerMenu = dinerMenu;
    } // basic constructor
	
    public void printMenu() {
	Iterator pancakeIterator = pancakeHouseMenu.createIterator();
	Iterator dinerIterator = dinerMenu.createIterator();
	System.out.println("메뉴\n----\n아침메뉴");
	printMenu(pancakeIterator);
	System.out.println("\n점심메뉴");
	printMenu(dinerIterator);
    } // printMenu
	
    // 외부 반복자 : 클라이언트(Waitress 객체)가 next()를 제어하는 경우
    private void printMenu(Iterator iterator) {
	while(iterator.hasNext()) {
	    MenuItem menuItem = (MenuItem)iterator.next();
	    System.out.print(menuItem.getName() + ", ");
	    System.out.print(menuItem.getPrice() + " -- ");
	    System.out.println(menuItem.getDescription());
	} 
    } 
} // class
```
![03](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week9_03.png)
  
PancakeHouseMenu와 DinerMenu 클래스에서는 Menu 인터페이스를 구현하도록 수정. Waitress 클래스는 각 메뉴 객체를 참조할 때 구상클래스 대신 인터페이스를 이용할 수 있게 된다. 이렇게 하면 **"특정 구현이 아닌 인터페이스에 맞춰서 프로그래밍한다."** 는 디자인 원칙을 따르게 되며 Waitress 클래스와 구상 클래스간의 의존성을 줄일 수 있다.  

### 3. 또 다른 방식의 컬렉션으로 MenuItem 항목을 관리하는 클래스가 추가될 경우
Hashtable의 형식으로 MenuItem의 집합체를 다루는 CafeMenu(저녁식사 메뉴)가 새롭게 합병된다고 가정.  

#### 3-1. CafeMenu의 메뉴 구성 클래스 다이어그램
![05](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week9_05.png)
  
  해시테이블 컬렉션은 키(key)와 값(value)의 쌍으로 구성됨. 기존의 방식들과는 다른 방식으로 iterator를 생성해야 함.
#### 3-2. CafeMenu 코드 재구성
```java
import java.util.Hashtable;
import java.util.Iterator;
public class CafeMenu implements Menu{
    Hashtable menuItems = new Hashtable();
	
    public CafeMenu() {
	addItem("베지 버거와 에어 프라이", "통밀빵, 상추, 토마토, 감자튀김이 첨가된 베지 버거", true, 3.99);
	addItem("오늘의 스프", "샐러드가 곁들여진 오늘의 스프", true, 3.99);
	addItem("베리또", "통 핀토콩과 살사, 구아카몰이 곁들여진 푸짐한 베리또", true, 3.99);
    } // basic constructor
	
    public void addItem(String name, String description, boolean vegetarian, double price) {
	MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
	menuItems.put(menuItem.getName(), menuItem);
    } 
	
//  public Hashtable getItems() {
//      return menuItems;
//  } 

    @Override
    public Iterator createIterator() {
	return menuItems.values().iterator();
    }
} // class
```
Hashtable은 키와 값을 지원하기 때문에 ArrayList보다 조금 복잡하지만 values() 메소드를 통해 값(MenuItem)에 해당하는 객체만 반환받을 수 있다.  또한 java.util.Iterator 형식의 객체를 반환하는 iterator() 메소드를 지원한다.
  
#### 3-3. 웨이트리스 코드 수정
반복을 캡슐화 했지만 웨이트리스 클래스는 두 가지 문제점이 있음
* printMenu()를 여러번 호출해야 함
* 새로운 메뉴가 추가될 때마다 Waitress에 코드를 추가해야함. OCP에 위배됨.
```java
// Waitress.java
import java.util.ArrayList;
import java.util.Iterator;

public class Waitress {
    ArrayList menus;
	
    public Waitress(ArrayList menus) {
	this.menus = menus;
    } // basic constructor
    
    public void printMenu() {
	Iterator menuIterator = menus.iterator();
	while(menuIterator.hasNext()) {
	    Menu menu = (Menu)menuIterator.next();
	    printMenu(menu.createIterator());
	} // end while
    } // printMenu
	
    // 외부 반복자 : 클라이언트(여기서는 Waitress 객체)가 next()를 제어하는 Iterator
    private void printMenu(Iterator iterator) {
	while(iterator.hasNext()) {
	    MenuItem menuItem = (MenuItem)iterator.next();
	    System.out.print(menuItem.getName() + ", ");
	    System.out.print(menuItem.getPrice() + " -- ");
	    System.out.println(menuItem.getDescription());
	} // end while
    } // printMenu
   
} // class
```
![04](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week9_04.png)
  
## 컴포지트 패턴 (Composite Pattern)
* 클라이언트에게 개별 객체와 복합 객체를 동일한 방법으로 다룰 수 있는 방법을 제공하는 패턴
* 복합 객체와 개별 객체를 모두 담아둘 수 있는 구조를 제공
* 컴포지트 패턴을 적용할 때는 여러 가지 장단점을 고려해야 하며, 상황에 따라 투명성과 안정성 사이에서 적절한 평형점을 찾아야 함
