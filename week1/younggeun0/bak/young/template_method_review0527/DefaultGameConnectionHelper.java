package template_method_review0527;

public class DefaultGameConnectionHelper extends AbstGameConnectHelper {

	@Override
	protected String doSecurity(String str) {
		System.out.println("1. 강화된 알고리즘을 이용한 디코드 작업");
		return str;
	}

	@Override
	protected boolean authentication(String id, String password) {
		System.out.println("2. 아이디/암호 확인 가능");
		return true;
	}

	@Override
	protected int authorization(String userName) {
		System.out.println("3. 권한 확인");
		// 서버에서 유저의 나이를 알 수 있음
		// 나이, 지금 시간을 확인, 성인이 아니고 10시가 지났다면
		// 권한이 없는 것으로 함
		return -1;
	}

	@Override
	protected String connection(String info) {
		System.out.println("4. 마지막 접속 단계");
		return info;
	}

}
