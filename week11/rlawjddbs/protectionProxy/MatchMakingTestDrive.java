package week11.protectionProxy;

import java.lang.reflect.Proxy;
import java.util.HashMap;

public class MatchMakingTestDrive {
	HashMap<String, PersonBean> datingDB = new HashMap<String, PersonBean>();

	public MatchMakingTestDrive() {
		initializeDatabase();
	}
	
	public static void main(String[] args) {
		MatchMakingTestDrive test = new MatchMakingTestDrive();
		test.drive();
	} // main
	
	public void drive() {
		PersonBean joe = getPersonFromDatabase("Joe Javabean");
		PersonBean ownerProxy = getOwnerProxy(joe);
		System.out.println("Name is " + ownerProxy.getName());
		ownerProxy.setInterests("bowling, Go");
		System.out.println("Interests set from owner proxy");
		System.out.println("interests is " + ownerProxy.getInterests());
		
		// Owner proxy
		try {
			ownerProxy.setHotOrNotRating(10);
		} catch (Exception e) {
			System.out.println("Can't set rating from owner proxy");
		} // end catch
		System.out.println("Rating is " + ownerProxy.getHotOrNotRating());
		
		
		PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
		System.out.println("Name is " + nonOwnerProxy.getName());
		
		// Non owner proxy
		try {
			nonOwnerProxy.setInterests("Talking, Cleaning, Shopping");
		} catch (Exception e) {
			System.out.println("Can't set interests from non owner proxy");
		} // end catch
		nonOwnerProxy.setHotOrNotRating(3);
		System.out.println("interests is " + ownerProxy.getInterests());
		System.out.println("Rating set from non owner proxy");
		System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());
		
	} // drive
	
	void initializeDatabase() {
		PersonBean joe = new PersonBeanImpl();
		joe.setName("Joe Javabean");
		joe.setInterests("cars, computers, music");
		joe.setHotOrNotRating(7);
		datingDB.put(joe.getName(), joe);

		PersonBean kelly = new PersonBeanImpl();
		kelly.setName("Kelly Klosure");
		kelly.setInterests("ebay, movies, music");
		kelly.setHotOrNotRating(6);
		datingDB.put(kelly.getName(), kelly);
	}

	PersonBean getPersonFromDatabase(String name) {
		return (PersonBean)datingDB.get(name);
	}
	
	PersonBean getOwnerProxy(PersonBean person) {
		return (PersonBean)Proxy.newProxyInstance(
				person.getClass().getClassLoader(),
				person.getClass().getInterfaces(),
				new OwnerInvocationHandler(person));
	} 
	
	PersonBean getNonOwnerProxy(PersonBean person) {
		return (PersonBean)Proxy.newProxyInstance(
				person.getClass().getClassLoader(),
				person.getClass().getInterfaces(),
				new NonOwnerInvocationHandler(person));
	}
	
} // class
