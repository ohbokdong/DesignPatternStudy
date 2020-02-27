package week7.minj0i;

public class HomeTheaterFacade {
	//구성 부분. 사용하고자 하는 서브시스템의 모든 구성요소들이 인스턴스 변수 형태로 저장됨
	Amplifier amp;
	Tuner tuner;
	DvdPlayer dvd;
	CdPlayer cd;
	Projector projector;
	TheaterLights lights;
	Screen screen;
	PopcornPopper popper;
	
	//각 구성요소의 레퍼런스가 전달됨.
	public HomeTheaterFacade(Amplifier amp, Tuner tuner,
			DvdPlayer dvd, CdPlayer cd, Projector projector, TheaterLights lights,
			Screen screen, PopcornPopper popper) {
		this.amp = amp;
		this.tuner = tuner;
		this.dvd = dvd;
		this.cd = cd;
		this.projector = projector;
		this.lights = lights;
		this.screen = screen;
		this.popper = popper;
	}
	
	// 기타 메소드
	// 일련의 작업들을 하나의 메소드로 간단하게 처리
	// 각 작업은 서브시스템에 들어있는 구성요소들에게 위임됨
	public void watchMovie(String movie) {
		System.out.println("Get ready to watch a movie");
		popper.on();
		popper.pop();
		lights.dim(10);
		screen.down();
		projector.on();
		projector.setInput(dvd);
		projector.wideScreenMode();
		amp.on();
		amp.setDvd(dvd);
		amp.setSurrondSound();
		amp.setVolume(5);
		dvd.on();
		dvd.play(movie);
	}
	
	public void endMovie() {
		System.out.println("Shutting movie theater down...");
		popper.off();
		lights.on();
		screen.up();
		projector.off();
		amp.off();
		dvd.stop();
		dvd.eject();
		dvd.off();
	}
}
