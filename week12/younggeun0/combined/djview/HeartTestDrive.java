package week12.younggeun0.combined.djview;
  
public class HeartTestDrive {

    public static void main (String[] args) {
		HeartModel heartModel = new HeartModel(); // 모델 생성
        ControllerInterface model = new HeartController(heartModel); // 컨트롤러에 전달
    }
}
