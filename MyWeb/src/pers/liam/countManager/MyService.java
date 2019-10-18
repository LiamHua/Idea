package pers.liam.countManager;

import javax.jws.WebMethod;
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
    int verify_userInfo(String usernaem, String password);
}
