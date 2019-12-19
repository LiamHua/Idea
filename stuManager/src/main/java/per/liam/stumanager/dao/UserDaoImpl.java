package per.liam.stumanager.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import per.liam.stumanager.utils.JdbcUtil;

import java.util.Map;

/**
 * @author liam
 * @date 19-12-18 下午10:26
 */
public class UserDaoImpl implements UserDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());

    @Override
    public int login(String username, String password) {
        String sql = "select username,password from admin where username=?";
        try {
            Map<String, Object> query = jdbcTemplate.queryForMap(sql, username);
            if (query.get("password").equals(password)) {
                return 3;
            }else {
                return 2;
            }
        }catch (EmptyResultDataAccessException e){
            return 1;
        }

    }
}
