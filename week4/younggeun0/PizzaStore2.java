package week4.younggeun0;

public abstract class PizzaStore2 {
    public Pizza2 orderPizza(String item) {
        Pizza2 pizza;

        pizza = createPizza(item); // 팩토리 객체가 아닌 PizzaStore에 있는 createPizza를 호출

        // 나머지 동일
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    
        return pizza;
    }

    public abstract Pizza2 createPizza(String type); // 팩토리 객체 대신 이 메소드를 사용
    // 팩토리 메소드(factory method)가  PizzaStore의 추상 메소드로 바뀜
    // Pizza 인스턴스를 만드는 일은 이제 팩토리 역할을 하는 메소드에서 맡아서 처리
    // 팩토리 메소드를 이용하면 객체를 생성하는 작업을 서브클래스에 캡슐화 시킬 수 있음
}