package builder;

public class LgGramBlueprint extends Blueprint {

	private Computer computer;
	
	public LgGramBlueprint() {
		computer = new Computer("default", "default", "default");
	}
	
	@Override
	public void setCpu() {
		computer.setCpu("i5");
	}
	@Override
	public void setRam() {
		computer.setRam("8GB");
	}
	@Override
	public void setStorage() {
		computer.setStorage("256GB SSD");
	}
	@Override
	public Computer getComputer() {
		return computer;
	}
}
