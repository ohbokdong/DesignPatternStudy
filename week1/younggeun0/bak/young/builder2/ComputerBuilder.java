package builder2;

public class ComputerBuilder {
	
	private Computer computer;
	
	private ComputerBuilder() {
		computer = new Computer("default", "default", "default");
	}

	public static ComputerBuilder start() {
		return new ComputerBuilder();
	}

	public ComputerBuilder setCpu(String cpu) {
		computer.setCpu(cpu);
		return this;
	}

	public ComputerBuilder setRam(String ram) {
		computer.setRam(ram);
		return this;
	}

	public ComputerBuilder setStorage(String storage) {
		computer.setStorage(storage);
		return this;
	}

	public Computer build() {
		return this.computer;
	}
}
