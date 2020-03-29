package week11.minj0i.protectionProxy;

import java.lang.reflect.*;

//호출 핸들러에서 반드시 InvocationHandler인터페이스를 구현해야함
public class OwnerInvocationHandler implements InvocationHandler { 
	PersonBean person;
 
	public OwnerInvocationHandler(PersonBean person) {
		this.person = person;
	}
 
	//프록시의 메소드가 호출될 떄마다 호출되는 invoke()메소드
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws IllegalAccessException {
  
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(person, args);
   			} else if (method.getName().equals("setHotOrNotRating")) {
				throw new IllegalAccessException();
			} else if (method.getName().startsWith("set")) {
				return method.invoke(person, args);
			} 
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
		//다른 메소드 실행 시 nul
		return null;
	}
}