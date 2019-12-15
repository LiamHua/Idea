package per.liam.countmanager;

import per.liam.DB.JDBCUtil;
import per.liam.countmanager.friend.Friend;
import javax.jws.WebService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author liam
 */
@WebService(targetNamespace = "pers.liam.countManager.MyService", name = "MyServiceImplService")
public class MyServiceImpl implements MyService {
    @Override
    public int addUser(String nickname, String username, String password) {    //返回值  1-该用户已存在  2-注册成功  3-服务器异常
        int i;
        Connection conn = JDBCUtil.get_conn();
        try {
            String sqlSelect = "SELECT username,password FROM AccountManager.User WHERE username=?";
            String sqlInsert = "INSERT INTO AccountManager.User(nickname,username,password) VALUES(?,?,?)";
            assert conn != null;
            PreparedStatement pstmtSelect = conn.prepareStatement(sqlSelect);
            pstmtSelect.setString(1, username);
            ResultSet resultSet = pstmtSelect.executeQuery();
            resultSet.last();
            int n = resultSet.getRow();
            resultSet.beforeFirst();
            if (n == 1) {
                JDBCUtil.close(conn, pstmtSelect, resultSet);
                return 1;
            }
            PreparedStatement pstmtInsert = conn.prepareStatement(sqlInsert);
            pstmtInsert.setString(1, nickname);
            pstmtInsert.setString(2, username);
            pstmtInsert.setString(3, password);
            i = pstmtInsert.executeUpdate();
            if (i == 1) {
                JDBCUtil.close(conn, pstmtSelect, resultSet);
                JDBCUtil.close(conn, pstmtInsert, resultSet);
                return 2;
            } else {
                JDBCUtil.close(conn, pstmtSelect, resultSet);
                JDBCUtil.close(conn, pstmtInsert, resultSet);
                return 3;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 3;
        }
    }

    @Override
    public boolean modifyUserInfo() {
        return false;
    }

    @Override
    public String getNickname(String username) {
        String nickname = "";
        Connection conn = JDBCUtil.get_conn();
        String sqlSelect = "SELECT nickname FROM AccountManager.User WHERE username=?";
        try {
            assert conn != null;
            PreparedStatement pstmt = conn.prepareStatement(sqlSelect);
            pstmt.setString(1, username);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                nickname = resultSet.getString("nickname".trim());
            }
            JDBCUtil.close(conn,pstmt,resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nickname;
    }

    @Override
    public int changeUserInfo(String address) {
        return 0;
    }

    @Override
    public int verifyUserInfo(String username, String password) {    //返回值  0-服务器异常  1-该用户不存在  2-密码错误  3-登录成功
        String dbPassword;
        Connection conn = JDBCUtil.get_conn();
        String sqlSelect = "SELECT username,password FROM AccountManager.User WHERE username=?";
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

    @Override
    public int setIP(String username, String ip) {
        int i = 0;
        Connection conn = JDBCUtil.get_conn();
        String sqlUpdate = "UPDATE AccountManager.User SET ip=? WHERE username=?";
        try {
            assert conn != null;
            PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
            pstmt.setString(1, ip);
            pstmt.setString(2, username);
            i = pstmt.executeUpdate();
            JDBCUtil.close(conn,pstmt,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public String getIP(String username) {
        String ip = "";
        Connection conn = JDBCUtil.get_conn();
        String sqlSelect = "SELECT ip FROM AccountManager.Friends WHERE username=?";
        try {
            assert conn != null;
            PreparedStatement pstmt = conn.prepareStatement(sqlSelect);
            pstmt.setString(1, username);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                ip = resultSet.getString("ip");
            }
            JDBCUtil.close(conn,pstmt,resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ip;
    }

    @Override
    public ArrayList<Friend> getFriendList(String username) {
        ArrayList<Friend> list = new ArrayList<>();
        Connection conn = JDBCUtil.get_conn();
        String sql = "SELECT nickname,username,ip FROM AccountManager.Friends WHERE target=?";
        try {
            assert conn != null;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                String nickname = resultSet.getString("nickname");
                String username1 = resultSet.getString("username");
                String ip = resultSet.getString("ip");
                list.add(new Friend(nickname,username1,ip));
            }
            JDBCUtil.close(conn,pstmt,resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<String> searchFriend(String username) {
        ArrayList<String> list = new ArrayList<>();
        Connection conn = JDBCUtil.get_conn();
        String sql = "SELECT nickname,username FROM AccountManager.User WHERE username=?";
        try {
            assert conn != null;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                list.add(resultSet.getString("nickname"));
                list.add(resultSet.getString("username"));
            }
            JDBCUtil.close(conn,pstmt,resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    // user1 add user2   return 1 is the friend is existed, 2 is the msg send successfully
    public int addFriendMsg(ArrayList<String> friend,String username) {
        int i ;
        Connection conn = JDBCUtil.get_conn();
        try{
            String sqlSelect1 = "SELECT * FROM AccountManager.Friends WHERE target=? AND username=?";
            String sqlSelect2 = "SELECT * FROM AccountManager.addFriends WHERE my_username=? AND you_username=?";
            String sqlInsert = "INSERT INTO AccountManager.addFriends(my_nickname,my_username,ip,you_username) " +
                    "VALUES(?,?,?,?)";
            assert conn != null;
            PreparedStatement pstmtSelect1 = conn.prepareStatement(sqlSelect1);
            pstmtSelect1.setString(1,friend.get(1).toString());
            pstmtSelect1.setString(2,username);
            ResultSet resultSet1 = pstmtSelect1.executeQuery();
            resultSet1.last();
            int n = resultSet1.getRow();
            resultSet1.beforeFirst();
            if (n == 1) {
                // TODO JDBCUtil.close(conn, pstmtSelect, resultSet);
                return 1;
            }
            PreparedStatement pstmtSelect2 = conn.prepareStatement(sqlSelect2);
            pstmtSelect2.setString(1, friend.get(1).toString());
            pstmtSelect2.setString(2,username);
            ResultSet resultSet2 = pstmtSelect2.executeQuery();
            resultSet2.last();
            int m = resultSet2.getRow();
            resultSet2.beforeFirst();
            if (m == 1){
                //TODO 你猜我想干什么
                return 2;
            }else {
                PreparedStatement pstmtInsert = conn.prepareStatement(sqlInsert);
                pstmtInsert.setString(1, friend.get(0).toString());
                pstmtInsert.setString(2, friend.get(1).toString());
                pstmtInsert.setString(3,friend.get(2).toString());
                pstmtInsert.setString(4, username);
                i = pstmtInsert.executeUpdate();
                if (i == 1) {
                    JDBCUtil.close(conn, pstmtSelect1, resultSet1);
                    JDBCUtil.close(conn,pstmtSelect2,resultSet2);
                    JDBCUtil.close(conn, pstmtInsert, null);
                    return 2;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 3;
    }

    @Override
    public int delFriend(String username1,String username2) {    //username1 del username2
        int i = 0;
        Connection conn = JDBCUtil.get_conn();
        String sql = "DELETE FROM AccountManager.Friends WHERE target=? AND username=?";
        try {
            assert conn != null;
            PreparedStatement pstmt1 = conn.prepareStatement(sql);
            pstmt1.setString(1,username1);
            pstmt1.setString(2,username2);
            i = pstmt1.executeUpdate();
            PreparedStatement pstmt2 = conn.prepareStatement(sql);
            pstmt2.setString(1,username2);
            pstmt2.setString(2,username1);
            pstmt2.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public ArrayList<String> checkFriend(String username) {
        ArrayList<String> list = new ArrayList<>();
        Connection conn = JDBCUtil.get_conn();
        String sql = "SELECT my_nickname,my_username,ip FROM AccountManager.addFriends WHERE you_username=?";
        try {
            assert conn != null;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                list.add(resultSet.getString("my_nickname"));
                list.add(resultSet.getString("my_username"));
                list.add(resultSet.getString("ip"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int addFriend(ArrayList<String> list1, ArrayList<String> list2) {
        Connection conn = JDBCUtil.get_conn();
        String sqlDelete = "DELETE FROM AccountManager.addFriends WHERE my_username=? AND you_username=?";
        String sqlUpdate1 = "INSERT INTO AccountManager.Friends(nickname,username,ip,target) VALUES(?,?,?,?)";
        String sqlUpdate2 = "INSERT INTO AccountManager.Friends(nickname,username,ip,target) VALUES(?,?,?,?)";
        try {
            assert conn != null;
            PreparedStatement pstmt1 = conn.prepareStatement(sqlDelete);
            pstmt1.setString(1,list1.get(1));
            pstmt1.setString(2,list2.get(1));
            pstmt1.executeUpdate();
            PreparedStatement pstmt2 = conn.prepareStatement(sqlUpdate1);
            pstmt2.setString(1,list1.get(0));
            pstmt2.setString(2,list1.get(1));
            pstmt2.setString(3,list1.get(2));
            pstmt2.setString(4,list2.get(1));
            pstmt2.executeUpdate();
            PreparedStatement pstmt3 = conn.prepareStatement(sqlUpdate2);
            pstmt3.setString(1,list2.get(0));
            pstmt3.setString(2,list2.get(1));
            pstmt3.setString(3,list2.get(2));
            pstmt3.setString(4,list1.get(1));
            pstmt3.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
