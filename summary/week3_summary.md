# 데코레이터 패턴 (Decorator Pattern)
* 데코레이터 패턴의 정의</br>
</t>: 자바의 I/O 패키지에 적용되어있는 패턴</br>
</t>: 객체에 추가적인 요건을 동적으로 첨가</br>
</t>: 서브클래스를 만드는 것을 통해서 기능을 유연하게 확장할 수 있는 방법</br>
</t>: 자신이 감싸고 있는 구성요소의 메소드를 호출한 결과에 새로운 기능을 더함으로써 행동을 확장</br>
</t>: 다시 말하면, </br>
    1. 구성과 위임을 통해서</br>
    2. 기존 코드를 수정하지 않고 행동을 확장하는 방법 (OCP) </br>

##### * ocp(Open-Closed Principle)란?
: 확장에는 열려있지만, 코드 변경에 대해서는 닫혀 있어야 한다.</br>
** 모든 부분에서 적용할 수는 없습니다. </br>
    디자인 한 것 중에서 가장 바뀔 확률이 높은 부분을 중점적으로 살피고, </br> 원칙을 적용하는 방법이 가장 현명합니다. :)
    
----

## <기존 상속을 사용해서 추가 사항을 관리하는 경우>
1. 첨가물 가격이 바뀔 때마다 기존 코드를 수정해야 함.
2. 첨가물의 종류가 많아지면 새로운 메소드를 추가해야 하고, 수퍼클래스의 cost() 메소드도 고쳐져야 함.
3. 특정 첨가물이 들어가지 않는 경우에도 모든 첨가물을 상속 받아야 함.
4. 커스텀 메뉴에 유동적으로 적용할 수 없음.

* 클래스 다이어그램</br>
![02](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week3_02.png)

* Beverage 클래스
```java
public class Beverage {
	private double cost = 0;
	private String description;
	
	private Boolean isMilk = false;
	private Boolean isSoy = false;
	private Boolean ismocha = false;
	private Boolean isWhip = false;
	
	private int milkCost = 500;
	private int soyCost = 200;
	private int mochaCost = 500;
	private int whipCost = 300;
	
	public Boolean getIsMilk() {
		return isMilk;
	}

	public void setIsMilk(Boolean isMilk) {
		this.isMilk = isMilk;
	}

	public Boolean getIsSoy() {
		return isSoy;
	}

	public void setIsSoy(Boolean isSoy) {
		this.isSoy = isSoy;
	}

	public Boolean getIsmocha() {
		return ismocha;
	}

	public void setIsmocha(Boolean ismocha) {
		this.ismocha = ismocha;
	}

	public Boolean getIsWhip() {
		return isWhip;
	}

	public void setIsWhip(Boolean isWhip) {
		this.isWhip = isWhip;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int cost() {
		int condimentCost = 0;
		
		if(getIsMilk()) {
			condimentCost += milkCost;
		}
		
		if(getIsmocha()) {
			condimentCost += mochaCost;
		}
		
		if(getIsSoy()) {
			condimentCost += soyCost;
		}
		
		if(getIsWhip()) {
			condimentCost += whipCost;
		}
		
		return condimentCost;
	}

}
```
* HouseBlend 클래스 (Beverage 클래스 상속받음)
```java
public class DarkRoast extends Beverage{

	public DarkRoast() {
		setDescription("하우스 블렌드");
		setIsMilk(true);
		setIsWhip(true);
	}
	
	@Override
	public int cost() {
		return 1000+super.cost();
	}
	
	public static void main(String[] args) {
		DarkRoast gtl = new DarkRoast();
		System.out.println(gtl.getDescription());
		System.out.println(gtl.cost());
	}
}
```
---
#### 데코레이터 패턴을 사용하는 경우
* 클래스 다이어그램 </br>
![03](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week3_03.png) 
* 데코레이터 패턴의 단점</br>
</t>: 자잘한 객체들이 매우 많이 추가되어, 코드의 복잡성이 증가됨</br>
</t>: 구성요소를 초기화 하는데 필요한 코드가 훨씬 복잡해짐 </br>
</t>(많은 데코레이터로 감싸야 하는 경우가 발생하기 때문에)


