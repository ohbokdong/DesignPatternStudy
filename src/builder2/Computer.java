package builder2;

public class Computer {

	private String cpu, ram, storage;

	public Computer(String cpu, String ram, String storage) {
		this.cpu = cpu;
		this.ram = ram;
		this.storage = storage;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	@Override
	public String toString() {
		return "Computer [cpu=" + cpu + ", ram=" + ram + ", storage=" + storage + "]";
	}
}
