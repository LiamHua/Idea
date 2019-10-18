package client;

import com.sun.corba.se.impl.protocol.giopmsgheaders.RequestMessage;
import com.sun.xml.internal.ws.resources.SoapMessages;

import javax.xml.rpc.ServiceException;
import javax.xml.ws.spi.http.HttpContext;
import java.rmi.RemoteException;
import java.rmi.activation.Activator;

public class liam {
  public static void main(String[] argv) {
      try {
          HelloWorldServiceLocator locator = new HelloWorldServiceLocator();
          HelloWorld_PortType service = locator.getHelloWorld();
          // If authorization is required
          //((HelloWorldSoapBindingStub)service).setUsername("user3");
          //((HelloWorldSoapBindingStub)service).setPassword("pass3");
          // invoke business method
          //service.main(null);

          boolean statue = service.newUser();
          System.out.println(statue);
      } catch (ServiceException | RemoteException ex) {
          ex.printStackTrace();
      }
  }
}
