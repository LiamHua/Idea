package per.liam.stumanager.model;

import per.liam.stumanager.dao.UserDao;
import per.liam.stumanager.dao.UserDaoImpl;
/**
 * @author liam
 * @date 19-12-18 下午4:12
 */
public class Login {
    public int login(String username, String password){
        UserDao userDao = new UserDaoImpl();
        return userDao.login(username,password);
    }
}
