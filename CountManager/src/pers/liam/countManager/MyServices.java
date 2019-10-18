package pers.liam.countManager;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.SQLException;

@WebService
public interface MyServices {

    @WebMethod
    public boolean addUser() throws SQLException;

    @WebMethod
    public boolean modify_userInfo();

    @WebMethod
    public String get_userInfo();

    @WebMethod
    public boolean verify_userInfo();
}
