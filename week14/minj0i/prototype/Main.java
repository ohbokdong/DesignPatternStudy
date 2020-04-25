package week14.minj0i.prototype;

public class Main {
    public static void main(String[] args) {
        ShapeStore manager = new ShapeStore();
        manager.registerShape();
        
        Circle cir1 = (Circle)manager.getShape(Type.CIRCLE);
        cir1.draw();
        Circle cir2 = (Circle)manager.getShape(Type.CIRCLE);
        cir2.draw();
        
        Rectangle rec1 = (Rectangle)manager.getShape(Type.RECTANGLE);
        rec1.draw();
        
        Triangle tri1 = (Triangle)manager.getShape(Type.TRIANGLE);
        tri1.draw();
        
    }
}
