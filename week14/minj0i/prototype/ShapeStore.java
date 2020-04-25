package week14.minj0i.prototype;

import java.awt.Window.Type;
import java.util.HashMap;
import java.util.Map;

public class ShapeStore {
	private static Map<Type, Shape> shapeMap = new HashMap<Type, Shape>();
	
	public void registerShape() {
		Rectangle rec = new Rectangle();
		Circle cir = new Circle();
		Triangle tri = new Triangle();
		
		shapeMap.put(rec.type, rec);
		shapeMap.put(cir.type, cir);
		shapeMap.put(tri.type, tri);
	}
	
	public Shape getShape(Type type) {
		return (shape)shapeMap.get(type).clone();
	}
}
