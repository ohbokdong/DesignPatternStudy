package builder;

public abstract class Blueprint {
	
	public abstract void setCpu();
	public abstract void setRam();
	public abstract void setStorage();
	public abstract Computer getComputer();
}
