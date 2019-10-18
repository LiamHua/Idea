package Mariadb;

import java.sql.*;
public class JDBC {
    String url = "jdbc:mariadb://47.98.245.249:3306";
    String user = "liam";
    String password = "password";

    public void con(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("加载驱动成功！");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("连接数据库成功！");

            Statement statement = conn.createStatement();

/*//            修改数据
            int i = statement.executeUpdate("UPDATE test.Student SET Sgrade=70 WHERE Sno='1710050107'");
            System.out.println("本次执行改动了"+i+"行数据");

//            插入数据
            int n = statement.executeUpdate("INSERT INTO test.Student(Sname,Sno) VALUES('傻蛋','17100066666')");
            System.out.println("本次执行添加了"+n+"行数据");

//            删除数据
            int m = statement.executeUpdate("DELETE FROM test.Student WHERE Sname='傻蛋'");
            System.out.println("本次执行删除了"+m+"行数据");*/

            ResultSet resultSet = statement.executeQuery("SELECT  Susername,Spassword FROM AccountManager.Account");
            while(resultSet.next()){
                System.out.print(resultSet.getString("Susername")+"   ");
                System.out.println(resultSet.getString("Spassword")+"   ");
                //System.out.print(resultSet.getInt("Sgrade")+"   ");
                //System.out.print(resultSet.getInt("Sheight")+"   ");
                //System.out.println(resultSet.getInt("Sweight"));
            }
            /*resultSet.last();
            System.out.println(resultSet.getRow());*/
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败！");
        } catch (SQLException e) {
            System.out.println("连接数据库失败！");
        }
    }

   /* public static void main(String[] args){
       JDBC co = new JDBC();
       co.con();

}*/
}