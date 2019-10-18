package example;

import java.sql.*;

public class JDBC implements HelloWorld{
    String url = "jdbc:mariadb://47.98.245.249:3306";
    String user = "liam";
    String password = "password";

    public boolean insertUser(String str) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("加载驱动成功！");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("连接数据库成功！");

            Statement statement = conn.createStatement();

//            修改数据
//            int i = statement.executeUpdate("UPDATE test.Student SET Sgrade=70 WHERE Sno='1710050107'");
//            System.out.println("本次执行改动了"+i+"行数据");

//            插入数据
            //String sql = "INSERT test.Student(Sname) VALUEs"+"("+str+")";
            //System.out.println(sql);
            int n = statement.executeUpdate("INSERT INTO test.Student(Sname) VALUES('huzai')");
            System.out.println("本次执行添加了" + n + "行数据");

//            删除数据
            //           int m = statement.executeUpdate("DELETE FROM test.Student WHERE Sname='傻蛋'");
//            System.out.println("本次执行删除了"+m+"行数据");

            // ResultSet resultSet = statement.executeQuery("SELECT  Sno FROM test.Student WHERE Sname='李泽华'");
            //while(resultSet.next()){
            //System.out.print(resultSet.getString("Sname")+"   ");

            //str = resultSet.getString("Sno");
            //System.out.println(str);
            // System.out.print(resultSet.getInt("Sgrade")+"   ");
            //System.out.print(resultSet.getInt("Sheight")+"   ");
            //System.out.println(resultSet.getInt("Sweight"));
            //}

        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败！");
        } catch (SQLException e) {
            System.out.println("连接数据库失败！");
        };
        return true;
    }

    @Override
    public String sayHello(String str) {
        String s = "hello"+str;
        return s;
    }
}

