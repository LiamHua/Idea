package per.liam.pojo.serice;

import per.liam.pojo.UserDao;

/**
 * @author liam
 * @date 19-12-22 下午7:25
 */
public class ServiceImpl implements Service {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
