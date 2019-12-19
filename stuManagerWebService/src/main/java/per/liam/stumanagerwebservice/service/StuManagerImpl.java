package per.liam.stumanagerwebservice.service;

import per.liam.stumanagerwebservice.db.JDBCUtil;

import javax.jws.WebService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author liam
 * @date 19-12-18 下午3:10
 */
@WebService
public class StuManagerImpl implements StuManagerServices {
    @Override
    public int login(String username, String password) {
        String dbPassword;
        Connection conn = JDBCUtil.get_conn();
        String sqlSelect = "SELECT username,password FROM admin WHERE username=?";
        try {
            assert conn != null;
            PreparedStatement pstmt = conn.prepareStatement(sqlSelect);
            pstmt.setString(1, username);
            ResultSet resultSet = pstmt.executeQuery();
            resultSet.last();
            int n = resultSet.getRow();
            resultSet.first();
            if (n == 0) {
                JDBCUtil.close(conn, pstmt, resultSet);
                return 1;
            } else {
                dbPassword = resultSet.getString("password").trim();
                boolean flag = password.equals(dbPassword);
                if (!flag) {
                    JDBCUtil.close(conn, pstmt, resultSet);
                    return 2;
                } else {
                    JDBCUtil.close(conn, pstmt, resultSet);
                    return 3;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
