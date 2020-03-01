package week9.younggeun0.iterator;

public interface Iterator {
	boolean hasNext(); // 반복할 다음 항목이 있는지 확인한 다음 그 결과를 부울 값으로 리턴
	Object next(); // 다음 항목을 리턴
}
