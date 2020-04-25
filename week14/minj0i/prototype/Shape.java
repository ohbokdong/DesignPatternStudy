package week14.minj0i.prototype;

import java.awt.Window.Type;

public abstract class Shape implements Cloneable {
	protected Type type;
	abstract void draw();
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Object clone = null;
		
		try {
			clone = super.clone();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}
