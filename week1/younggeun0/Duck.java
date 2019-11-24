package week1.younggeun0;

public abstract class Duck {

    // 행동 인터페이스 형식의 레퍼런스 변수 두 개를 선언
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {

    }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly(); // 행동 클래스에 위임
    }

    public void performQuack() {
        quackBehavior.quack(); // 행동 클래스에 위임
    }

    public void swim() {
        System.out.println("모든 오리는 물에 뜸, 가짜 오리도 뜸");
    }

    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }
}
