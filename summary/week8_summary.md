# 템플릿 메소드 패턴
## 1. 템플릿 메소드 패턴이란?
* 메소드에서 일련의 알고리즘의 골격을 정의합니다.
* 그 중 한 개 이상의 단계가 서브클래스에 의해 제공될 수 있습니다.
* 서브클래스에서 일부분을 구현할 수 있도록 하면서도 알고리즘의 구조는 바꾸지 않아도 되도록 할 수 있습니다.
```java
public abstract class CaffeineBeverage {
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}
	
	abstract void brew();
	abstract void addCondiments();
	
	void boilWater() {
		System.out.println("물 끓이는 중");
	}
	
	void pourInCup() {
		System.out.println("컵에 따르는 중");
	}
}
```

## 2. 템플릿 메소드와 후크
1. 후크 (hook)란? </br>
* 추상클래스에서 선언되는 메소드
* 기본적인 내용만 구현 (또는, 아무 코드도 들어있지 않은 메소드)*
2. 후크를 사용해야 하는 경우?
* 서브클래스에서 알고리즘의 특정 단계를 제공해야만 하는 경우에 사용합니다.
    * 즉, 알고리즘에서 필수적이지 않은 부분을 필요에 따라 서브클래스에서 구현하든 말든 하는 경우에 사용하면 됩니다.
* 템플릿 메소드에서 앞으로 일어날 일 또는 막 일어난 일에 대해 서브클래스에서 반응할 기회를 제공하기 위한 용도로도 사용 가능합니다.
    * 예로, 내부적으로 어떤 목록을 재정렬한 후에 서브클래스에서 어떤 작업(화면상에 표시되는 내용을 다시 보여주는 등)을 수헹하고 싶은 경우에 justReOrderedList()후크 메소드를 사용할 수 있습니다.
* 서브클래스에 추상 클래스에서 진행되는 작업에 대한 결정을 내리는 기능을 부여하기 위한 용도로 후크를 쓸 수도 있습니다.

```java
public abstract class CaffeineBeverageWithHook {
	void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		
		/*
		 * customerWantsCondiments()라는 구상 메소드에 의해 실행여부가 결정되는 조건문 추가.
		 * 손님이 첨가물을 넣어달라고 했을 때만, customerWantsCondiments()에서 참이 리턴되면
		 * addCondiments()를 호출합니다.*/
		if(customerWantsCondiments()) {
			addCondiments();
		}
	}
	
	abstract void brew();
	abstract void addCondiments();
	
	void boilWater() {
		System.out.println("물 끓는 중");
	}
	
	void pourInCup() { 
		System.out.println("컵에 따르는 중");
	}
	
	boolean customerWantsCondiments() {
		return true;
	}
}
```

## * 템플릿 메소드를 사용할 때 주의해야할 점 * 
* 추상 클래스를 상속받은 서브클래스는 추상 클래스의 메소드를 모두 구현해야 합니다. 
* 추상 메소드가 너무 많아지면 서브클래스에서 일일이 구현을 해줘야하므로 유지보수가 힘들어질 가능성이 커집니다. 
    * 이런 경우, 
    1. 알고리즘의 단계를 너무 잘게 쪼개지 않는 방법을 사용할 수 있습니다.
        * 유연성이 떨어지는 문제가 있을 수 있습니다.
    2. 모든 단계가 반드시 필수적인 것은 아니라는 것을 기억하세요. 
        * 위에서 배운 후크를 이런 경우에 적용할 수 있습니다.

## 할리우드 원칙 (의존성 부패 방지)
* "먼저 연락하지 마세요. 저희가 연락 드리겠습니다."
    * 의존성 부패? </br>
        * 고수준 구성요소가 저수준 구성요소에 의존하고, 저수준 구성요소는 다시 고수준 구성요소에 의존하고, 고수준 구성요소는 다시 구성요소에 의존하여 어떤 식의 디자인인지 알아볼 수 없는 경우
        * 저수준 구성요소에서도 상속 계층구조상 위에 있는 클래스에서 정의한 메소드를, 상속을 통해서 호출하는 것은 물론 가능합니다. </br>
         다만, 의존성을 피하기 위해서라도 저수준 구성 요소와 고수준 구성 요소 사이에 확연하게 드러나는 순환 의존성이 생기는 것은 피하는게 좋습니다. 
1. 저수준 구성 요소에서 시스템에 접속 가능 </br>
2. 언제 어떤 식으로 그 구성요소들을 사용할지는 고수준 구성요소에서 결정

### * 할리우드 원칙 vs 의존성 뒤집기 원칙 *
* 의존성 뒤집기 원칙
    * 구상 클래스 사용을 줄이고 대신 추상화된 것을 사용해야 한다는 원칙입니다.
    * 의존성을 피하는 방법에 있어서 헐리우드 원칙보다 강하면서도 일반적인 내용을 담고 있습니다. 
* 헐리우드 원칙
    * 저수준 구성요소가 컴퓨테이션에 참여할 수는 있으면서도 저수준 구성요소와 고수준 계층 사이에 의존성을 만드어내지 않도록 프레임워크 또는 구성 요소를 구축하기 위한 방법입니다.
    * 저수준 구성요소들을 다양하게 사용할 수 있으면서도, 다른 클래스가 그러한 구성요소에 너무 의존하지 않게 만들어주는 디자인을 구현하기 위한 기법을 제공해줍니다. 
-------

# 템플릿 메소드 활용 (자바 Array클래스)
```java
class Array{
    /* 1. 배열의 복사본을 만듭니다.
    *  2. mergeSort()를 호출할 때 대상 배열로 전달해줍니다.
    *  3. mergeSort() 호출 시, 배열의 길이와 첫 번째 원소의 위치(o)를 알려줘야 함 
    */
    public static void sort (Object[] a) {
        Object aux[] = (Object[]) a.clone();
        mergeSort(aux, a, 0, a.length, 0);
    }

    /* 1. 정렬 알고리즘이 들어있습니다.
    *  2. compareTo() 메소드에 의해 결과가 결정됩니다.
    */
    private static void mergeSort(Object src [], Object dest [], int low, int high, int off) {
        for (int i = low; i<high; i++) {
            for (int j = i; j > low && ((Compareable) dest [j-1]).compareTo((Comparable) dest [j]) > 0; j--) {
                //Arrays 클래스에 이미 정의되어 있는 구상 메소드
                swap (dest, j, j-1);
            }
        }
    }
}
```
