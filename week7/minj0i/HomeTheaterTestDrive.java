package week7.minj0i;

public class HomeTheaterTestDrive {
	
	public static void main(String[] args) {
	     Amplifier amp = new Amplifier();
	     Tuner tuner = new Tuner();
	     DvdPlayer dvd = new DvdPlayer();
	     CdPlayer cd = new CdPlayer();
	     Projector projector = new Projector();
	     TheaterLights lights = new TheaterLights();
	     Screen screen = new Screen();
	     PopcornPopper popper = new PopcornPopper();
	     

	     HomeTheaterFacade htf = new HomeTheaterFacade(amp, tuner,
	                dvd, cd, projector,  lights,
	                screen, popper);
	     
	     htf.watchMovie("Raiders of the Lost ark");
	     htf.endMovie();
	}

}
