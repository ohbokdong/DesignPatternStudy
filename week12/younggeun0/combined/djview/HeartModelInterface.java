package week12.younggeun0.combined.djview;

// 심박수를 모니터링하기 위한 인터페이스
public interface HeartModelInterface { // 모델
	int getHeartRate(); // 현재 심박수를 알아오기 위한 메소드
	void registerObserver(BeatObserver o);
	void removeObserver(BeatObserver o);
	void registerObserver(BPMObserver o);
	void removeObserver(BPMObserver o);
}
