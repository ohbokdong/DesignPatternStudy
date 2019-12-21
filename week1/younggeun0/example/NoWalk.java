package week1.younggeun0.example;

public class NoWalk implements IWalkBehavior {

    @Override
    public void walk() {
        System.out.println("...(못 걷는다)");        
    }
}