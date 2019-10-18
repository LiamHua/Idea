package pers.liam.countManager;

import pers.liam.DB.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyServicesImpl implements MyServices {
    @Override
    public boolean addUser() {
        int i = 0;
        Connection conn = JDBCUtil.get_conn();
        try {
            //TODO  得到用户信息并创建为sql语句
            String sql = "";
             PreparedStatement pstmt = conn.prepareStatement(sql);
            //TODO  补全占位符
            //pstmt.setString(1,username);
            //pstmt.setString(2,password);
            i = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i == 1)
            return true;
        else
            return false;
    }

    @Override
    public boolean modify_userInfo() {
        return false;
    }

    @Override
    public String get_userInfo() {
        return null;
    }

    @Override
    public boolean verify_userInfo() {
        return false;
    }
}
