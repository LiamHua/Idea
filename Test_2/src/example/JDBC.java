package example;
import javax.jws.WebService;
import java.sql.*;

@WebService(endpointInterface = "example.HelloWorld",targetNamespace = "http://example",wsdlLocation = "HelloWorld.wsdl")
public class JDBC implements HelloWorld {
    private String url = "jdbc:mariadb://47.98.245.249:3306";
    private String user = "liam";
    private String password = "password";
    private int staue;

    boolean NewUser(String user, String password) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("加载驱动成功！");
            Connection conn = DriverManager.getConnection(url, this.user, this.password);
            System.out.println("连接数据库成功！");

            String sql = "INSERT INTO test.Student(Sname,Sno) VALUES(?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user);
            pstmt.setString(2,password);
            System.out.println(password);
            staue = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败！");
        } catch (SQLException e) {
            System.out.println("连接数据库失败！");
        }
        if (staue == 1)
            return true;
        else
            return false;
    }

    @Override
    public boolean newUser() {
        return false;
    }
}