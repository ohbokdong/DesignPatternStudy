package cor;

abstract public class Calculator {

	private Calculator preCalculator;
	
	public void setNextCalculator(Calculator nextCalculator) {
		this.preCalculator = nextCalculator;
	}
	
	public boolean process(Request request) {
		if (preCalculator != null)
			if(preCalculator.process(request))
				return true;
		
		return operator(request);
	}
	
	abstract protected boolean operator(Request request);
}
