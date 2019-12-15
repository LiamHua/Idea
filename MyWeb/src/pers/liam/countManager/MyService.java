package pers.liam.countManager;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface MyService {

    @WebMethod
    int addUser(String username, String password);

    @WebMethod
    boolean modify_userInfo();

    @WebMethod
    String get_userInfo(String username, String password);

    @WebMethod
    @WebResult(name="loginCode")
    int verify_userInfo(@WebParam(name="username") String username, @WebParam(name="password") String password);
}
