import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import per.liam.pojo.UserDao;
import per.liam.pojo.serice.Service;
import per.liam.pojo.serice.ServiceImpl;

/**
 * @author liam
 * @date 19-12-22 下午12:57
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ServiceImpl hello = (ServiceImpl) context.getBean("service");
        hello.getUserDao().getUserName();
    }
}
