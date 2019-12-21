package week1.younggeun0.example;

public class Penguin extends Tweet {

    private IWalkBehavior walkBehavior;

    public Penguin() {
        setWalkBehavior(new Walkable());
    }
    
    public void performWalk() {
        walkBehavior.walk(); // 위임
    }

    public void setWalkBehavior(IWalkBehavior walkBehavior) {
        this.walkBehavior = walkBehavior;
    }
}