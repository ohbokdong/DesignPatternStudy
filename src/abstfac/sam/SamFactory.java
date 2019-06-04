package abstfac.sam;

import abstfac.abst.BikeFactory;
import abstfac.abst.Body;
import abstfac.abst.Wheel;

public class SamFactory implements BikeFactory {

	@Override
	public Body createBody() {
		return new SamBody();
	}
	
	@Override
	public Wheel createWheel() {
		return new SamWheel();
	}
}
