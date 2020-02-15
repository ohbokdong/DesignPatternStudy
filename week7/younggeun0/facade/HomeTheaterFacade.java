package week7.younggeun0.facade;

public class HomeTheaterFacade {
	// 구성 부분, 서브시스템의 모든 구성요소들이 인스턴스 변수 형태로 저장됨
	Amplifier amp;
	Tuner tuner;
	DvdPlayer dvd;
	CdPlayer cd;
	Projector projector;
	TheaterLights lights;
	Screen screen;
	PopcornPopper popper;
	
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
	public void watchMovie(String movie) {
		System.out.println(movie+"란 영화 볼 준비를 합시다");
		
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
}
