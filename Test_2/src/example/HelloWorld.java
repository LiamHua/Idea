package example;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "HelloWorld", targetNamespace = "http://example")
public interface HelloWorld  {
    @WebMethod
    boolean newUser(); /*{
        System.out.println(user);
        System.out.println(password);
        boolean staue = NewUser(user, password);
        return staue;
    }*/


}
