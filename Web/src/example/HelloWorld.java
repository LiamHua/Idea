package example;


import javax.jws.WebMethod;


public interface HelloWorld{
    @WebMethod
    public boolean insertUser(String str);

    @WebMethod
    public String sayHello(String str);
}


