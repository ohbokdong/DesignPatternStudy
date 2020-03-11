# Week 9

## 이터레이터 패턴 (Iterator Pattern) 
* 클라이언트에게 컬렉션 안의 내부 구조를 노출하지 않으면서 원소들에 접근할 수 있는 방법을 제공하는 패턴
* 클라이언트로 부터 각기 다른 컬렉션(집합체)을 일획화하여 다룰 수 있는 방법을 제공
* 컬렉션의 모든 원소들에게 접근하기 위한 반복적인 작업을 컬렉션에서 분리시킬 수 있음  
  

![01](https://github.com/ohbokdong/DesignPatternStudy/blob/master/summary/img/week9_01.png)  
PancakeHouse와 DinerMenu는 동일한 메뉴 항목을 나타내는 MenuItem을 가지고 있으나 MenuItem의 집합체를 다루는 방식은 다르다.  
각기 다른 방식으로 집합체를 다루는 PancakeHouse와 DinerMenu의 객체를 사용하는 Waitress 클라이언트 클래스는 두 객체가 가진 모든 MenuItem 항목을 출력하는 printMenu() 메소드가 있다.



## 컴포지트 패턴 (Composite Pattern)
* 클라이언트에게 개별 객체와 복합 객체를 동일한 방법으로 다룰 수 있는 방법을 제공하는 패턴
* 복합 객체와 개별 객체를 모두 담아둘 수 있는 구조를 제공
* 컴포지트 패턴을 적용할 때는 여러 가지 장단점을 고려해야 하며, 상황에 따라 투명성과 안정성 사이에서 적절한 평형점을 찾아야 함
