package template_method_review0527;

public class DefaultGameConnectionHelper extends AbstGameConnectHelper {

	@Override
	protected String doSecurity(String str) {
		System.out.println("1. ��ȭ�� �˰����� �̿��� ���ڵ� �۾�");
		return str;
	}

	@Override
	protected boolean authentication(String id, String password) {
		System.out.println("2. ���̵�/��ȣ Ȯ�� ����");
		return true;
	}

	@Override
	protected int authorization(String userName) {
		System.out.println("3. ���� Ȯ��");
		// �������� ������ ���̸� �� �� ����
		// ����, ���� �ð��� Ȯ��, ������ �ƴϰ� 10�ð� �����ٸ�
		// ������ ���� ������ ��
		return -1;
	}

	@Override
	protected String connection(String info) {
		System.out.println("4. ������ ���� �ܰ�");
		return info;
	}

}
