package per.liam.stumanager.dao;

/**
 * @author liam
 * @date 19-12-18 下午10:19
 */
public interface UserDao {

    /**
     * 用户登录
     * @param username 用户账号
     * @param password 密码
     * @return 状态：0-服务器异常  1-该用户不存在  2-密码错误  3-登录成功
     */
    public int login(String username, String password);
}
