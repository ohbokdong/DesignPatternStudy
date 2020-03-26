package week11.minj0i;

import java.io.*;

//Serializable 인터페이스를 확장(아무 메소드 없음) State 서브 클래스의 직렬화를 위해(=즉 네트워크를 통해 전송 가능)
public interface State extends Serializable{
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispense();
}