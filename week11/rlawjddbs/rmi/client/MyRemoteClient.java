package week11.rmi.client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteClient {
   public static void main(String[] args) {
      new MyRemoteClient().go();
   }
   
   public void go() {
      try {
         MyRemote service = (MyRemote) Naming.lookup("rmi://172.30.1.23:8080/RemoteHello");
         
         String s = service.sayHello();
         
         System.out.println(s);
      } catch (Exception e) {         
         e.getMessage();
         e.printStackTrace();  
      } // end catch
   }
}
