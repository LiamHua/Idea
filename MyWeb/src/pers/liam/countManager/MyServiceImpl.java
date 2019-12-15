package pers.liam.countManager;

import pers.liam.DB.JDBCUtil;

import javax.jws.WebService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebService(targetNamespace = "pers.liam.countManager.MyService",name="MyServiceImplService")
public class MyServiceImpl implements MyService {
    @Override
    public int addUser(String username, String password) {    //返回值  1-该用户已存在  2-注册成功  3-服务器异常
        int i = 0;
        System.out.println(username);
        System.out.println(password);
        Connection conn = JDBCUtil.get_conn();
        try {
            String sql_select = "SELECT Susername,Spassword FROM AccountManager.Account WHERE Susername=?";
            String sql_insert = "INSERT INTO AccountManager.Account(Susername,Spassword) VALUES(?,?)";
            assert conn != null;
            PreparedStatement pstmt_select = conn.prepareStatement(sql_select);
            pstmt_select.setString(1, username);
            ResultSet resultSet = pstmt_select.executeQuery();
            resultSet.last();
            int n = resultSet.getRow();
            resultSet.beforeFirst();
            if (n == 1) {
                JDBCUtil.close(conn, pstmt_select, resultSet);
                return 1;
            }
            PreparedStatement pstmt_insert = conn.prepareStatement(sql_insert);
            pstmt_insert.setString(1, username);
            pstmt_insert.setString(2, password);
            i = pstmt_insert.executeUpdate();
            if (i == 1) {
                JDBCUtil.close(conn, pstmt_select, resultSet);
                JDBCUtil.close(conn, pstmt_insert, resultSet);
                return 2;
            } else {
                JDBCUtil.close(conn, pstmt_select, resultSet);
                JDBCUtil.close(conn, pstmt_insert, resultSet);
                return 3;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 3;
        }
    }

    @Override
    public boolean modify_userInfo() {
        return false;
    }

    @Override
    public String get_userInfo(String user, String password) {
        System.out.println(user);
        System.out.println(password);
        return "Hello world";
    }

    @Override
    public int verify_userInfo(String username, String password) {    //返回值  0-服务器异常  1-该用户不存在  2-密码错误  3-登录成功
        String db_password;
        Connection conn = JDBCUtil.get_conn();
        String sql_select = "SELECT Susername,Spassword FROM AccountManager.Account WHERE Susername=?";
        try {
            assert conn != null;
            PreparedStatement pstmt = conn.prepareStatement(sql_select);
            pstmt.setString(1, username);
            ResultSet resultSet = pstmt.executeQuery();
            resultSet.last();
            int n = resultSet.getRow();
            resultSet.first();
            if (n == 0) {
                JDBCUtil.close(conn, pstmt, resultSet);
                return 1;
            } else {
                db_password = resultSet.getString("Spassword").trim();
                boolean flag = password.equals(db_password);
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
