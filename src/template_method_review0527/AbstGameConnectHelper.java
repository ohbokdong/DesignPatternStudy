package template_method_review0527;

public abstract class AbstGameConnectHelper {
	
	// 알고리즘의 순서는 외부에 노출되면 안됨
	// 다만 하위 클래스에서 사용 가능하도록 => protected
	// protected면 다른 패키지에서 접근할 수 없다.
	
	// template method에서 수행될 알고리즘을 담을 method 선언
	protected abstract String doSecurity(String str);
	protected abstract boolean authentication(String id, String password);
	protected abstract int authorization(String userName);
	protected abstract String connection(String info);
	
	public String requestConnection(String encodedInfo) { // template method
		// 보안 과정 -> 암호화된 문자열을 복호화
		String decodedInfo = doSecurity(encodedInfo);
		
		// 반환된 decodedInfo로 아이디, 암호를 할당한다고 가정
		String id = "aaa";
		String password = "bbb";
		
		// 인증과정
		if (!authentication(id, password)) {
			throw new Error("아이디 암호 불일치!");
		}
		
		// 권한 과정
		String userName = "";
		int i = authorization(userName);
		
		switch(i) {
		case -1:
			throw new Error("셧다운");
		case 0:
			System.out.println("\t게임 매니저");
			break;
		case 1:
			System.out.println("\t유료 회원");
			break;
		case 2:
			System.out.println("\t무료 회원");
			break;
		case 3:
			System.out.println("\t권한 없음");
			break;
		default:
			//기타 상황
			break;
		}
		
		// 접속 과정 : 접속자에게 커넥션 정보를 전달
		return connection(decodedInfo);
	}
}
