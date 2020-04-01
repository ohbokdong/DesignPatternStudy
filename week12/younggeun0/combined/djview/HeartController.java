package week12.younggeun0.combined.djview;
  
public class HeartController implements ControllerInterface {
	HeartModelInterface model; // 컨트롤러가 모델을 들고 있는 Has-A
	DJView view;
  
	public HeartController(HeartModelInterface model) {
		this.model = model;
		// HeartModelInterface를 전달하기 위해 어댑터 패턴을 사용
		view = new DJView(this, new HeartAdapter(model)); // DJ뷰를 재활용
		
        view.createView();
        view.createControls();
        
        // 메뉴 항목이 필요 없어 비활성화 처리
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}
  
	// 심장관련, 제어할 수 없으므로 비워둠 
	public void start() {}
	public void stop() {}
	public void increaseBPM() {}
	public void decreaseBPM() {}
 	public void setBPM(int bpm) {}
 	//////////////////////////////////////////////
}



