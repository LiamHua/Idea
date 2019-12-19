package per.liam.stumanagerwebservice.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author liam
 * @date 19-12-18 下午3:09
 */
@WebService
public interface StuManagerServices {

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 0-服务器异常  1-该用户不存在  2-密码错误  3-登录成功
     */
    @WebMethod
    int login(String username, String password);

}
