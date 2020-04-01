package week12.younggeun0.combined.djview;

// 타겟 인터페이스(BeatModelInterface)를 구현
public class HeartAdapter implements BeatModelInterface {
	HeartModelInterface heart;
 
	public HeartAdapter(HeartModelInterface heart) {
		this.heart = heart;
	}
	public int getBPM() {
		return heart.getHeartRate();
	}
	public void registerObserver(BeatObserver o) {
		heart.registerObserver(o);
	}
	public void removeObserver(BeatObserver o) {
		heart.removeObserver(o);
	}
	public void registerObserver(BPMObserver o) {
		heart.registerObserver(o);
	}
	public void removeObserver(BPMObserver o) {
		heart.removeObserver(o);
	}
	// 심장관련 내용이 아니므로 아무것도 안하도록 수정
    public void initialize() {}
    public void on() {}
    public void off() {}
    public void setBPM(int bpm) {}
    ////////////////////////////////////////////////////////
}
