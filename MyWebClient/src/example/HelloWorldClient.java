package example;


import pers.liam.CountManagerClient.MyServiceImpl;
import pers.liam.CountManagerClient.MyServiceImplServiceLocator;

import java.rmi.activation.Activator;

public class HelloWorldClient {
  public static void main(String[] argv) {
    try {
      MyServiceImplServiceLocator locator = new MyServiceImplServiceLocator();
      MyServiceImpl myServiceImplPort = locator.getMyServiceImplPort();

      // If authorization is required
      //((MyServiceImplPortBindingStub)service).setUsername("user3");
      //((MyServiceImplPortBindingStub)service).setPassword("pass3");
      // invoke business method
      int i = myServiceImplPort.verify_userInfo("13688888888","lzh0000000000");
      System.out.println(i);
    } catch (javax.xml.rpc.ServiceException ex) {
      ex.printStackTrace();
    } catch (java.rmi.RemoteException ex) {
      ex.printStackTrace();
    }
  }
}
