package template_method_review0527;

public abstract class AbstGameConnectHelper {
	
	// �˰����� ������ �ܺο� ����Ǹ� �ȵ�
	// �ٸ� ���� Ŭ�������� ��� �����ϵ��� => protected
	// protected�� �ٸ� ��Ű������ ������ �� ����.
	
	// template method���� ����� �˰����� ���� method ����
	protected abstract String doSecurity(String str);
	protected abstract boolean authentication(String id, String password);
	protected abstract int authorization(String userName);
	protected abstract String connection(String info);
	
	public String requestConnection(String encodedInfo) { // template method
		// ���� ���� -> ��ȣȭ�� ���ڿ��� ��ȣȭ
		String decodedInfo = doSecurity(encodedInfo);
		
		// ��ȯ�� decodedInfo�� ���̵�, ��ȣ�� �Ҵ��Ѵٰ� ����
		String id = "aaa";
		String password = "bbb";
		
		// ��������
		if (!authentication(id, password)) {
			throw new Error("���̵� ��ȣ ����ġ!");
		}
		
		// ���� ����
		String userName = "";
		int i = authorization(userName);
		
		switch(i) {
		case -1:
			throw new Error("�˴ٿ�");
		case 0:
			System.out.println("\t���� �Ŵ���");
			break;
		case 1:
			System.out.println("\t���� ȸ��");
			break;
		case 2:
			System.out.println("\t���� ȸ��");
			break;
		case 3:
			System.out.println("\t���� ����");
			break;
		default:
			//��Ÿ ��Ȳ
			break;
		}
		
		// ���� ���� : �����ڿ��� Ŀ�ؼ� ������ ����
		return connection(decodedInfo);
	}
}
