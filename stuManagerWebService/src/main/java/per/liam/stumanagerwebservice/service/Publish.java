package per.liam.stumanagerwebservice.service;

import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author liam
 * @date 19-12-18 下午3:11
 */
public class Publish {
    public static void main(String[] args) {
        InputStream resource = Publish.class.getClassLoader().getResourceAsStream("db.properties");
        Properties p = new Properties();
        try {
            p.load(resource);
        } catch (IOException e) {
            System.out.println("加载流文件(URL)失败！");
            e.printStackTrace();
        }
        String address = p.getProperty("publishURL");
        Endpoint.publish(address, new StuManagerImpl());
        System.out.println("服务发布成功！");
    }
}
