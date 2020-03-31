package week12.younggeun0.combined.djview;
  
public interface BeatModelInterface { // 모델 인터페이스
	
	
	// 컨트롤러에서 모델한테 사용자 입력을 전달할 때 사용할 메소드
	void initialize();
  
	void on();
  
	void off();
  
    void setBPM(int bpm);
    ///////////////////////////////////////////////////////////////
  
    // 뷰와 컨트롤러에서 상태를 알아내거나 옵저버로 등록할 때 사용하는 메소드
	int getBPM();
  
	void registerObserver(BeatObserver o); 	// 박자(상태)가 바뀌었을 때 연락받기 위한 옵저버 등록
  
	void removeObserver(BeatObserver o); 	// 박자(상태)가 바뀌었을 때 연락받기 위한 옵저버 해제
  
	void registerObserver(BPMObserver o);	// BPM(상태)가 바뀌었을 때 연락받기 위한 옵저버 등록
  
	void removeObserver(BPMObserver o); 	// BPM(상태)가 바뀌었을 때 연락받기 위한 옵저버 해제
	/////////////////////////////////////////////////////////////////////////
}
