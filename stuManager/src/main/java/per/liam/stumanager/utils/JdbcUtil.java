package per.liam.stumanager.utils;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author liam
 * @date 19-12-18 下午10:13
 */
public class JdbcUtil {
    public static DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUrl("jdbc:mariadb://47.98.245.249:3306/stuManager");
        dataSource.setUsername("liam");
        dataSource.setPassword("321098");
        return dataSource;
    }
}
