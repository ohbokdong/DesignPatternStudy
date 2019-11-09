package abstfac;

import abstfac.abst2.Button;
import abstfac.abst2.GuiFac;
import abstfac.abst2.TextArea;
import abstfac.concrete.FactoryInstance;

public class Main {

	public static void main(String[] args) {
		
		GuiFac fac = FactoryInstance.getGuiFac();
		
		Button button = fac.createButton();
		TextArea area = fac.createTextArea();
		
		button.click();
		System.out.println(area.getText());
		System.out.println(System.getProperty("os.name"));
	}
}
