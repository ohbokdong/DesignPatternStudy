package builder2;

public class Main {

	public static void main(String[] args) {
		
		Computer computer = ComputerBuilder
				.start()
				.setCpu("i7")
				.setRam("16G")
				.setStorage("512GB SSD")
				.build();
		
		System.out.println(computer);
		
	}
}
