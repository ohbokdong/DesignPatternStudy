package adapter_review0526;

public class AdapterImpl implements Adapter {

	@Override
	public Float twiceOf(Float f) {
		return Math.doubled(f.doubleValue()).floatValue();
	}

	@Override
	public Float halfOf(Float f) {
		System.out.println("절반 함수 시작 Log");
		return (float)Math.half(f.doubleValue());
	}	
	
	
}
